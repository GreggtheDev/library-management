package org.example;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category;
    private boolean isOnLoan;
    private LocalDate loanDate;

    // Constructor to initialize a book with the specified attributes
    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.category = category;
        this.isOnLoan = false;
        this.loanDate = null;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public String getCategory() {
        return category;
    }

    public boolean isOnLoan() {
        return isOnLoan;
    }

    // Method to set the loan status and date of a book
    public void setOnLoan(boolean onLoan, LocalDate loanDate) {
        this.isOnLoan = onLoan;
        this.loanDate = loanDate;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    // Method to calculate late fees for a book
    public double calculateLateFees() {
        if (!isOnLoan) return 0;

        LocalDate dueDate = loanDate.plusWeeks(2);
        long daysLate = java.time.temporal.ChronoUnit.DAYS.between(dueDate, LocalDate.now());

        return daysLate > 0 ? daysLate * 0.5 : 0;
    }
}

