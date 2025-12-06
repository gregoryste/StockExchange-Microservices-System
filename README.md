# Project Architecture

This project follows a **microservices architecture**, with the main goal of creating a system capable of registering stock market data and dollar exchange rates.

```
<img width="890" height="706" alt="image" src="https://github.com/user-attachments/assets/607a13ed-7a5f-4a24-9514-504608474b7e" />
```

## Architecture Overview

The system is composed of several independent yet interconnected components, each responsible for a specific part of the workflow.

## Components

### 1. Client
The entry point of the system. Any web application or external consumer sends requests through the API Gateway.

### 2. API Gateway (Spring Cloud Gateway)
The API Gateway serves as the single access point for all clients. It is responsible for:
- Routing incoming requests
- Performing simple load balancing
- Centralizing access and hiding the internal microservice structure

### 3. Microservices

#### cotacoes-service
Consumes data from an external API to retrieve the current dollar exchange rate.

#### acoes-service
Manages stock-related information, using both internal logic and external data sources.

<img width="251" height="162" alt="image" src="https://github.com/user-attachments/assets/b03a9f27-75cd-425c-b487-85767aa612b3" />

Both microservices automatically register themselves with the Eureka service registry.

### 4. Remote Service
An external API consumed by the microservices (e.g., a financial data provider).

### 5. Service Discovery / Registry (Netflix Eureka)
Eureka provides:
- Centralized service registration and discovery
- Dynamic lookup of available microservices
- Removal of the need for hard-coded endpoints

<img width="869" height="576" alt="image" src="https://github.com/user-attachments/assets/d9fafd3d-a87e-47dd-8137-80d149ddc2e7" />


### 6. H2 Database
An in-memory SQL database used for local development and testing, providing a lightweight and fast data layer.

## System Flow

1. The client sends a request to the API Gateway.
2. The Gateway queries Eureka to locate the appropriate microservice instance.
3. The request is routed to either cotacoes-service or acoes-service.
4. The microservice processes the request, optionally accessing the H2 database or a remote API.
5. The response is returned to the client through the Gateway.

## Benefits

- Independent scalability of each microservice
- Low coupling across system components
- Dynamic service discovery powered by Eureka
- Centralized routing through the API Gateway
- Lightweight development environment using H2

## Collaborators

[**Luan Genro**](https://github.com/LuanGenro98) and [**Gustavo Lamb**](https://github.com/GustavoLamb).

## Collaborators

[**Luan Genro**](https://github.com/LuanGenro98) and [**Gustavo Lamb**](https://github.com/GustavoLamb).
