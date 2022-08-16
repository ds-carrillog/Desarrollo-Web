package com.cutebooks.prototype1.database;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DatabaseComponent {

    Logger log = LoggerFactory.getLogger(getClass());

    private int lastIsbn = 3;

    private Map<String, Book> books = new HashMap<>();

    @PostConstruct
    void init() {
        save(new Book("Book1", "isbn1", Arrays.asList("author1", "author2")));
        save(new Book("Book2", "isbn2", Arrays.asList("author3", "author4")));
        save(new Book("Book3", "isbn3", Arrays.asList("author5", "author6")));
    }

    public Book findByIsbn(String isbn) {
        Book b = books.get(isbn);
        log.info("Retrieved {}", b);
        return b;
    }

    public Collection<Book> findAll() {
        return books.values();
    }

    public void save(Book book) {
        if (book.getIsbn() == null) {
            lastIsbn++;
            book.setIsbn("isbn" + lastIsbn);
        }
        books.put(book.getIsbn(), book);
    }

    public void delete(Book book) {
        books.remove(book.getIsbn(), book);
    }
}
