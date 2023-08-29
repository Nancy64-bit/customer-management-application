# Customer Management Application 📊

Welcome to the documentation for the Nancy64-bit Customer Management Application! 🎉 This project aims to provide you with APIs to seamlessly manage customer data. Below, you will find all the information you need to integrate these APIs into your application.

## Getting Started

To begin, make sure you have the project set up and running:

1. Clone the repository:
   ```bash
   git clone https://github.com/Nancy64-bit/customer-management-application.git
   ```

2. Build the Spring application using Gradle:
   ```bash
   ./gradlew build
   ```

3. Start the server:
   ```bash
   ./gradlew bootrun
   ```
   Note: Please wait until the build process is completed and the server is up and running.

## Authentication API

Authenticate users using the provided credentials to obtain a Bearer token for subsequent API calls.

- **Path**: https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp
- **Method**: POST
- **Body**:
  ```json
  {
    "login_id": "test@sunbasedata.com",
    "password": "Test@123"
  }
  ```
- **Response**:
  - Success: Bearer token for further API calls
  - Failure: 401, Invalid Authorization

## Create a New Customer

Integrate this API to create a new customer.

- **Path**: https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp
- **Method**: POST
- **Parameters**:
  - cmd: create
- **Header**:
  - Authorization: Bearer token_recieved_in_authentication_API_call
- **Body**:
  ```json
  {
    "first_name": "Jane",
    "last_name": "Doe",
    "street": "Elvnu Street",
    "address": "H no 2",
    "city": "Delhi",
    "state": "Delhi",
    "email": "sam@gmail.com",
    "phone": "12345678"
  }
  ```
- **Response**:
  - Success: 201, Successfully Created
  - Failure: 400, First Name or Last Name is missing

## Get Customer List

Retrieve the list of customers using this API.

- **Path**: https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp
- **Method**: GET
- **Parameters**:
  - cmd: get_customer_list
- **Header**:
  - Authorization: Bearer token_recieved_in_authentication_API_call
- **Response**:
  ```json
  [
    {
      "first_name": "Jane",
      "last_name": "Doe",
      "street": "Elvnu Street",
      "address": "H no 2",
      "city": "Delhi",
      "state": "Delhi",
      "email": "sam@gmail.com",
      "phone": "12345678"
    }
  ]
  ```

## Delete a Customer

Delete a specific customer using this API.

- **Path**: https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp
- **Method**: POST
- **Parameters**:
  - cmd: delete
  - uuid: uuid_of_a_specific_customer
- **Header**:
  - Authorization: Bearer token_recieved_in_authentication_API_call
- **Response**:
  - Success: 200, Successfully deleted
  - Failure: 500, Error Not deleted
  - Failure: 400, UUID not found

## Update a Customer

Update an existing customer's information using this API.

- **Path**: https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp
- **Method**: POST
- **Parameters**:
  - cmd: update
  - uuid: uuid_of_a_specific_customer
- **Header**:
  - Authorization: Bearer token_recieved_in_authentication_API_call
- **Body**:
  ```json
  {
    "first_name": "Jane",
    "last_name": "Doe",
    "street": "Elvnu Street",
    "address": "H no 2",
    "city": "Delhi",
    "state": "Delhi",
    "email": "sam@gmail.com",
    "phone": "12345678"
  }
  ```
- **Response**:
  - Success: 200, Successfully Updated
  - Failure: 500, UUID not found
  - Failure: 400, Body is Empty

## UI Integration

To integrate the APIs into your application, follow these basic steps:

1. Create a basic UI using HTML. A simple HTML table, form, and buttons will suffice.
2. Design three screens:
   - **Login Screen**: Allow users to log in and obtain the Bearer token.
   - **Customer List Screen**: Display the list of customers.
   - **Add New Customer Screen**: Enable the creation of new customers, deletion, and updating of existing ones.

## Testing with cURL

You can use cURL commands to test the API endpoints:

```bash
# Authenticate and get Bearer token
curl -X POST -H "Content-Type: application/json" -d '{"login_id": "test@sunbasedata.com", "password": "Test@123"}' https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp

# Create a new customer
curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer token_recieved_in_authentication_API_call" -d '{"first_name": "Jane", "last_name": "Doe", "street": "Elvnu Street", "address": "H no 2", "city": "Delhi", "state": "Delhi", "email": "sam@gmail.com", "phone": "12345678"}' https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=create

# Get customer list
curl -X GET -H "Authorization: Bearer token_recieved_in_authentication_API_call" https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list

# Delete a customer
curl -X POST -H "Authorization: Bearer token_recieved_in_authentication_API_call" -d "cmd=delete&uuid=uuid_of_a_specific_customer" https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp

# Update a customer
curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer token_recieved_in_authentication_API_call" -d '{"first_name": "Jane", "last_name": "Doe", "street": "Elvnu Street", "address": "H no 2", "city": "Delhi", "state": "Delhi", "email": "sam@gmail.com", "phone": "12345678"}' https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=update&uuid=uuid_of_a_specific_customer
```

Feel free to customize and enhance this markdown file according to your project's needs. Good luck with your integration! 🚀🔧🎈
