package com.infoshareacademy.rest;


import com.infoshareacademy.repository.Books;
import com.infoshareacademy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.infoshareacademy.Utils.listToString;


@Controller
public class AllBooksController {

    private final Books books;

    @Autowired
    public AllBooksController(Books books) {
        this.books = books;
    }

    @GetMapping("all-books")
    public ModelAndView displayBooks() {
        ModelAndView modelAndView = new ModelAndView("AllBooks");
        modelAndView.addObject("allBooks", listToString(books.getBooks(), true));
        modelAndView.addObject("testAttribute","This is test attribute");
        return modelAndView;
    }

}