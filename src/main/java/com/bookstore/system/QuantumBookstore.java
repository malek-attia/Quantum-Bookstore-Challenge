package com.bookstore.system;

import com.bookstore.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuantumBookstore {
    private final List<Book> inventory = new ArrayList<>();

    public void addBook(Book book) {
        inventory.add(book);
        System.out.println("Quantum book store: Added book - " + book.getTitle());
    }

    public List<Book> removeOutdatedBooks(int yearsThreshold) {
        List<Book> outdatedBooks = inventory.stream()
                .filter(book -> book.isOutdated(yearsThreshold))
                .collect(Collectors.toList());

        inventory.removeAll(outdatedBooks);
        System.out.println("Quantum book store: Removed " + outdatedBooks.size() + " outdated books.");
        return outdatedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        System.out.println("Quantum book store: Attempting to buy " + quantity + " of book with ISBN " + isbn);
        Optional<Book> bookOpt = inventory.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();

        if (bookOpt.isEmpty()) {
            throw new IllegalArgumentException("Quantum book store: Error - Book with ISBN " + isbn + " not found.");
        }

        Book book = bookOpt.get();

        if (!book.isForSale()) {
            throw new IllegalStateException("Quantum book store: Error - Book '" + book.getTitle() + "' is not for sale.");
        }

        PurchaseHandler purchaseHandler = new PurchaseHandler(quantity, email, address);
        book.accept(purchaseHandler);

        double paidAmount = book.getPrice() * quantity;
        System.out.println("Quantum book store: Purchase successful for '" + book.getTitle() + "'. Total paid: $" + paidAmount);
        return paidAmount;
    }

    public void printInventory() {
        System.out.println("\n--- Quantum Bookstore Inventory ---");
        inventory.forEach(System.out::println);
        System.out.println("---------------------------------\n");
    }
}