package com.cutebooks.prototype1.eCrudExample;

public class NotFoundException extends RuntimeException {
    private String isbn;

    public NotFoundException(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
