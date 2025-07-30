# Coffee Cart - Java Selenium Automation Framework

This is a comprehensive test automation framework built using **Java**, **Selenium**, and **TestNG** to test the "Coffee Cart" web application. The framework is designed to be robust, maintainable, and scalable, following the **Page Object Model (POM)** design pattern. It supports data-driven testing, generates detailed reports, and can be easily integrated into a CI/CD pipeline.

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

* **Java Development Kit (JDK)** installed on your machine.
* **Maven** installed and configured.
* An **IDE** such as Eclipse or IntelliJ IDEA.

### Setup

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
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

2.  **Using Maven:**
    * Open a terminal or command prompt and navigate to the project's root directory.
    * Run the following command to execute the tests:
        ```bash
        mvn test
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

## Reporting 📊

The framework generates detailed HTML reports using **ExtentReports**. The reports are saved in the `target/extent-reports` directory after the test execution is complete. The reports provide a comprehensive overview of the test results, including passed, failed, and skipped tests, along with screenshots for any failed test cases.





