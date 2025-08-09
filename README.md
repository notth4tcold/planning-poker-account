
# Kotlin App 🚀

Application that manages accounts, using Kotlin, Spring Boot, MongoDB and Kafka for event-driven communication.

This project follows Hexagonal Architecture principles and uses Kafka as message broker to produce and consume domain events, enabling scalable and reactive microservices.

- Kotlin application
- Spring Boot version 3
- Java 17
- MongoDB for persistence
- Kafka for event streaming and messaging

---

### 🔧 Prerequisites

Make sure you have installed the following tools before proceeding:

- Docker
- Kubernetes Kind
- Jenkins

---

### 🚀 How to start the application in Kubernetes

1. Create a Kind cluster:
   ```bash
   kind create cluster --config=kind-config.yaml
   ```

2. Deploy NGINX ingress:
   ```bash
   kubectl apply -f ./deploy/ingress-nginx.yaml
   ```
   *(Update ingress-nginx manifest if needed)*
   ```bash
   curl -L -o ./deploy/ingress-nginx.yaml https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/kind/deploy.yaml
   ```

3. Wait for ingress controller to be ready:
   ```bash
   kubectl wait --namespace ingress-nginx --for=condition=ready pod --selector=app.kubernetes.io/component=controller --timeout=90s
   ```

4. Deploy MongoDB:
   ```bash
   kubectl apply -f ./deploy/mongo_db_deploy.yaml
   ```

5. Deploy Kafka:
   ```bash
   kubectl apply -f ./deploy/kafka_deploy.yaml
   ```

6. Use the Jenkinsfile for CI/CD in Jenkins (remember to configure credentials),  
   **OR** follow the steps below to build and run manually:

7. Build executable jar:
   ```bash
   ./gradlew clean build bootJar
   ```

8. Build Docker image:
   ```bash
   docker build -t DOCKER_USERNAME/kotlin-app .
   ```

9. Push image to Docker Hub:
   ```bash
   docker push DOCKER_USERNAME/kotlin-app
   ```

10. Deploy the app in Kubernetes:
    ```bash
    kubectl apply -f ./deploy/deploy.yaml
    ```

> ⚙️ *If needed, use port-forwarding to connect to MongoDB or Kafka-UI:*
> ```bash
> kubectl port-forward mongodb-pod-name 27017:27017
> kubectl port-forward kafka-ui-pod-name 8081:8080
> ```
> Then connect using MongoDB Compass or access Kafka UI in browser.

---

### 🛠️ How to start the application locally for testing

- Start MongoDB using Docker Compose:
  ```bash
  docker-compose up -d
  ```

- Run the application in any IDE (set environment variables):
  ```
  MONGO_DB_HOST=mongodb
  MONGO_DB_USER=mongouser
  MONGO_DB_PASSWORD=mongopassword
  KAFKA_BROKERS=localhost:9093
  ```

- Or run directly via Gradle with env vars:
  ```bash
  MONGO_DB_HOST=localhost MONGO_DB_USER=mongouser MONGO_DB_PASSWORD=mongopassword KAFKA_BROKERS=localhost:9093 ./gradlew bootRun
  ```

---

### 📌 Observations

- This application uses **Hexagonal Architecture** (without fully isolating Spring Framework)
- Uses a simple **RestControllerAdvice** for exception handling
- Includes **Spring Boot Actuator** for monitoring
- Integrates with **Kafka** for event-driven communication

---

Feel free to contribute or open issues if you find bugs or have suggestions!  
