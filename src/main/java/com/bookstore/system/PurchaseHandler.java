package com.bookstore.system;

import com.bookstore.model.EBook;
import com.bookstore.model.PaperBook;
import com.bookstore.model.ShowcaseBook;
import com.bookstore.service.MailService;
import com.bookstore.service.ShippingService;

public class PurchaseHandler {
    // The services should be injected through the constructor to follow dependency injection design principle
    // But I kept it simple here as no implementations were required
    private final ShippingService shippingService = new ShippingService();
    private final MailService mailService = new MailService();

    private final String email;
    private final String address;
    private final int quantity;

    public PurchaseHandler(int quantity, String email, String address) {
        this.quantity = quantity;
        this.email = email;
        this.address = address;
    }

    public void handle(PaperBook book) {
        if (book.getStock() < quantity) {
            throw new IllegalStateException("Quantum book store: Error - Not enough stock for '" + book.getTitle() + "'. Available: " + book.getStock());
        }
        book.setStock(book.getStock() - quantity);
        shippingService.send(book, address);
    }

    public void handle(EBook book) {
        mailService.send(book, email);
    }

    public void handle(ShowcaseBook book) {
        throw new IllegalStateException("Quantum book store: Error - Showcase books cannot be processed for purchase.");
    }
}