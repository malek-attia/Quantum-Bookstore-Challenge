package com.bookstore.service;

import com.bookstore.model.PaperBook;

public class ShippingService {
    public void send(PaperBook book, String address) {
        System.out.println("Quantum book store: Shipping book " + book.getTitle() + " to " + address);
    }
}