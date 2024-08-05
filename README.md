# Library Management System

This project is a Java-based Library Management System that uses Java 8 features such as streams and lambda expressions. It includes functionalities for managing a collection of books, user registrations, book loans, and late fee calculations.

## Table of Contents

- [Features](#features)
- [Classes](#classes)
  - [Book](#book)
  - [User](#user)
  - [Library](#library)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Testing](#testing)
- [License](#license)

## Features

- Add and remove books in the library.
- Find books by publication year, author, category, and page count.
- Loan and return books.
- Register users and track their borrowed books.
- Calculate late fees for overdue books.
- Use of Java 8 streams and lambda expressions for operations.

## Classes

### Book

Represents a book in the library.

Attributes:
- `title` (String)
- `author` (String)
- `publicationYear` (int)
- `pages` (int)
- `category` (String)
- `isOnLoan` (boolean)
- `loanDate` (LocalDate)

Methods:
- Getters and setters for all attributes.
- `setOnLoan(boolean onLoan, LocalDate loanDate)`: Sets the loan status and date.
- `calculateLateFees()`: Calculates the late fees for the book.

### User

Represents a user of the library.

Attributes:
- `name` (String)
- `libraryCardNumber` (String)
- `booksOnLoan` (List<Book>)

Methods:
- Getters and setters for all attributes.
- `loanBook(Book book)`: Adds a book to the user's list of loaned books.
- `returnBook(Book book)`: Removes a book from the user's list of loaned books.
- `calculateTotalLateFees()`: Calculates the total late fees for the user's loaned books.

### Library

Manages the collection of books and users in the library.

Attributes:
- `books` (List<Book>)
- `users` (List<User>)

Methods:
- `addBook(Book book)`: Adds a book to the library.
- `removeBook(String title)`: Removes a book from the library by title.
- `findBooksByYear(int year)`: Finds books published in a specific year.
- `findBooksByAuthor(String author)`: Finds books by a specific author.
- `findBookWithMostPages()`: Finds the book with the most pages.
- `findBooksWithMoreThanNPages(int n)`: Finds books with more than n pages.
- `getAllBookTitlesSorted()`: Gets all book titles sorted alphabetically.
- `findBooksByCategory(String category)`: Finds books by category.
- `loanBook(String title, String libraryCardNumber, LocalDate loanDate)`: Loans a book to a user.
- `returnBook(String title, String libraryCardNumber)`: Returns a book from a user.
- `addUser(User user)`: Adds a user to the library.
- `findUserByLibraryCardNumber(String libraryCardNumber)`: Finds a user by library card number.
- `calculateTotalLateFeesForUser(String libraryCardNumber)`: Calculates total late fees for a user.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE such as IntelliJ IDEA or Eclipse

### Installation

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   ```
2. Open the project in your preferred IDE.

## Usage

1. Create instances of `Book` and `User` classes.
2. Use the `Library` class methods to manage books and users, loan and return books, and calculate late fees.
3. Run the `Main` class to see example usage and test the functionalities.



## Testing

1. Ensure you have adequate test cases for each method in the `Library`, `Book`, and `User` classes.
2. Use assertions to validate the expected outcomes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

This README file provides a clear overview of the project, its features, classes, and usage instructions. You can customize it further as needed.
