# ReqRes API Test Suite

This repository provides a suite of automated REST API tests for the ReqRes API, implemented using the Rest Assured library and TestNG framework. The project demonstrates essential CRUD (Create, Read, Update, Delete) operations with API endpoints. Below is a detailed overview of the test cases:

## Test Cases

### `registeruser()`
- **Purpose**: Test the successful registration of a user.
- **Details**: Sends a POST request to `https://reqres.in/api/register` with valid `email` and `password`. Validates that:
  - The response status code is `200`.
  - The `id` field in the response body equals `4`.
  - The `token` field in the response body matches the expected token `QpwL5tke4Pnpja7X4`.
- **Logging**: The response is logged for inspection.

### `unsuccessfulregisteruser()`
- **Purpose**: Test the unsuccessful registration of a user due to missing password.
- **Details**: Sends a POST request to `https://reqres.in/api/register` with only the `email` field. Validates that:
  - The response status code is `400`.
  - The `error` field in the response body contains the message `"Missing password"`.
- **Logging**: The response is logged for inspection.

### `successfulLogin()`
- **Purpose**: Test the successful login of a user.
- **Details**: Sends a POST request to `https://reqres.in/api/login` with valid `email` and `password`. Validates that:
  - The response status code is `200`.
  - The `token` field in the response body matches the expected token `QpwL5tke4Pnpja7X4`.
- **Logging**: The response is logged for inspection.

### `unsuccessfulLogin()`
- **Purpose**: Test the unsuccessful login of a user due to missing password.
- **Details**: Sends a POST request to `https://reqres.in/api/login` with only the `email` field. Validates that:
  - The response status code is `400`.
  - The `error` field in the response body contains the message `"Missing password"`.
- **Logging**: The response is logged for inspection.

## Project Details

- **Testing Framework**: TestNG
- **API Testing Library**: Rest Assured
- **Response Logging**: Included for debugging purposes
- **Exception Handling**: Suppresses warnings related to unchecked operations
