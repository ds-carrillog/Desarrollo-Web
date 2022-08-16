package com.cutebooks.prototype1.eCrudExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cutebooks.prototype1.database.Book;
import com.cutebooks.prototype1.database.DatabaseComponent;

@Controller // NO USAR @RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    DatabaseComponent db;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", db.findAll());
        return "book-list";
    }

    @GetMapping("/view/{isbn}")
    public String view(Model model, @PathVariable String isbn) {
        Book b = db.findByIsbn(isbn);
        if (b != null) {
            model.addAttribute("book", b);
            return "book-view";
        } else {
            throw new NotFoundException(isbn);
        }
    }

    @GetMapping("/edit/{isbn}")
    public String edit(Model model, @PathVariable String isbn) {
        Book b = db.findByIsbn(isbn);
        if (b != null) {
            model.addAttribute("book", b);
            return "book-edit";
        } else {
            throw new NotFoundException(isbn);
        }
    }

    @GetMapping("/delete/{isbn}")
    public String deleteUser(@PathVariable String isbn, Model model) {
        Book b = db.findByIsbn(isbn);
        if (b != null) {
            model.addAttribute("book", b);
            db.delete(b);
            return "redirect:/book/list";
        } else {
            throw new NotFoundException(isbn);
        }
    }

    @PostMapping("")
    public String save(@ModelAttribute Book book, Model model) {
        db.save(book);
        return "redirect:/book/list";
    }

}
