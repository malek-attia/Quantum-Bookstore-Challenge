package com.bookstore.model;

import com.bookstore.system.PurchaseHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class EBook extends Book {
    private String filetype;

    public EBook(String isbn, String title, String author, int year, double price, String filetype) {
        super(isbn, title, author, year, price);
        this.filetype = filetype;
    }

    @Override
    public boolean isForSale() {
        return getPrice() > 0;
    }

    @Override
    public void accept(PurchaseHandler handler) {
        handler.handle(this);
    }
}