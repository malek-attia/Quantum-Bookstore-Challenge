package com.bookstore.service;

import com.bookstore.model.EBook;

public class MailService {
    public void send(EBook book, String email) {
        System.out.println("Quantum book store: Emailing book " + book.getTitle() + " to " + email);
    }
}