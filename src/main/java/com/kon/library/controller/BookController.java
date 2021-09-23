package com.kon.library.controller;


import com.kon.library.controller.dto.AuthorDto;
import com.kon.library.controller.dto.BookDto;
import com.kon.library.model.Book;
import com.kon.library.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/book")
@RestController
public class BookController {


    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    public BookDto addBook(@RequestBody BookDto dto){
        bookService.addBook(dto);
        return dto;
    }

    @ResponseBody
    @GetMapping(value = "/all")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        final var bookList = bookService.getAllBooks();

        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}
