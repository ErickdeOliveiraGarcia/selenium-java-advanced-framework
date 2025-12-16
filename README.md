# Selenium Java Advanced Framework

[![Java CI with Maven](https://github.com/your-username/selenium-java-advanced-framework/actions/workflows/maven.yml/badge.svg)](https://github.com/your-username/selenium-java-advanced-framework/actions/workflows/maven.yml)
[![Allure Report](https://img.shields.io/badge/Allure-Report-green.svg)](https://your-username.github.io/selenium-java-advanced-framework/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A robust Test Automation Framework for UI and API testing, built with Selenium, Java, and TestNG. This project demonstrates a scalable and maintainable architecture for enterprise-level test automation.

## ✨ Key Features

-   **UI & API Testing**: Comprehensive test suites for both web interfaces and RESTful APIs.
-   **Page Object Model (POM)**: For clean, maintainable, and reusable UI test code.
-   **Centralized API Client**: A reusable RestAssured setup for streamlined API testing.
-   **Multi-Browser Support**: Easily configurable for Chrome, Firefox, and other browsers.
-   **Headless Execution**: Run UI tests in a headless environment, perfect for CI/CD pipelines.
-   **Allure Reports**: Generate beautiful, interactive, and detailed test reports.
-   **CI/CD with GitHub Actions**: Automated build, test, and reporting pipeline.
-   **Secure API Key Management**: Loads API keys from environment variables, system properties, or a local `.env` file.

## 🛠️ Tech Stack

-   **Java 11**
-   **Selenium WebDriver**: For browser automation.
-   **TestNG**: As the testing framework.
-   **RestAssured**: For REST API testing.
-   **Apache Maven**: For dependency management and building the project.
-   **Allure Framework**: For test reporting.
-   **GitHub Actions**: For CI/CD.

## 🚀 Getting Started

### Prerequisites

-   **JDK 11** or higher.
-   **Apache Maven**.
-   **Google Chrome** or **Mozilla Firefox**.

### Local Setup & Execution

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/selenium-java-advanced-framework.git
    cd selenium-java-advanced-framework
    ```

2.  **API Key Configuration (Optional):**
    For API tests, create a `.env` file in the project root and add your API key:
    ```
    API_KEY="your_api_key_here"
    ```

3.  **Run Tests:**
    -   **Run all tests:**
        ```bash
        mvn clean test
        ```
    -   **Run a specific TestNG suite:**
        ```bash
        mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
        ```

## 📊 Allure Reports

After running the tests, generate and view the Allure report:

```bash
allure serve
```

This will open a detailed, interactive report in your default browser.

## 🔄 CI/CD Pipeline

This project uses **GitHub Actions** for continuous integration. The workflow is defined in `.github/workflows/maven.yml`.

-   **Trigger**: The pipeline runs on every `push` or `pull_request` to the `main` branch.
-   **Secrets**: For the pipeline to run API tests successfully, you must add your API key as a secret in your GitHub repository:
    -   Navigate to `Settings` > `Secrets and variables` > `Actions`.
    -   Create a new secret named `API_KEY` with your API key as the value.

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
