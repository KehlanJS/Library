package com.kon.library.service.book;

import com.kon.library.controller.dto.BookDto;
import com.kon.library.model.Book;

public interface BookService {

    Book addBook(BookDto bookDto);

}
