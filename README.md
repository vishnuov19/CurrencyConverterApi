# Currency Converter API

A Spring Boot application that integrates with a public API to provide real-time currency conversion functionality.

---

## Features

- Fetch real-time exchange rates from a public API
- Convert an amount from one currency to another
- Clean RESTful API design
- Error handling for API failures and invalid inputs
- Simple Maven-based setup

---

## API Endpoints

### `GET /api/rates`
Fetch exchange rates for a base currency.

**Query param**: `base` (optional, default = `USD`)  
**Example**:
```
GET http://localhost:8080/api/rates?base=EUR
```

---

### `POST /api/convert`
Convert an amount from one currency to another.

**Request Body**:
```json
{
  "from": "USD",
  "to": "INR",
  "amount": 100
}
```

**Response**:
```json
{
  "from": "USD",
  "to": "INR",
  "amount": 100,
  "convertedAmount": 8342.5
}
```

---

## Running Locally

```bash
# Build the app
mvn clean install

# Run the app
mvn spring-boot:run
```

---

## Tech Stack

- Java 17+ or 21+ (Java 24 also supported)
- Spring Boot 3.x
- Maven
- REST APIs
- [open.er-api.com](https://open.er-api.com/) for exchange rates

---

## Structure

- `controller` – REST endpoints
- `service` – business logic for fetching/converting
- `model` – data models
- `exception` – global error handler

---

## License

This project is open-source and free to use for learning or integration.
