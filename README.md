# Enterprise E-Commerce API Test Automation Framework

A production-grade, end-to-end REST API automation framework for comprehensive e-commerce application testing. Built with industry-standard tools including REST Assured, Cucumber BDD, and Maven, this framework provides complete test coverage for user authentication, product lifecycle management, and order processing workflows.

---

## 🎯 What This Project Does

### The Problem
When companies build online shopping platforms (like Amazon or Shopify stores), they need to ensure that critical features work correctly every time:
- Can users log in securely?
- Can sellers add new products with images and descriptions?
- Can customers place orders successfully?
- Is the checkout process reliable?

Manually testing these features after every code change is **time-consuming, error-prone, and expensive**. A single bug in the checkout process could mean lost sales and frustrated customers.

### The Solution
This project is an **automated testing system** that acts like a tireless quality assurance team. It automatically verifies that an e-commerce platform's backend services work correctly by:

- **Testing user authentication** – Ensures login/logout works with valid credentials and properly rejects invalid ones
- **Testing product management** – Verifies sellers can add, update, and remove products from the catalog
- **Testing order processing** – Confirms the entire purchase flow from cart to order confirmation
- **Generating detailed reports** – Creates visual reports showing what passed, what failed, and why

### Business Value
| Benefit | Impact |
|---------|--------|
| **Faster releases** | Tests run in minutes vs. hours of manual testing |
| **Higher quality** | Catches bugs before they reach customers |
| **Cost savings** | Reduces manual QA effort by 70-80% |
| **Confidence** | Deploy updates knowing critical flows are verified |
| **Documentation** | Test scenarios serve as living documentation of system behavior |

### Skills Demonstrated
- **Test Automation Architecture** – Designed a scalable, maintainable framework from scratch
- **API Testing** – Deep understanding of REST APIs, HTTP methods, and response validation
- **BDD Methodology** – Writing tests in plain English that business stakeholders can understand
- **Design Patterns** – Applied industry best practices (Page Object Model, Dependency Injection, Builder Pattern)
- **CI/CD Ready** – Framework integrates seamlessly with Jenkins, GitHub Actions, or any CI pipeline

---

## Technology Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 8+ | Core programming language |
| **REST Assured** | 6.0.0 | REST API testing and validation |
| **Cucumber** | 7.16.1 | BDD framework for readable test scenarios |
| **PicoContainer** | 7.16.1 | Dependency injection for step definitions |
| **JUnit Jupiter** | 5.10.2 | Test execution framework |
| **JUnit Platform Suite** | 1.10.2 | Test suite orchestration |
| **TestNG** | 7.8.0 | Alternative testing framework support |
| **Maven** | 3.6+ | Build automation and dependency management |
| **Jackson Databind** | 3.0.3 | JSON serialization/deserialization |
| **Hamcrest** | 2.2 | Fluent assertion matchers |
| **Groovy** | 3.0.25 | JSON path expressions and assertions |
| **Maven Cucumber Reporting** | 5.0.0 | Enhanced HTML test reports |

## Detailed Project Structure

