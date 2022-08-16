package com.cutebooks.prototype1.database;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Database {

    Logger log = LoggerFactory.getLogger(getClass());
    private int lastIsbn = 3;

    private Map<String, Book> books = new HashMap<>();

    public Database() {

        books.put("isbn1", new Book("Book1", "isbn1", Arrays.asList("author1", "author2")));
        books.put("isbn2", new Book("Book2", "isbn2", Arrays.asList("author3", "author4")));
        books.put("isbn3", new Book("Book3", "isbn3", Arrays.asList("author5", "author6")));
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
