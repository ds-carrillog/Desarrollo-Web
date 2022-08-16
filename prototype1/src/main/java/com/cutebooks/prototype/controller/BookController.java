package com.cutebooks.prototype.controller;

import com.cutebooks.prototype.database.Database;
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

@Controller // NO USAR @RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    Database db;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", db.findAll());
        return "book-list";
    }

    @GetMapping("/view/{isbn}")
    public String view2(Model model, @PathVariable String isbn) throws NotFoundException {
        Book b = db.findByIsbn(isbn);
        if (b != null) {
            model.addAttribute("book", b);
            return "book-view";
        } else {
            throw new NotFoundException("Cannot find book with isbn: " + isbn);
        }
    }

    @GetMapping("/edit/{isbn}")
    public String edit(Model model, @PathVariable String isbn) throws NotFoundException {
        Book b = db.findByIsbn(isbn);
        if (b != null) {
            model.addAttribute("book", b);
            return "book-edit";
        } else {
            throw new NotFoundException("Cannot find book with isbn: " + isbn);
        }
    }

    @GetMapping("/delete/{isbn}")
    public String delete(Model model, @PathVariable String isbn) throws NotFoundException {
        Book b = db.findByIsbn(isbn);
        if (b != null) {
            model.addAttribute("book", b);
            db.delete(isbn);
            return "redirect:/book/list";
        } else {
            throw new NotFoundException("Cannot find book with isbn: " + isbn);
        }
    }

    @GetMapping("/add")
    public String add(Model model) throws NotFoundException {
        return "book-add";
    }

    @PostMapping("")
    public String save(@ModelAttribute Book book, Model model) {
        db.save(book);
        return "redirect:/book/list";
    }


    

}
