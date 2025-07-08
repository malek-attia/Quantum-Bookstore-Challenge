package com.bookstore;

import com.bookstore.model.Book;
import com.bookstore.model.EBook;
import com.bookstore.model.PaperBook;
import com.bookstore.model.ShowcaseBook;
import com.bookstore.system.QuantumBookstore;

import java.util.List;

public class QuantumBookstoreFullTest {

    public static void main(String[] args) {
        QuantumBookstore bookstore = new QuantumBookstore();

        // 1. Add books to inventory
        System.out.println("--- 1. Adding Books ---");
        bookstore.addBook(new PaperBook("123456789", "The C++ Programming Language", "Bjarne Stroustrup", 2013, 65.50, 10));
        bookstore.addBook(new PaperBook("111111111", "Clean Code", "Robert C. Martin", 2008, 40.25, 5));
        bookstore.addBook(new EBook("222222222", "You Don't Know JS: Up & Going", "Kyle Simpson", 2015, 5.99, "PDF"));
        bookstore.addBook(new ShowcaseBook("DEMO", "Quantum Computing Explained", "Future Tech", 2024));
        bookstore.addBook(new PaperBook("333333333", "Design Patterns", "Erich Gamma", 1994, 55.00, 3)); // An old book

        bookstore.printInventory();

        // 2. Buy books
        System.out.println("\n--- 2. Buying Books ---");
        try {
            // Buy a paper book
            bookstore.buyBook("123456789", 1, null, "123 Alexandria, Loran");
            // Buy an eBook
            bookstore.buyBook("222222222", 1, "customer@email.com", null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        bookstore.printInventory();

        // 3. Test error cases for buying
        System.out.println("\n--- 3. Testing Buy Errors ---");
        try {
            // Buy a showcase book (not for sale)
            bookstore.buyBook("DEMO", 1, null, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            // Buy an out-of-stock book
            bookstore.buyBook("111111111", 10, null, "456 Entanglement Ave, NY");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            // Buy a book that doesn't exist
            bookstore.buyBook("0000000000", 1, null, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 4. Remove outdated books
        System.out.println("\n--- 4. Removing Outdated Books (older than 20 years) ---");
        // Using 20 as the threshold, the book from 1994 should be removed.
        // Current year is assumed to be around 2025 for this test.
        List<Book> removed = bookstore.removeOutdatedBooks(20);
        System.out.println("Books removed:");
        removed.forEach(book -> System.out.println("- " + book.getTitle()));

        bookstore.printInventory();
    }
}