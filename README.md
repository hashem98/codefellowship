# Codefellowship Application
* This application contains the basic authorization login,logout,security and passwordEncoder and save the data in table in dataBase

* you can signup if you don't have username in dataBase

* if you have userName in dataBase you can log in , after login Successfully you will redirect to the home page of teh application

* you can see your personal data in profile page

# how to run application
* Clone this repo
* add dependencies
```
dependencies {
implementation group: 'org.thymeleaf.extras', name: 'thymeleaf-extras-springsecurity4', version: '3.0.4.RELEASE'
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
implementation 'org.springframework.boot:spring-boot-starter-web'
developmentOnly 'org.springframework.boot:spring-boot-devtools'
implementation 'org.postgresql:postgresql'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
testImplementation 'org.springframework.security:spring-security-test'
}
```
* Change the information in application.properties file
* run with IDEA or ``./gradlew bootRun`` on terminal
* Visit ``http://localhost:8080/``
# how to use ny app
* in Home page you can see the Friends' suggestions
* in Profile page you can see your info if you loged in
* in feed page you can see your friend's posts
* finally yo have a logout button
# * run with IDEA or ``./gradlew bootRun`` on terminal