# Projeto Modelagem de dados UML, Spring Boot e JPA/Hibernate

## Objetivo

Estudo de caso de como um modelo conceitual pode ser implementado sobre o paradigma orientado à objetos.

## Tecnologias

![Logo Java](./src/public/logo-java.svg) ![Logo Spring Boot](./src/public/logo-spring-boot.svg) ![Logo Maven](./src/public/logo-maven.svg) ![Logo H2](./src/public/logo-h2.png) ![Logo Postman](./src/public/logo-postman.svg)

## Modelo Conceitual

```mermaid
classDiagram
    direction LR

    Category "1..*" -- "*" Product
    Product "1..*" -- "*" Order
    OrderItem  ..  Product
    OrderItem  ..  Order
    Order "1" -- "1" Payment
    Payment <|-- TicketPayment
    Payment <|-- CardPayment
    Order "*" -- "1" Client
    Order --> "1" Address
    Client --> "1..*" Telephone
    Address --> "1" City
    City "*" --* "1" State

    class Category{
        -Long id
        -String name
    }
    class Product{
        -Long id
        -String name
        -Double price
    }
    class OrderItem{
        -Double discount
        -Integer quantity
        -Double price
    }
    class Order{
        -Long id
        -Instant Date
    }
    class Payment{
        -Long id
        -PaymentStatus status
    }
    class TicketPayment{
        -Instant expirationDate
        -Instant paymentDate
    }
    class CardPayment{
        -Integer installments
    }
    class Client{
        -Long id
        -String name
        -String email
        -String idDocument
        -ClientType type
    }
    class Telephone{
        <<weak>>
        -String number
    }
    class Address{
        -Long id
        -String address
        -String number
        -String addition
        -String neighboorhood
        -String postalCode
    }
    class City{
        -Long id
        -String Name
    }
    class State{
        -Long id
        -String name
    }

    namespace Enums{
        class ClientType{
            -~~enum constant~~ PESSOAFISICA
            -~~enum constant~~ PESSOAJURIDICA
        }
        class PaymentStatus{
            -~~enum constant~~ WAITING
            -~~enum constant~~ PAIDOFF
            -~~enum constant~~ CANCELED
        }
    }
```

## Endpoints de teste da API

**Categorias:**
    `GET /categories` Lista todas as categorias de produto.
    `GET /categories/{id}` Lista a categoria pelo id informado.
**Clientes:**
    `GET /clients` Lista todos os clientes.
    `GET /clients/{id}` Lista o cliente pelo id informado.
**Pedidos:**
    `GET /orders` Lista todos os pedidos.
    `GET /orders/{id}` Lista o pedido pelo id informado.
