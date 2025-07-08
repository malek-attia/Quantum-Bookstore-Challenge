package com.bookstore.model;

import com.bookstore.system.PurchaseHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }

    @Override
    public boolean isForSale() {
        return getPrice() > 0 && getStock() > 0;
    }

    @Override
    public void accept(PurchaseHandler handler) {
        handler.handle(this);
    }
}