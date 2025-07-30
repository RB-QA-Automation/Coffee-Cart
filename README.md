# Coffee Cart - Java Selenium Automation Framework

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.java.com)
[![Selenium](https://img.shields.io/badge/Selenium-4.21.0-green.svg)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.10.2-orange.svg)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.13.0-red.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is a comprehensive test automation framework built using **Java**, **Selenium**, and **TestNG** to test the "Coffee Cart" web application. The framework is designed to be robust, maintainable, and scalable, following the **Page Object Model (POM)** design pattern. It supports data-driven testing, generates detailed reports, and can be easily integrated into a CI/CD pipeline.

---

## Features ✨

* **Page Object Model (POM):** The framework is built using the POM design pattern to ensure maintainability and reduce code duplication.
* **Data-Driven Testing:** It uses Apache POI to read test data from Excel files, allowing for easy testing of multiple scenarios with different data sets.
* **TestNG Framework:** TestNG is used for managing and executing test cases, with support for test suites, groups, and parallel execution.
* **ExtentReports:** The framework generates detailed and interactive HTML reports with screenshots for failed tests, providing a clear overview of the test results.
* **Log4j Logging:** It uses Log4j for logging, which helps in debugging and understanding the test flow.
* **Configuration Management:** Test settings such as browser type, base URL, and user credentials can be easily managed through a `config.properties` file.
* **Maven Build Tool:** The project uses Maven for dependency management and building the project.

---

## Technologies Used 💻

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Reporting:** ExtentReports
* **Logging:** Log4j
* **Data-Driven:** Apache POI

---

## Getting Started 🚀

To get started with this project, follow these steps:

### Prerequisites

* **Java Development Kit (JDK) 17 or higher**
* **Maven** installed and configured
* An **IDE** such as Eclipse or IntelliJ IDEA
* **Google Chrome** browser

### Setup

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/RB-QA-Automation/Coffee-Cart.git](https://github.com/RB-QA-Automation/Coffee-Cart.git)
    ```
2.  **Import the project:**
    * Open your IDE (Eclipse or IntelliJ).
    * Import the project as a Maven project.
    * Maven will automatically download all the required dependencies listed in the `pom.xml` file.

### Configuration

* The main configuration file is located at `src/test/java/resources/config.properties`.
* You can modify this file to change the browser, base URL, and other settings.

### Running Tests

You can run the tests in the following ways:

1.  **Using TestNG Suite XML files:**
    * The project includes TestNG suite files in the `Test Runs` directory.
    * You can run these files directly from your IDE to execute the test suites.

2.  **Using Maven Profiles:**
    * The `pom.xml` is configured with two Maven profiles: `single-user` and `multi-user`.
    * Open a terminal or command prompt and navigate to the project's root directory.

    * To run the **single-user** test suite, use the following command:
        ```bash
        mvn test -P single-user
        ```

    * To run the **multi-user** test suite, use the following command:
        ```bash
        mvn test -P multi-user
        ```

---

## Project Structure 📁

The project follows a standard Maven project structure:

```
├── CoffeCart
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   └── resources
│   │   └── test
│   │       ├── java
│   │       │   ├── base
│   │       │   ├── pom
│   │       │   ├── resources
│   │       │   ├── testCases
│   │       │   └── Utilities
│   │       └── resources
│   ├── Test Runs
│   ├── pom.xml
│   └── README.md
```

* `src/test/java/base`: Contains base classes for the framework, such as `BaseTest` and `BasePage`.
* `src/test/java/pom`: Includes all the Page Object Model classes.
* `src/test/java/testCases`: Contains the TestNG test classes.
* `src/test/java/resources`: Stores configuration files and test data.
* `src/test/java/Utilities`: Contains utility classes for reading configuration, Excel files, and generating reports.
* `Test Runs`: Includes TestNG suite XML files for running different test suites.
* `pom.xml`: The Maven Project Object Model file, which contains all the project dependencies and configurations.

---

## Test Data 📝

The framework supports data-driven testing using an Excel file.

* **Location:** The test data file is located at `src/test/java/resources/Data Driven Testing - Coffee Cart.xlsx`.
* **Format:** The file has a `Sheet1` with "Name" and "Email" columns.
* **To add more test data:** Simply add new rows to the Excel sheet with the required data. The framework will automatically pick up the new data and run the tests for each row.

---

## Reporting 📊

The framework generates detailed HTML reports using **ExtentReports**. The reports are saved in the `target/extent-reports` directory after the test execution is complete. The reports provide a comprehensive overview of the test results, including passed, failed, and skipped tests, along with screenshots for any failed test cases.

---

## Contributing 🤝

Contributions are welcome! If you would like to contribute to this project, please follow these steps:

1.  **Fork the repository.**
2.  **Create a new branch:**
    ```bash
    git checkout -b feature/your-feature-name
    ```
3.  **Make your changes and commit them:**
    ```bash
    git commit -m "Add some feature"
    ```
4.  **Push to the branch:**
    ```bash
    git push origin feature/your-feature-name
    ```
5.  **Create a new Pull Request.**

---


## Author 👨‍💻

* **Raja Bhamra** - [RB-QA-Automation](https://github.com/RB-QA-Automation)




