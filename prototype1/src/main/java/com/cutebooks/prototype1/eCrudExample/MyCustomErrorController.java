package com.cutebooks.prototype1.eCrudExample;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyCustomErrorController {


    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleError(Model model, NotFoundException exception) {
        model.addAttribute("isbn", exception.getIsbn());
        return new ModelAndView("pagina-error");
        // return "error";
    }

}