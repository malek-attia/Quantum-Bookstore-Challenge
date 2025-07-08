package com.bookstore.model;

import com.bookstore.system.PurchaseHandler;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int year;
    protected double price;

    public boolean isOutdated(int yearsThreshold) {
        int currentYear = LocalDate.now().getYear();
        return (currentYear - this.year) > yearsThreshold;
    }

    public abstract boolean isForSale();

    public abstract void accept(PurchaseHandler handler);
}