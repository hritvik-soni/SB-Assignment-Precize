# SAT Results Management System

This Spring Boot application provides a backend for managing SAT results with the following features:

## Features

1. **Insert Data**

   - Accepts input for SAT Results object.
   - Stores data in memory.
   - Calculates "Passed" status based on SAT score.

2. **View All Data**

   - Displays all stored data in JSON format.

3. **Get Rank**

   - Takes a candidate's name as input.
   - Returns the rank of the candidate based on the stored data.

4. **Update Score**

   - Allows updating the SAT score for a candidate by name.

5. **Delete One Record**
   - Deletes a record by the candidate's name.

## SAT Results Object

The SAT Results object has the following attributes:

- **Name** (Unique Identifier)
- **Address**
- **City**
- **Country**
- **Pincode**
- **SAT Score**
- **Passed Status** (Calculated: Pass if SAT score > 30%, Fail otherwise)

## API Endpoints

- ### Insert Record

  - Endpoint `/api/sat-results/insert-record`
  - Method `POST`
  - Response Body
    ```json
    {
      "name": "John Doe",
      "address": "123 Main St",
      "city": "Cityville",
      "country": "Countryland",
      "pincode": "12345",
      "satScore": 25
    }
    ```

- ### View All Records

  - Endpoint `/api/sat-results/view-all`
  - Method `GET`

- ### Check Is Passed

  - Endpoint `/api/sat-results/is-passed/{name}`
  - Method `GET`

- ### Get Rank

  - Endpoint `/api/sat-results/get-rank/{name}`
  - Method `GET`

- ### Update Score

  - Endpoint `/api/sat-results/update-score/{name}/`
  - Method `PUT`

- ### Delete Record

  - Endpoint `/api/sat-results/delete-record/{name}?newScore=45`
  - Method `DELETE`

## Technical Stack

- **Backend Language:** Java
- **Framework:** Spring Boot
- **Database:** In-memory database (H2)
- **Documentation:** Clear, readable, and well-documented code
- **Testing:** API functionality can be demonstrated using Postman (Postman collections file is also added in project file).

## Getting Started

1. Clone the repository.
2. Open the project in your preferred Java IDE.
3. Build and run the project.
4. Test the APIs using Postman or any API testing tool.

## API Usage

Refer to the API documentation for details on using each endpoint. The documentation can be found in the code comments.

- Link for Swagger UI :- http://localhost:8080/swagger-ui/index.html#/
- Link for H2 console :-http://localhost:8080/h2-console/login.jsp (username:- sa , passsword="1")

##

Happy coding!
