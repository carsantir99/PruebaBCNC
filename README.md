# BCNC Group Technical Test
The developed project implements a REST API service to retrieve the final price and applicable rate for specific products based on the query date. Clean Code techniques have been applied to ensure the quality and readability of the generated code, as well as SOLID principles to guarantee the maintainability and scalability of the project.

The chosen technology for development is the **Java** programming language, specifically the **Spring Boot** framework, using an in-memory **H2 database** to store data, all structured with a hexagonal architecture.

## Repository Management

For repository task management, it was decided to develop one task per implemented layer due to the simplicity of the developed code. In a real project, tasks would be created per implemented functionality rather than per developed layer. However, since the purpose of this test is to demonstrate work management and only one functionality has been implemented, the tasks were divided by layers of the functionality to showcase the workflow in a real repository.

Regarding branch management, a **main** branch has been created from which different releases of the project will be deployed. This branch contains the final product versions.

From **main**, a **develop** branch was created, where all completed developments have been integrated after being analyzed and verified through pull requests.

Finally, from the **develop** branch, multiple feature branches were created, each corresponding to a specific development task.

The workflow followed was:

1. Creating a new branch from **develop** for each planned development.
2. Cloning the newly created branch and proceeding with the development.
3. Pushing the branch with the implemented changes to the remote repository and creating a pull request to merge it back into **develop**.
4. Reviewing the generated code and verifying the correct implementation.
5. Approving the merge request, integrating the changes into the **develop** branch.

Similar to task management, it was decided to create a branch per layer to simplify the review process of the changes made in each task and to demonstrate a real-world project workflow. For this reason, the feature branches were not deleted after merging their changes into **develop**, allowing for a review of each branch's implemented changes.

In a real repository, a branch would be created per functionality, and each of these branches would be deleted after merging with **develop**.

## Technologies

The chosen **Java** version is **Java 17**, as it was found to be the most recent Java version compatible with the external tools used to ensure code quality.

The selected framework is **Spring Boot 3.4.1**, which provides the necessary infrastructure for developing an application in a simple and efficient way. Additionally, the **Spring Data JPA** module has been included for database queries, and Maven has been used for dependency management and project automation.

Regarding the database, an in-memory **H2 database** was selected to store all the information required for project queries, automatically loading upon execution.

Finally, **SonarCloud** was chosen as the code analysis tool to ensure the security and quality of the developed code.

## Architecture and Design Patterns

The project was developed using a hexagonal architecture, as it was the proposed architecture for the solution and is well known by the developer.

This architecture is based on the concept of **ports** and **adapters**, organizing the code in such a way that the core of the application is completely decoupled from implementation details and dependencies. It defines abstract interfaces (ports) and a series of external layers (adapters) that directly depend on the core. These adapters implement various business logic functionalities and manage interactions with external applications (APIs, databases, etc.).

This approach results in an application where the essential business logic is highly decoupled, providing excellent scalability and flexibility in response to scope changes.

The chosen design pattern is the **Adapter** pattern, a structural pattern that enables collaboration between objects and interfaces that are not directly compatible.

In the context of hexagonal architecture, the Adapter pattern acts as the mechanism connecting the domain core with external implementations, ensuring the decoupling of the business core and making it an ideal choice for the selected architecture.

## Project Installation and Execution

### Prerequisites:
- **Java 17** and **Maven** must be installed on the system.
- **Git** or a terminal supporting Git commands must be installed.

### Installation and Execution
1. Run the following command in the directory where you want to clone the repository:
```
git clone https://github.com/carsantir99/PruebaBCNC.git
```
2. To compile the project, navigate to the **PruebaBCNC** directory in a terminal and execute:
```
mvn clean install
```
3. Finally, to run the project:
```
mvn spring-boot:run
```

## Project Endpoints

### Price Query
- EndPoint Path: /prices
- HTTP Method: **GET**
- Request parameters (all of them are mandatory):
    - productId (Product Identifier). Example: 35455
    - brandId (Brand Identifier). Example: 1
    - date (Date when the rate should be retrieved, format: 'yyyy-MM-dd HH:mm:ss'). Example: '2020-06-15 00:00:00'.

All input parameters are required. If any parameter is missing, the system will return a 400 Bad Request error.

Example request: GET http://localhost:**assigned-port(default: 9080)**/prices?productId=35455&brandId=1&date=2020-08-15 00:00:00.

Example Response:
```
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 4,
    "startDate": "2020-06-15T16:00:00",
    "endDate": "2020-12-31T23:59:59",
    "price": 38.95,
    "currency": "EUR"
}
```

## Database Access

The database is automatically initialized with the sample data provided in the test definition when the application starts. The H2 console can be accessed to inspect the stored data:

1. Start the application.

2. Open the H2 console in a browser: http://localhost:**assigned-port(default: 9080)**/h2-console

3. Use the following credentials:

    - JDBC URL: jdbc:h2:file:./pruebaBCNCDB
    - User: sa
    - Password: (empty)

## Running Tests and Selected Linter

### Tests

The project includes unit tests for each functionality and integration tests to validate interactions with the database and API endpoints.

To execute the tests, open a terminal in the **PruebaBCNC** project directory and run:

```
mvn test
```

### Selected linter

The chosen linter for code analysis is **SonarCloud** (https://sonarcloud.io/project/overview?id=carsantir99_PruebaBCNC). Each pull request in the repository includes interactions with this tool, displaying code coverage results.

Since tasks were divided by layers of a single functionality, some pull requests may not have sufficient test coverage. In a real environment, the complete functionality would be developed before reviewing the alerts raised by **SonarCloud**, allowing them to be fixed before merging the code into **develop**.


