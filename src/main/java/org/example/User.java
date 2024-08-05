package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String libraryCardNumber;
    private List<Book> booksOnLoan = new ArrayList<>();

    // Constructor to initialize a user with the specified name and library card number
    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public List<Book> getBooksOnLoan() {
        return booksOnLoan;
    }

    // Method to add a book to the user's list of loaned books
    public void loanBook(Book book) {
        booksOnLoan.add(book);
    }

    // Method to remove a book from the user's list of loaned books
    public void returnBook(Book book) {
        booksOnLoan.remove(book);
    }

    // Method to calculate total late fees for the user's loaned books
    public double calculateTotalLateFees() {
        return booksOnLoan.stream()
                .mapToDouble(Book::calculateLateFees)
                .sum();
    }
}

