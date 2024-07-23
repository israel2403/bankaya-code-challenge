
# Bankaya Code Challenge

This project is a Spring Boot application that consumes the PokeAPI REST service and exposes a SOAP web service.

## Prerequisites

- Docker
- Git

## Getting Started

1. **Clone the repository:**

   Clone the repository using SSH:

   ```sh
   git clone git@github.com:israel2403/bankaya-code-challenge.git
   ```

   Or clone using HTTPS/IDE:

   ```sh
   https://github.com/israel2403/bankaya-code-challenge.git
   ```

2. **Navigate to the project directory:**

   ```sh
   cd bankaya-code-challenge
   ```

3. **Run the application:**

   Build and run the application using Docker Compose:

   ```sh
   docker-compose up --build -d
   ```

## Testing SOAP Services

To test the SOAP services manually, use one of the available request SOAP files. Below are some examples of how to test the services using `curl`:

1. Test using `request.xml`:

   ```sh
   curl -X POST -H "Content-Type: text/xml" --data @request.xml http://localhost:8080/ws
   ```

2. Test using `getAbilitiesRequest.xml`:

   ```sh
   curl -X POST -H "Content-Type: text/xml" --data @getAbilitiesRequest.xml http://localhost:8080/ws
   ```

3. Test using `baseExperienceRequest.xml`:

   ```sh
   curl -X POST -H "Content-Type: text/xml" --data @baseExperienceRequest.xml http://localhost:8080/ws
   ```

4. Test using `heldItemsRequest.xml`:

   ```sh
   curl -X POST -H "Content-Type: text/xml" --data @heldItemsRequest.xml http://localhost:8080/ws
   ```

5. Test using `idRequest.xml`:

   ```sh
   curl -X POST -H "Content-Type: text/xml" --data @idRequest.xml http://localhost:8080/ws
   ```

6. Test using `nameRequest.xml`:

   ```sh
   curl -X POST -H "Content-Type: text/xml" --data @nameRequest.xml http://localhost:8080/ws
   ```

7. Test using `locationAreaEncountersRequest.xml`:

   ```sh
   curl -X POST -H "Content-Type: text/xml" --data @locationAreaEncountersRequest.xml http://localhost:8080/ws
   ```

## Notes

- In the root folder, you will find the following files:
  - **SonarQube report**: `2024-07-23-pokeapi-soap-service-analysis-report`
  - **Swagger file**: `swagger.yaml`
