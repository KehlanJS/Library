package com.kon.library.controller;


import com.kon.library.controller.dto.BookDto;
import com.kon.library.model.Book;
import com.kon.library.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    public Book addBook(@RequestBody BookDto dto){
        return bookService.addBook(new Book(dto.getName(), dto.getDescription(), dto.getAuthor()));
    }
}