```
EcommAPIAutomation/
│
├── src/
│   ├── main/
│   │   ├── java/                                    # Main application code (reserved)
│   │   └── resources/                               # Main application resources
│   │
│   └── test/
│       ├── java/
│       │   │
│       │   ├── cucumber/
│       │   │   └── Options/
│       │   │       └── TestRunner.java              # Cucumber test runner with JUnit Platform
│       │   │                                        # Configures feature paths, glue code, plugins
│       │   │                                        # Generates JSON and HTML reports
│       │   │
│       │   ├── featureFiles/                        # Gherkin feature files (BDD scenarios)
│       │   │   ├── Login.feature                    # User authentication test scenarios
│       │   │   │                                    # - Positive: Valid credentials login
│       │   │   │                                    # - Negative: Invalid credentials validation
│       │   │   │                                    # - Data-driven with Examples table
│       │   │   │
│       │   │   └── AddProduct.feature               # Complete e-commerce workflow
│       │   │                                        # - Background: User login setup
│       │   │                                        # - Add product with multipart form data
│       │   │                                        # - Create order for product
│       │   │                                        # - View order details
│       │   │                                        # - Delete product and order (cleanup)
│       │   │
│       │   ├── pojo/                                # Plain Old Java Objects (Data Models)
│       │   │   ├── Login.java                       # Login request payload
│       │   │   │                                    # Fields: userEmail, userPassword
│       │   │   │
│       │   │   ├── LoginResponse.java               # Login API response model
│       │   │   │                                    # Fields: token, userId, message
│       │   │   │
│       │   │   ├── Orders.java                      # Order creation request payload
│       │   │   │                                    # Fields: List<OrderDetails>
│       │   │   │
│       │   │   ├── OrderDetails.java                # Individual order item details
│       │   │   │                                    # Fields: country, productOrderedId
│       │   │   │
│       │   │   ├── OrderCreatedResponse.java        # Order creation response model
│       │   │   │                                    # Fields: orderId, message
│       │   │   │
│       │   │   └── productCreatedResponse.java      # Product creation response model
│       │   │                                        # Fields: productId, message
│       │   │
│       │   ├── resources/                           # Test utilities and configuration
│       │   │   ├── APIResources.java                # Enum defining all API endpoints
│       │   │   │                                    # - Endpoint paths (login, addProduct, etc.)
│       │   │   │                                    # - HTTP methods (GET, POST, DELETE)
│       │   │   │                                    # - getResource() method for path retrieval
│       │   │   │
│       │   │   ├── TestData.java                    # Test data builder class
│       │   │   │                                    # - addProductPayload(): Creates product data
│       │   │   │                                    # - loginPayload(): Creates login credentials
│       │   │   │                                    # - orderPayload(): Creates order request
│       │   │   │
│       │   │   ├── Utils.java                       # Core utility methods
│       │   │   │                                    # - requestSpecification(): Base request setup
│       │   │   │                                    # - getJsonPath(): Response parsing
│       │   │   │                                    # - getGlobalValue(): Property file reader
│       │   │   │
│       │   │   └── global.properties                # Environment configuration
│       │   │                                        # - baseUrl: API base URL
│       │   │                                        # - credentials: Test user credentials
│       │   │
│       │   └── stepDefination/
│       │       └── StepDefination.java              # Cucumber step definitions
│       │                                            # - Implements all Gherkin steps
│       │                                            # - API request/response handling
│       │                                            # - Multipart form data for file uploads
│       │                                            # - Response validations and assertions
│       │                                            # - Context sharing via PicoContainer
│       │
│       └── resources/                               # Test resource files
│           └── (Additional test resources)
│
├── target/                                          # Maven build output directory
│   ├── classes/                                     # Compiled main classes
│   ├── test-classes/                                # Compiled test classes
│   ├── cucumber-reports/                            # Cucumber HTML reports
│   ├── cucumber-html-reports/                       # Enhanced HTML reports (verify phase)
│   ├── jsonReports/                                 # JSON format test reports
│   │   └── Cucumber.json                            # Cucumber JSON output
│   ├── allure-results/                              # Allure report data (if configured)
│   └── surefire-reports/                            # Maven Surefire test reports
│
├── .settings/                                       # Eclipse IDE settings
│   ├── org.eclipse.jdt.core.prefs                   # Java compiler preferences
│   └── org.eclipse.m2e.core.prefs                   # Maven Eclipse plugin settings
│
├── pom.xml                                          # Maven Project Object Model
│   │                                                # - Project coordinates (groupId, artifactId)
│   │                                                # - Dependencies (REST Assured, Cucumber, etc.)
│   │                                                # - Build plugins (Surefire, Cucumber Reporting)
│   │                                                # - Compiler configuration
│
├── .classpath                                       # Eclipse classpath configuration
├── .project                                         # Eclipse project configuration
├── .gitattributes                                   # Git attributes (language detection)
├── logging.txt                                      # Application/test execution logs
└── README.md                                        # Project documentation
```

## Architecture & Design Patterns

### 1. **Behavior-Driven Development (BDD)**
- Gherkin syntax for human-readable test scenarios
- Business stakeholder collaboration through feature files
- Living documentation that stays in sync with tests

### 2. **Dependency Injection (PicoContainer)**
- Shares context between step definitions
- Manages object lifecycle automatically
- Eliminates static variables and singleton patterns

### 3. **Data Transfer Objects (POJO Pattern)**
- Type-safe request/response handling
- Automatic JSON serialization/deserialization
- Clear contract definition for API payloads

### 4. **Resource Enum Pattern**
- Centralized API endpoint management
- Type-safe endpoint references
- Easy maintenance and updates

### 5. **Builder Pattern (TestData)**
- Fluent API for test data creation
- Reusable payload builders
- Separation of test data from test logic

### 6. **Utility Pattern**
- Reusable helper methods
- Configuration management
- Response parsing and validation

## Key Framework Components

### Feature Files (`featureFiles/`)

**Login.feature**
- Authentication testing with data-driven scenarios
- Positive and negative test cases
- Cucumber Examples table for parameterization
- Status code and response message validation

