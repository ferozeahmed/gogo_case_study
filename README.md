Automation Framework
A Selenium project for automating functional tests.
The frameowrk is built with TestNG, Java, Selenium WebDriver, Extent reports.
Maven is build tool used for building this selenium project.
As per the above maven project, all the tests are kept in the ‘src/test/java‘ and remaining files (such as element locators (POM classes), utility files, pages, etc.,) kept under ‘src/main/java‘.

Language: In this Selenium Project i am using Java language. Even though Selenium supports multiple languages, I am  using Java language is just because most of the automation developers have knowledge on Selenium with Java.

Design of Framework: In this project, we are using Page Object Model design pattern. POM: As per the Page Object Model, we have maintained a class for every web page. Each web page has a separate class and that class holds the functionality and members of that web page. Separate classes for every individual test.

Packages: We have separate packages for Pages and Tests. All the web page related classes come under Pages package and all the tests related classes come under src/test/java/case_study package.

Reporting: Extent reports package is used to capture reports. Screen shot for failed tests can be caputred using extent reports framework

Test Data: @DataProvider parameter of testNG framework is used to pass test data

TestNG: Using TestNG for Assertions, Grouping and Parallel execution.

Maven: Using Maven for build, execution and dependency purpose. Integrating the TestNG dependency in POM.xml file and running this POM.xml file using Jenkins.

Requirements
In order to utilise this project you need to have the following installed locally:
- Maven 3
- Chrome and Chromedriver (UI tests use Chrome by default, can be changed in config)
- Java 1.8

Usage
This a Maven project.
To run all modules, navigate to case_study directory and run:
mvn clean install
mvn clean test -DsuiteXmlFile=testng.xml

Reporting
Reports for each module are written into the /test-output directories after a successful run.
Extent report framework is used to capture test run results
/test-output/extentReport.html file will have test run result.