# Quantum Bookstore System Design

This project implements an extensible online bookstore system in Java, with a strong focus on SOLID principles and scalable object-oriented design.

## Features

*   **Multi-Type Inventory:** Manage various book types like `PaperBook` (shippable, with stock), `EBook` (emailable, with filetype), and `ShowcaseBook` (non-sellable).
*   **Core Bookstore Operations:**
    *   Add and remove books from the inventory.
    *   Buy books by ISBN, with fulfillment handled dynamically (shipping for paper books, email for ebooks).
    *   Filter and remove outdated books based on publication year.
*   **Extensible by Design:** Add new product types (e.g. `AudioBook`) without modifying core system classes.
*   **Robust Error Handling:** Gracefully handles errors for out-of-stock, unavailable, or non-sellable items.

## Project Structure

```
quantum-bookstore-challenge/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── bookstore/
                    ├── model/
                    │   ├── Book.java
                    │   ├── EBook.java
                    │   ├── PaperBook.java
                    │   └── ShowcaseBook.java
                    │
                    ├── service/
                    │   ├── MailService.java
                    │   └── ShippingService.java
                    │
                    ├── system/
                    │   ├── QuantumBookstore.java
                    │   └── PurchaseHandler.java
                    │
                    └── QuantumBookstoreFullTest.java
```

## Technologies Used

*   Java 17+
*   Apache Maven
*   Lombok

## Setup and Run

### Prerequisites

*   JDK 17 or later
*   Apache Maven

### Steps

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/malek-attia/quantum-bookstore-challenge.git
    ```
2.  **Navigate to the project directory and build:**
    ```bash
    cd quantum-bookstore-challenge
    mvn clean install
    ```
3.  **Run the test application:**
    The `QuantumBookstoreFullTest` class contains a `main` method to demonstrate the system's functionality.
    ```bash
    mvn exec:java -Dexec.mainClass="com.bookstore.QuantumBookstoreFullTest"
    ```

## Assumptions

*   **In-Memory Inventory:** The bookstore's inventory is stored in-memory and is not persisted across application runs.
*   **Simplified Services:** The `ShippingService` and `MailService` are simple placeholders that print to the console.
*   **No Financial Precision:** `double` is used for the book price for simplicity. A real-world application would use `BigDecimal` for financial calculations.
*   **Single-Threaded Context:** The application is not designed for concurrent use and is not thread-safe.


## Screenshots from running app.

### Adding Sample Books to the inventory
<img width="1135" height="340" alt="Image" src="https://github.com/user-attachments/assets/973bad08-ef96-41fc-9456-f41c7dfeaf4d" />

### Successful purchase test case
<img width="1135" height="361" alt="Image" src="https://github.com/user-attachments/assets/621a15b5-a637-4d43-91d1-4a6e1fb2abb8" />

### Test error cases for buying and remove outdated functionality
<img width="1135" height="501" alt="Image" src="https://github.com/user-attachments/assets/d980e79e-4314-4605-9938-bddc52e862a1" />
