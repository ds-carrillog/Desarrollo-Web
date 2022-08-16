package com.cutebooks.prototype.domain;

import java.util.List;

public class Book {
    private String title;
    private String isbn;
    private List<String> authors;

    public Book(String title, String isbn, List<String> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", authors=" + authors + "]";
    }

    
}