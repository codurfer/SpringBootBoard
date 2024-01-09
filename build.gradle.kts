plugins {
    id("java")
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "me.learn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2") // 인메모리 데이터베이스
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok") // 롬복
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // 타임리프
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    // 스프링 시큐리티
    implementation("org.springframework.boot:spring-boot-starter-security")
    // 타임리프에서 스프링 시큐리티를 사용
    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
    // 자바 JWT 라이브러리
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    // XML 문서와 자바 객체 간 매핑 자동화
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    // OAuth2 사용을 위한 스타터 추가
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
}

tasks.test {
    useJUnitPlatform()
}