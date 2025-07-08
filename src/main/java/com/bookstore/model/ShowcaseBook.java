package com.bookstore.model;

import com.bookstore.system.PurchaseHandler;
import lombok.ToString;

@ToString(callSuper = true)
public class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String title, String author, int year) {
        super(isbn, title, author, year, 0.0);
    }

    @Override
    public boolean isForSale() {
        return false;
    }

    @Override
    public void accept(PurchaseHandler handler) {
        handler.handle(this);
    }
}