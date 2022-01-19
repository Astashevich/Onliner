# Onliner
#### The Test Automation Framework is developed using the following technologies:

- Java 8.
- Maven.
- TestNG as an assertion library.
- Awaitility for asynchronous actions.
- Cucumber for BDD tests.
- Log4j2 for logging.
- Allure for reporting. 
- Monte screen recorder for recording video of tests.
- JavaFaker for creating pretty random data

And next plugins :

- Maven surefire plugin.
- Maven compiler plugin.

##TAF Features overview:

1. Failed tests are rerun 2 times;

2. Test annotations.

- Each test method has next mandatory annotations :

```@TestType``` - contains the name of the test types;

```@Test``` - contains  short test name and its test case ID;

### Test Execution

Launch examples.

####Running tests from command line :
```mvn clean test```

Test cases can be run with next options :

- Running test cases from selected browser;
- Running test cases with selected environment;
- Running test cases with selected threads-count;

Default Options:

- Browser = Chrome;
- Environment = Local;
- Threads-count = 2;

Set Options:

```-Dbrowser={browser}```

```-Denv={environment}```

```-DtreadCount={treadCount}```

Supported Browsers: ```Chrome, Edge, Opera, Firefox```

Environment: ```LOCAL, QA, DEV```

Next command will run all the tests on QA environment in Opera browser with one thread:

```mvn clean test -Denv=qa -Dbrowser=opera -DtreadCount=1```

Next command will run all the tests in selected Browser :

```mvn test -Dbrowser=edge```

####Running tests in IDE :

- Right click on the testng.xml -> Run Test;

### Reporting

Test result report is generated in ```target/allure-results``` folder by default .

All the needed objects and files are attached to the report.

- To view test result report run next command in terminal :
```allure serve target/allure-results```

- To generate test result report run next command in terminal :

```allure generate target/allure-results ```