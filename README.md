# E-commerce E2E REST API Automation

End-to-end REST API automation framework for e-commerce application testing, built with Rest Assured, Cucumber BDD, and comprehensive test coverage for user authentication, product management, and order workflows.

## Technologies Used

- **Java** - Programming language
- **Rest Assured 6.0.0** - REST API testing library
- **Cucumber 7.16.1** - BDD framework with PicoContainer for dependency injection
- **JUnit 5.10.2** - Testing framework
- **TestNG 7.8.0** - Additional testing framework support
- **Maven** - Build and dependency management
- **Jackson Databind** - JSON serialization/deserialization
- **Hamcrest 2.2** - Assertion matchers
- **Groovy 3.0.25** - For JSON path assertions

## Project Structure

```
EcommAPIAutomation/
├── src/test/java/
│   ├── featureFiles/      # Cucumber feature files
│   ├── stepDefination/    # Step definition classes
│   ├── pojo/              # Request/Response POJOs
│   ├── resources/         # Reusable utility classes
│   └── cucumber/          # Test runner configuration
└── pom.xml
```

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
