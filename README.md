🛡️ Professional Test Automation Framework (Java/Selenium)

This repository contains a robust, scalable, and professional Test Automation Framework built in Java. 
It follows best practices and advanced design patterns to ensure test stability, maintainability, and enterprise-level reporting.

Module, Topic, Status

1: Foundation, POM, Page Factory, Config",✅ Complete
2: Robustness, Retries, Allure Reports, Screenshots",🟡 In Progress (Setting up Allure)
3: Service Layer, API Testing (RestAssured),⬜ Planned
4: Full-Stack QA, Database Validation (JDBC) & CI/CD,⬜ Planned

Category, Technology, Purpose

Language, Java (JDK 17+), Core programming language.
Automation, Selenium WebDriver, Browser automation tool.
Test Runner, TestNG, Test framework (annotations, groups, parallel execution).
Driver Management, WebDriverManager, Automatic management of browser drivers.
Logging, Log4j2, Professional, configurable logging for test execution.
Reporting,Allure Reports,"Generating detailed, evidence-rich HTML reports.

Category, Technology, Purpose

Language, Java (JDK 17+), Core programming language.
Automation, Selenium WebDriver, Browser automation tool.
Test Runner, TestNG, Test framework (annotations, groups, parallel execution).
Driver Management, WebDriverManager,Automatic management of browser drivers.
Logging, Log4j2, Professional, configurable logging for test execution.
Reporting,Allure Reports,Generating detailed, evidence-rich HTML reports.


🏗️ Architectural Design & Best Practices
The framework is designed for scalability and maintainability, incorporating the following principles:

1. Page Object Model (POM) with Page Factory
All web page interactions are encapsulated in dedicated classes (pages/).

Locators are managed using the @FindBy annotation and initialized via Page Factory.

2. Robustness and Reliability
Explicit Waits (WaitUtils): Custom utility to handle synchronization issues, drastically reducing test flakiness.

Test Retry Analyzer: Implemented using IRetryAnalyzer to automatically re-run failed tests up to 2 times, mitigating transient failures (network, environment).

3. Professional Reporting
Allure Reports: Integration is set up to generate comprehensive and visual reports.

Screenshots on Failure: (Upcoming) Automatic capture of evidence on test failure, linked directly into the Allure report.

⚙️ Setup & Execution
Prerequisites
Java Development Kit (JDK 17 or higher)
Apache Maven
Git
Allure Command Line Tool (required to view reports locally)

1. Clone the Repository
git clone [YOUR_REPOSITORY_LINK]
cd [repository-folder]

2. Install Dependencies
mvn clean install

3. Running the Test Suite
mvn clean test

4. Viewing Allure Reports
allure serve

🤝 Next Steps & Future Features
The following modules are planned to complete the full-stack framework:

1. API Testing: Integrate RestAssured to create API tests.
2. Full-Stack Validation: Implement JDBC to validate data consistency in the database.
3. Continuous Integration: Setup a GitHub Actions pipeline to execute tests automatically on push.
