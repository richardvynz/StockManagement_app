# Stock Management Application

## Overview
This project is a simple stock management application built using Java and Spring Boot. It provides a RESTful API to manage stocks, including creating, retrieving, and updating stock prices. The project includes a Swagger UI for easy interaction with the API. Extensive tests have been written for both the controller and service layers to ensure robust functionality.

## Features
- GET /api/stocks: Retrieve a list of all stocks.
- GET /api/stocks/{id}: Retrieve details of a single stock by its ID.
- POST /api/stocks: Create a new stock.
- PUT /api/stocks/{id}: Update the price of a stock by its ID.

## Swagger UI:
- Provides a user-friendly interface for testing and interacting with the API.
- Available at http://localhost:8080/swagger-ui/index.html#/STOCK%20MANAGEMENT%20API/getAllStocks.

## Technologies Used
- Backend:

  - Java
  - pring Boot
  - Spring Data JPA
  - H2 Database (in-memory)
  - SLF4J (logging)
  - Swagger (for API documentation)

## Testing:
- JUnit
- Mockito
- Spring Boot Test

## Getting Started
### Prerequisites
- Java 17 or later
- Maven


## Installation

- Clone the repository:
   git clone https://github.com/yourusername/stock-management-app.git
cd stock-management-app

- Build the project:
   mvn clean install
  
- Run the application:
  mvn spring-boot:run


### Access the application:

The RESTful API can be accessed at http://localhost:8080/api/stocks.
The Swagger UI can be accessed at http://localhost:8080/swagger-ui/index.html#/STOCK%20MANAGEMENT%20API/getAllStocks


## API Endpoints
### Retrieve All Stocks
- URL: /api/stocks
- Method: GET
- Response: JSON array of stock objects.
- 
### Retrieve a Stock by ID
- URL: /api/stocks/{id}
- Method: GET
- Response: JSON object of the stock.
- 
### Create a New Stock
- URL: /api/stocks
- Method: POST
- Body: JSON object with name and currentPrice.
- Response: JSON object of the created stock.
- 
### Update a Stock's Price
- URL: /api/stocks/{id}
- Method: PUT
- Request Body: JSON object with newPrice.
- Response: JSON object of the updated stock.

## Running Tests
- To run the tests, use the following Maven command:
mvn test


## Test Coverage

### Controller Layer:

- Tests for all endpoints to ensure they handle requests and responses correctly.
- Validation of input data and response status codes.

### Service Layer:

- Tests for all service methods to ensure business logic is correctly implemented.
- Validation of interactions with the repository layer.

## Contributing
- Fork the repository.
- Create a new feature branch (git checkout -b feature/your-feature).
- Commit your changes (git commit -m 'Add some feature').
- Push to the branch (git push origin feature/your-feature).
- Create a new Pull Request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgements
Spring Boot Documentation
SLF4J Documentation
Swagger Documentation
JUnit and Mockito Documentation
