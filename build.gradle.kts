import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.21"
	kotlin("plugin.spring") version "1.9.21"
	kotlin("plugin.noarg") version "1.9.21"
}

group = "com.alexeiaj"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

	implementation("org.springframework.cloud:spring-cloud-starter-stream-kafka:4.1.0")

//	implementation("org.springframework.cloud:spring-cloud-starter")
//	implementation("org.springframework.cloud:spring-cloud-starter-stream-kafka:3.1.1")
//	implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
//	implementation("org.springframework.cloud:spring-cloud-starter-config")
//	implementation("org.springframework.cloud:spring-cloud-stream")
//	implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka")
//	implementation("org.apache.kafka:kafka-streams")
//	implementation("org.springframework.kafka:spring-kafka")
//	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//	implementation("io.micrometer:micrometer-tracing-bridge-brave")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

noArg {
	annotation("com.alexeiaj.planningpokeraccount.core.common.annotation.NoArgsConstructor")
}

tasks.getByName<Jar>("jar") {
	enabled = false
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
