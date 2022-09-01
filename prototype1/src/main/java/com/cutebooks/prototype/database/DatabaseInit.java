package com.cutebooks.prototype.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cutebooks.prototype.domain.Book;

@Component
public class DatabaseInit implements ApplicationRunner{

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        bookRepository.save(new Book("Book100", "isbn1", "author1, author2"));
        bookRepository.save(new Book("Book101", "isbn2", "author1, author2"));
        bookRepository.save(new Book("Book102", "isbn3", "author1, author2"));
        
    }
    
}
