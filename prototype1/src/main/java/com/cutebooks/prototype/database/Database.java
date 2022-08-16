package com.cutebooks.prototype.database;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cutebooks.prototype.domain.Book;

public class Database {

    Logger log = LoggerFactory.getLogger(getClass());
    private int lastId = 3;

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

    public void delete(String isbn) {
        Book b = books.get(isbn);
        log.info("Retrieved {}", b);
        books.remove(isbn, b);
    }

    public Collection<Book> findAll() {
        return books.values();
    }

    public void save(Book book) {
        if (book.getIsbn() == null) {
            lastId++;
            book.setIsbn("isbn"+lastId);
        }
        books.put(book.getIsbn(), book);
    }
}
