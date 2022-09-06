package com.cutebooks.prototype.controller;
import com.cutebooks.prototype.database.BookRepository;
import com.cutebooks.prototype.domain.Book;
import com.cutebooks.prototype.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller // NO USAR @RestController
@RequestMapping("/book")
public class BookController {


    Logger log = LoggerFactory.getLogger(getClass());


    @Autowired
    BookRepository bookRepository;

    @GetMapping("/list")
    public String list(Model model) {
        Iterable<Book> books= bookRepository.findAll();
        for (Book book : books){
            log.info(book.toString());
        }
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/view/{isbn}")
    public String view2(Model model, @PathVariable String isbn) throws NotFoundException {
        Book b= bookRepository.findByisbn(isbn);
        if (b != null) {
            model.addAttribute("book", b);
            return "book-view";
        } else {
            throw new NotFoundException("Cannot find book with isbn: " + isbn);
        }
    }

    @GetMapping("/edit/{isbn}")
    public String edit(Model model, @PathVariable String isbn) throws NotFoundException {
        Book b= bookRepository.findByisbn(isbn);
        if (b != null) {
            model.addAttribute("book", b);
            return "book-edit";
        } else {
            throw new NotFoundException("Cannot find book with isbn: " + isbn);
        }
    }

    @GetMapping("/delete/{isbn}")
    public String delete(Model model, @PathVariable String isbn) throws NotFoundException {
        Book b= bookRepository.findByisbn(isbn);
        if (b != null) {
            model.addAttribute("book", b);
            bookRepository.delete(b);
            return "redirect:/book/list";
        } else {
            throw new NotFoundException("Cannot find book with isbn: " + isbn);
        }
    }

    @GetMapping("/add")
    public String add(Model model) throws NotFoundException {
        model.addAttribute("book", new Book(null, null, null,null));
        return "book-add";
    }

    @PostMapping("")
    public String save(@ModelAttribute Book book, Model model) {
        log.info(book.toString());
        bookRepository.save(book);
        return "redirect:/book/list";
    }


    

}
