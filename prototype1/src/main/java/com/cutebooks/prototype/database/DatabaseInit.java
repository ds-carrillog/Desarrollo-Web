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
        bookRepository.save(new Book("Book100", "isbn1", "author1, author2", "https://kbimages1-a.akamaihd.net/54a4b628-b12d-4d4c-88be-44ad83af4ce0/353/569/90/False/harry-potter-and-the-sorcerer-s-stone-the-first-book-in-the-phenomenal-internationally-bestselling-harry-potter-series-by-j-k-rowling.jpg"));
        bookRepository.save(new Book("Book101", "isbn2", "author1, author2","https://kbimages1-a.akamaihd.net/54a4b628-b12d-4d4c-88be-44ad83af4ce0/353/569/90/False/harry-potter-and-the-sorcerer-s-stone-the-first-book-in-the-phenomenal-internationally-bestselling-harry-potter-series-by-j-k-rowling.jpg"));
        bookRepository.save(new Book("Book102", "isbn3", "author1, author2","https://kbimages1-a.akamaihd.net/54a4b628-b12d-4d4c-88be-44ad83af4ce0/353/569/90/False/harry-potter-and-the-sorcerer-s-stone-the-first-book-in-the-phenomenal-internationally-bestselling-harry-potter-series-by-j-k-rowling.jpg"));
        
    }
    
}
