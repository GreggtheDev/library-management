package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book("Book1", "Author1", 2000, 300, "Fiction"));
        library.addBook(new Book("Book2", "Author2", 2001, 400, "Science"));
        library.addBook(new Book("Book3", "Author1", 2002, 200, "History"));

        // Add users to the library
        User user1 = new User("User1", "123");
        library.addUser(user1);

        // Find books by author
        System.out.println("Books by Author1:");
        List<Book> booksByAuthor1 = library.findBooksByAuthor("Author1");
        booksByAuthor1.forEach(book -> System.out.println(book.getTitle()));

        // Loan a book to a user
        System.out.println("\nLoaning Book1 to User1...");
        library.loanBook("Book1", "123", LocalDate.now());
        System.out.println("Books on loan to User1:");
        user1.getBooksOnLoan().forEach(book -> System.out.println(book.getTitle()));

        // Return a book
        System.out.println("\nReturning Book1 from User1...");
        library.returnBook("Book1", "123");
        System.out.println("Books on loan to User1 after returning:");
        user1.getBooksOnLoan().forEach(book -> System.out.println(book.getTitle()));

        // Calculate total late fees for a user
        System.out.println("\nCalculating total late fees for User1...");
        double totalLateFees = library.calculateTotalLateFeesForUser("123");
        System.out.println("Total Late Fees: " + totalLateFees);
    }
}
