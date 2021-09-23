package com.kon.library.service.book;

import com.kon.library.controller.dto.AuthorDto;
import com.kon.library.controller.dto.BookDto;
import com.kon.library.model.Book;

import java.util.List;

public interface BookService {

    Book addBook(BookDto bookDto);

    List<BookDto> getAllBooks();

    List<BookDto> getBooksWhereNameContains(String name);

}
