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

## Api Endpoints
