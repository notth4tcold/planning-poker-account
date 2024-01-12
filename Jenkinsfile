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
                    sh 'sed -i "s/{{tag}}/$tag_version/g" ./deploy/deploy.yaml'
                    sh 'kubectl apply -f ./deploy/deploy.yaml'
                }
            }
        }
    }
}