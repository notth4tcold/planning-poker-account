pipeline {
    agent any

    stages {
        stage ('Build') {
            steps {
                bat 'gradlew.bat clean build bootJar'
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
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        dockerapp.push('latest')
                        dockerapp.push("${env.BUILD_ID}")
                    }
                }
            }
        }

        stage ('Deploy Kubernetes') {
            environment {
                tag_version = "${env.BUILD_ID}"
            }
            steps {
                withKubeConfig([credentialsId: 'kubeconfig']) {
                    powershell("(gc ./deploy/deploy.yaml) -replace '{{tag}}', '$tag_version' | Out-File -encoding ASCII ./deploy/deploy.yaml")
                    bat 'kubectl apply -f ./deploy/deploy.yaml'
                }
            }
        }
    }
}