## Pet Adoption and Care Portal

- The Pet Adoption and Care Portal is an online platform that allows pet adoption agencies to manage pet profiles, track adoption processes, 
and maintain post-adoption care records.
- The platform provides the ability to create, update, retrieve, and delete information regarding pets, owners, and adoptions.
It ensures data validation, custom error handling, and a smooth API integration for both pet agencies and prospective pet owners.

## Tech Stack
- Java 17: Programming language. 
- Spring Boot: Backend framework. 
- Maven: Dependency management and project build tool.
- PostgreSQL: Primary database for data persistence. 
- H2 in-memory database: Used for integration testing.
- MockMVC: For integration tests to simulate HTTP requests. 
- JUnit: Unit testing framework.
- Mockito: Mocking framework for unit tests. Hibernate: ORM for managing database entities.

## Features
- Pet Management: Add, update, view, and delete pet information (e.g., breed, age, health status).
- Owner Management: Add, update, view, and delete information about pet owners (e.g., contact details, address).
- Adoption Management: Track the status of adoptions, link pets with owners, and record adoption dates.
- Custom Error Handling: Implements custom exceptions to handle various error cases such as entity not found, duplicate data, and validation failures.
- Validation: All DTOs have robust validation annotations to ensure data integrity.

## Project Structure
Pet-Adoption-and-Care-Portal
src/
├── main/
│   ├── java/it/school_project/PetAdoptionAndCarePortal
│   │   ├── controllers/             # REST Controllers
│   │   ├── exceptions/              # Exception handling
│   │   ├── models/                  
│   │   │   ├── dtos/                # DTOs
│   │   │   └── entities/            # Entity classes
│   │   ├── repositories/            # Data Repositories
│   │   └── services/                # Service implementations
│   ├── resources/
│   │   ├── application.properties   # Configuration
│   │   └── data.sql                 # Optional data script
├── test/                            # Unit and integration tests
## API Endpoints
You can interact with the application through the following REST API endpoints:

- Pet APIs
POST /api/pets: Add a new pet
PUT /api/pets/{id}: Update a pet by ID
DELETE /api/pets/{id}: Delete a pet by ID

- Owner APIs
GET /api/owners: Retrieve all owners
POST /api/owners: Add a new owner
PUT /api/owners/{id}: Update an owner by ID
DELETE /api/owners/{id}: Delete an owner by ID

- Adoption APIs
POST /api/adoptions: Add a new adoption
PUT /api/adoptions/{id}: Update an adoption by ID
DELETE /api/adoptions/{id}: Delete an adoption by ID

## Testing:
- Unit and integration tests covering all critical components.

## Validation:
- DTO validation and service-layer validation to ensure data integrity.

## Error Handling:
- Custom exceptions with meaningful HTTP status codes and error messages.

## Starting the Application
- Clone the repository: git clone https://github.com/Ghita-art/Pet.Adoption.and.Care.Portal
- Set up database: Create a PostgreSQL database named pet_adoption_and_care_portal and configure your database connection details in the application.properties file.
- Build and run: Use Maven to build and run the application:
- Maven: mvn clean install spring-boot:run
- The application will start on the default port (8080) and you can access the API endpoints using your preferred HTTP client.

