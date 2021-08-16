package com.kon.library.service.book;

import com.kon.library.model.Book;
import com.kon.library.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        log.info("Dodaje ksiazke: {}", book);
        return bookRepository.save(book);
    }
}
