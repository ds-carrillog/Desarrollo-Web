package com.cutebooks.prototype1.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/book")
public class BookFind {
    @Autowired
    private DatabaseComponent db;

    @GetMapping(path = "/find", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String findBook(@RequestParam String isbn) {
        String pag = "<html><head></head><body>";
        Book b = db.findByIsbn(isbn);
        if (b != null) {
            pag += "<p>";
            pag += b.getTitle();
            pag += "</p>";
        }
        pag += "</body></html>";
        return pag;
    }
}
