import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
	kotlin("plugin.jpa") version "1.9.23"
}

group = "br.group.twenty.challenge"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

tasks.jar {
	manifest {
		attributes["Main-Class"] = "br.group.twenty.challenge.TechApplication"
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-mysql")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
	implementation("com.mercadopago:sdk-java:2.1.24")

	compileOnly("org.projectlombok:lombok:1.18.24")
	annotationProcessor("org.projectlombok:lombok:1.18.24")

	testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
//	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	testImplementation("io.mockk:mockk:1.12.0")

	runtimeOnly("com.mysql:mysql-connector-j")

	//Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
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