**AddProduct.feature**
- Complete e-commerce workflow with background steps
- Product creation with multipart form data
- Order placement and verification
- Cleanup operations (delete product/order)

### POJO Classes (`pojo/`)

**Request Models:**
- `Login.java` - User authentication credentials
- `Orders.java` - Order creation with product list
- `OrderDetails.java` - Individual order item details

**Response Models:**
- `LoginResponse.java` - Authentication response with token
- `productCreatedResponse.java` - Product creation confirmation
- `OrderCreatedResponse.java` - Order placement confirmation

**Purpose:**
- Type-safe API contracts
- Automatic JSON serialization/deserialization via Jackson
- Clear data structure documentation

### Resources (`resources/`)

**APIResources.java**
- Enum defining all API endpoints and HTTP methods
- Centralized endpoint management
- `getResource()` method returns endpoint path

**TestData.java**
- Dynamic payload creation for different APIs
- `addProductPayload()` - Product creation data
- `loginPayload()` - User credentials
- `orderPayload()` - Order request with product IDs

**Utils.java**
- `requestSpecification()` - Base request configuration
- `getJsonPath()` - Response parsing utility
- `getGlobalValue()` - Property file reader

**global.properties**
- Environment configuration (base URL, credentials)
- Externalized test data
- Easy environment switching

### Step Definitions (`stepDefination/`)

**StepDefination.java**
- Implements all Gherkin steps from feature files
- Handles API request construction and execution
- Manages multipart form data for file uploads
- Performs response validations and assertions
- Uses PicoContainer for context sharing between steps
- Extracts dynamic data (productId, orderId, userId)

### Test Runner (`cucumber/Options/`)

**TestRunner.java**
- JUnit Platform Suite configuration
- Cucumber options:
  - Feature file paths
  - Step definition glue code
  - Report plugins (JSON, HTML)
  - Tags for selective execution
- Entry point for test execution

## Test Scenarios Covered

### 1. Login API Testing
- **Positive Scenario** - Valid credentials login
- **Negative Scenario** - Invalid credentials validation
- Status code verification (200 for success, 400 for failure)
- Response message validation

### 2. Complete E-commerce Workflow
- **User Authentication** - Login with valid credentials
- **Product Management**
  - Add new product with form data (name, category, price, image)
  - Product creation validation
  - Extract product ID for subsequent operations
- **Order Management**
  - Create order for added product
  - Order placement verification
  - Extract order ID
  - View order details
- **Cleanup Operations**
  - Delete created product
  - Delete created order
  - Verify deletion success

### Features
- Data-driven testing with Cucumber Examples
- Background steps for common setup (user login)
- Multi-part form data handling for product images
- API chaining and response extraction
- Complete CRUD operations testing
- End-to-end workflow validation

## Prerequisites

- Java 8 or higher
- Maven 3.6+
- IDE (Eclipse/IntelliJ IDEA)
- Valid e-commerce API credentials

## Setup Instructions

1. Clone the repository
```bash
git clone <repository-url>
cd EcommAPIAutomation
```

2. Install dependencies
```bash
mvn clean install
```

3. Update test data in feature files:
   - User credentials in `featureFiles/Login.feature`
   - Product details in `featureFiles/AddProduct.feature`
   - Image path for product upload

## Running Tests

Execute all tests:
```bash
mvn test
```

Run specific feature:
```bash
mvn test -Dcucumber.features="src/test/java/featureFiles/Login.feature"
```

## Test Reports

After test execution, reports are generated in:
- `target/cucumber-reports/` - HTML reports
- `target/jsonReports/` - JSON reports

Generate comprehensive reports:
```bash
mvn verify
```
View reports at `target/cucumber-html-reports/overview-features.html`

## API Endpoints Tested

- **Login API** - User authentication
- **Add Product API** - Product creation with multipart form data
- **Create Order API** - Order placement
- **View Order API** - Order retrieval
- **Delete Product API** - Product deletion
- **Delete Order API** - Order deletion

## Key Features

- **BDD Framework** - Gherkin syntax for readable test scenarios
- **Dependency Injection** - PicoContainer for sharing context between steps
- **Multipart Form Data** - File upload support for product images
- **Response Extraction** - Dynamic data extraction (productId, orderId, userId)
- **Comprehensive Validation** - Status codes, response messages, and data integrity
- **Cleanup Automation** - Automatic deletion of test data
- **Positive & Negative Testing** - Both valid and invalid scenarios covered

## Test Data

The framework uses parameterized test data for:
- User credentials (valid/invalid)
- Product details (name, category, price, description)
- Order information

## Author

Nidhi Dasadia
