package com.aibank.jdk8.functioninterface.optional;

import java.util.Optional;

public class NewBag {

    private Optional<Book> book;

    public Optional<Book> getBook() {
        return book;
    }

    public void setBook(Optional<Book> book) {
        this.book = book;
    }
}
