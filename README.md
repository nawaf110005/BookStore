# BookStore-backend
![Screenshot 2023-11-22 160837](https://github.com/nawaf110005/BookStore-backend/assets/94775137/9d4f13d1-8b46-48b5-a90d-061dc6069562)

## Overview

The Book Store Backend is a RESTful API that manages user authentication, orders, and books for a book store application. The project is implemented in Java using Spring Boot.

## Entities

### 1. User

The `User` entity represents users of the application.

#### Attributes:

- `id` (Long): Unique identifier for the user.
- `name` (String): Name of the user.
- `email` (String): Email address of the user.
- `password` (String): Password for user authentication.

### 2. Role

The `Role` entity represents the roles that users can have in the application.

#### Attributes:

- `id` (Long): Unique identifier for the role.
- `name` (String): Name of the role.

### 3. OrderB

The `OrderB` entity represents orders placed by users.

#### Attributes:

- `id` (Long): Unique identifier for the order.
- `user` (User): User who placed the order (Many-to-One relationship with User).
- `books` (List<Book>): List of books included in the order (Many-to-Many relationship with Book).

### 4. Book

The `Book` entity represents books available in the store.

#### Attributes:

- `id` (Long): Unique identifier for the book.
- `title` (String): Title of the book.
- `author` (String): Author of the book.
- `releaseDate` (Date): Release date of the book.
- `categories` (List<String>): Categories the book belongs to.
- `orders` (List<OrderB>): List of orders that include the book (Many-to-Many relationship with OrderB).

## Controllers

### 1. AuthController

- **URL Mapping:** `/auth`

#### Endpoints:

- **POST `/signup`**
  - Creates a new user.
  - Request Body: User details.
  - Response: Created user.

- **GET `/verify`**
  - Verifies the user token.
  - Request Header: Authentication token.
  - Response: User verification details.

### 2. OrderController

- **URL Mapping:** `/api`

#### Endpoints:

- **GET `/orders/{id}`**
  - Retrieves an order by ID.
  - Path Variable: Order ID.
  - Response: Order details.

- **GET `/ordersById/{id}`**
  - Retrieves orders by user ID.
  - Path Variable: User ID.
  - Response: List of orders.

- **GET `/orders`**
  - Retrieves all orders (for testing).
  - Response: List of orders.

- **POST `/orders/add`**
  - Creates a new order.
  - Request Body: Order details.
  - Response: Created order.

- **DELETE `/orders/delete/{id}`**
  - Deletes an order by ID.
  - Path Variable: Order ID.

- **PATCH `/orders/update/{id}`**
  - Updates an order by ID.
  - Path Variable: Order ID.
  - Request Body: Updates.
  - Response: Update status.

### 3. BookController

- **URL Mapping:** `/api`

#### Endpoints:

- **GET `/books/{id}`**
  - Retrieves a book by ID.
  - Path Variable: Book ID.
  - Response: Book details.

- **GET `/books`**
  - Retrieves all books (for testing).
  - Response: List of books.

- **GET `/books/news`**
  - Retrieves all books by release date.
  - Response: List of books.

- **GET `/books/category/{id}`**
  - Retrieves all books by category name.
  - Path Variable: Category name.
  - Response: List of books.

- **POST `/books/add`**
  - Adds a new book.
  - Request Body: Book details.

- **DELETE `/books/delete`**
  - Deletes all books.

- **DELETE `/books/delete/{id}`**
  - Deletes a book by ID.
  - Path Variable: Book ID.

- **PATCH `/books/update/{id}`**
  - Updates a book by ID.
  - Path Variable: Book ID.
  - Request Body: Updates.
  - Response: Update status.

## Usage

1. Run the application.
2. Use the provided endpoints to interact with the API.


# Installation Guide

Follow these steps to set up and run the Book Store Backend project locally:

## Prerequisites

Ensure you have the following installed on your machine:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

## Clone the Repository

Open a terminal and run the following command to clone the project repository:

```bash
git clone https://github.com/your-username/book-store-backend.git   

