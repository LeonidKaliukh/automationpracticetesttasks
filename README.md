## 1. Selenium UI automation task
Summary:
- Selenium WebDriver/Selenide for web interactions
- Automation patterns like *PageObject*, *data-driven* tests, etc.
- TestNG testing framework
- Ability to run tests for different browsers by configuring

You will need the following technologies available to try it out:
* Maven 3+
* JDK 8
* IDE of your choice 
* Web browser Chrome

### How to run only UI tests
```mvn test -Dtest=UITest```

## 2. API automation task
   Summary:
- RestAssured framework

### How to run only API tests
```mvn test -Dtest=APITest```

### How to run all TestSuite

```mvn clean test```

### Generate Allure report 

```mvn allure:report```

### Open Allure report in browser

```mvn allure:serve```