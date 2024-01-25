pipeline {
    agent any

    stages {
        stage ('Build') {
            environment {
                app_encryption_password = credentials('app_encryption_password')
            }
            steps {
                bat 'set APP_ENCRYPTION_PASSWORD=$app_encryption_password gradlew.bat clean build bootJar'
            }
        }

        stage ('Generate Image') {
            steps {
                script {
                    dockerapp = docker.build("alexeiaj/planning-poker-account", '-f ./Dockerfile ./')
                }
            }
        }

        stage ('Push Image') {
            environment {
                tag_version = "${env.BUILD_ID}"
            }
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        dockerapp.push('latest')
                        dockerapp.push("$tag_version")
                    }
                }
            }
        }

        stage ('Deploy Kubernetes') {
            environment {
                tag_version = "${env.BUILD_ID}"
                app_encryption_password = credentials('app_encryption_password')
            }
            steps {
                withKubeConfig([credentialsId: 'kubeconfig']) {
                    powershell("(gc ./deploy/deploy.yaml) -replace '{{TAG}}', '$tag_version' | Out-File -encoding ASCII ./deploy/deploy.yaml")
                    powershell("(gc ./deploy/deploy.yaml) -replace '{{APP_ENCRYPTION_PASSWORD}}', '$app_encryption_password' | Out-File -encoding ASCII ./deploy/deploy.yaml")
                    bat 'kubectl apply -f ./deploy/deploy.yaml'
                }
            }
        }
    }
}