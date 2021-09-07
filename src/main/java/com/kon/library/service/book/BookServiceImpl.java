package com.kon.library.service.book;

import com.kon.library.controller.dto.BookDto;
import com.kon.library.model.Author;
import com.kon.library.model.Book;
import com.kon.library.repository.BookRepository;
import com.kon.library.service.author.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookServiceImpl implements BookService{


    BookRepository bookRepository;
    AuthorService authorService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public Book addBook(BookDto bookDto) {
        log.info("Dodaje ksiazke: {}", bookDto);
        //return bookRepository.save(book);
        Author author = authorService.findAuthorByNameAndLastname(bookDto.getAuthor());
        System.out.println(author);
        return bookRepository.save(new Book(bookDto.getName(),bookDto.getDescription(), author));
    }


//    private Author isAuthorPresent(String name){
//        if()
//    }
}
