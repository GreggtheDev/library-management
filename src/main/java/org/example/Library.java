package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the library by title
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    // Method to find books published in a specific year
    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    // Method to find books by a specific author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    // Method to find the book with the most pages
    public Book findBookWithMostPages() {
        return books.stream()
                .max((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()))
                .orElse(null);
    }

    // Method to find books with more than n pages
    public List<Book> findBooksWithMoreThanNPages(int n) {
        return books.stream()
                .filter(book -> book.getPages() > n)
                .collect(Collectors.toList());
    }

    // Method to get all book titles sorted alphabetically
    public List<String> getAllBookTitlesSorted() {
        return books.stream()
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }

    // Method to find books by category
    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    // Method to add a user to the library
    public void addUser(User user) {
        users.add(user);
    }

    // Method to find a user by library card number
    public User findUserByLibraryCardNumber(String libraryCardNumber) {
        return users.stream()
                .filter(user -> user.getLibraryCardNumber().equals(libraryCardNumber))
                .findFirst()
                .orElse(null);
    }

    // Method to loan a book to a user
    public void loanBook(String title, String libraryCardNumber, LocalDate loanDate) {
        Optional<Book> bookToLoan = books.stream()
                .filter(book -> book.getTitle().equals(title) && !book.isOnLoan())
                .findFirst();

        Optional<User> user = users.stream()
                .filter(u -> u.getLibraryCardNumber().equals(libraryCardNumber))
                .findFirst();

        if (bookToLoan.isPresent() && user.isPresent()) {
            bookToLoan.get().setOnLoan(true, loanDate);
            user.get().loanBook(bookToLoan.get());
        }
    }

    // Method to return a book
    public void returnBook(String title, String libraryCardNumber) {
        Optional<Book> bookToReturn = books.stream()
                .filter(book -> book.getTitle().equals(title) && book.isOnLoan())
                .findFirst();

        Optional<User> user = users.stream()
                .filter(u -> u.getLibraryCardNumber().equals(libraryCardNumber))
                .findFirst();

        if (bookToReturn.isPresent() && user.isPresent()) {
            bookToReturn.get().setOnLoan(false, null);
            user.get().returnBook(bookToReturn.get());
        }
    }


}

