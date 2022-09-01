package com.cutebooks.prototype.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;


    private String title;
    private String isbn;
    private String authors;


    public Book() {}

    public Book(String title, String isbn, String authors) {
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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", authors=" + authors + "]";
    }





    public Long getId() {
        return id;
    }





    public void setId(Long id) {
        this.id = id;
    }





    public void setTitle(String title) {
        this.title = title;
    }

    
}