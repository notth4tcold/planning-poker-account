# Kotlin App

Application that manages accounts

- Kotlin application
- Spring Boot version 3
- Java 17

### First you'll need to Download/Install: :hammer_and_wrench:

- Docker
- Kubernetes Kind
- Jenkins

### How to start application: :hammer:

- Make up or use the steps below
- Create cluster in Kind using: `kind create cluster --config=kind-config.yaml`
- Create NGINX ingress using: `kubectl apply -f ./deploy/ingress-nginx.yaml` (Update ingress-nginx to the latest version if needed
  curl -L -o ./deploy/ingress-nginx.yaml https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/kind/deploy.yaml)
- Wait till ingress is running using: `kubectl wait --namespace ingress-nginx --for=condition=ready pod --selector=app.kubernetes.io/component=controller --timeout=90s`
- Create MongoDb using: `kubectl apply -f ./deploy/mongo_db_deploy.yaml`
- Create Kafka using: `kubectl apply -f ./deploy/kafka_deploy.yaml`
- Use the JekinsFile to do the CI/CD in Jenkins to build and run the application ( remember to create the credentials ) OR use the steps below
- Create the executable jar file using: `./gradlew clean build bootJar`
- Build image using: `docker build -t DOCKER_USERNAME/kotlin-app .`
- Push image to docker hub using: `docker push DOCKER_USERNAME/kotlin-app`
- Run application using: `kubectl apply -f ./deploy/deploy.yaml`

  \*\* :gear: If needed use Port-Forward to create a connection to MongoDb and connect using MongoDBCompass: `kubectl port-forward mongodb-pod-name 27017:27017` or Kafka-UI `q`

### How to start Application to test locally: :hammer:

- Use `docker-compose up -d` to start MongoDB
- Run application using any IDE (remember to set ENV variables `MONGO_DB_HOST=mongodb;MONGO_DB_USER=mongouser;MONGO_DB_PASSWORD=mongopassword;KAFKA_BROKERS=localhost:9093`)
- Or run using: `MONGO_DB_HOST=localhost MONGO_DB_USER=mongouser MONGO_DB_PASSWORD=mongopassword KAFKA_BROKERS=localhost:9093 ./gradlew bootRun`

### Observations: :pushpin:

- This application is using Hexagonal Architecture (without isolating Spring Framework)
- This application is using a simple RestControllerAdvice
- This application is using Actuator
