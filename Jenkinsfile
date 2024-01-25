pipeline {
    agent any

    stages {
        stage ('Build') {
            environment {
                mongo_db_host = credentials('MONGO_DB_HOST')
                mongo_db_user = credentials('MONGO_DB_USER')
                mongo_db_password = credentials('MONGO_DB_PASSWORD')
            }
            steps {
                bat 'set MONGO_DB_HOST=$mongo_db_host'
                bat 'set MONGO_DB_USER=$mongo_db_user'
                bat 'set MONGO_DB_PASSWORD=$mongo_db_password'
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
            }
            steps {
                withKubeConfig([credentialsId: 'kubeconfig']) {
                    powershell("(gc ./deploy/deploy.yaml) -replace '{{TAG}}', '$tag_version' | Out-File -encoding ASCII ./deploy/deploy.yaml")
                    bat 'kubectl apply -f ./deploy/deploy.yaml'
                }
            }
        }
    }
}