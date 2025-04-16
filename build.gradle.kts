plugins {
	java
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") } // Optional, for Spring-related artifacts
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("com.zaxxer:HikariCP")
	implementation("org.xerial:sqlite-jdbc:3.41.2.2")
	implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")


	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

	// Use the stable versions for Springdoc OpenAPI UI and Data Rest
//	implementation("org.springdoc:springdoc-openapi-ui:2.0.0")
//	implementation("org.springdoc:springdoc-openapi-data-rest:2.0.0")


	// Add SQLite Dialect dependency
	implementation("org.hibernate:hibernate-core:5.6.9.Final")
	implementation("org.xerial:sqlite-jdbc:3.41.2.2")
	implementation("org.hibernate.orm:hibernate-community-dialects")

	// Lombok
	compileOnly("org.projectlombok:lombok:1.18.24")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


tasks.withType<Test> {
	useJUnitPlatform()
}
