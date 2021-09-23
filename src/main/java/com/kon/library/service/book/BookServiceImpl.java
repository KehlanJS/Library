package com.kon.library.service.book;

import com.kon.library.controller.dto.BookDto;
import com.kon.library.controller.dto.BookMapper;
import com.kon.library.model.Author;
import com.kon.library.model.Book;
import com.kon.library.repository.BookRepository;
import com.kon.library.service.author.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService{


    BookRepository bookRepository;
    AuthorService authorService;
    BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.bookMapper = bookMapper;
    }

    @Override
    public Book addBook(BookDto bookDto) {
        log.info("Dodaje ksiazke: {}", bookDto);
       try{
           Author author = authorService.findAuthorByNameAndLastname(bookDto.getAuthor());
           System.out.println(author);
           return bookRepository.save(new Book(bookDto.getName(),bookDto.getDescription(), author));
       }catch(IllegalArgumentException e){
           System.out.println(e.getMessage());
           return null;
       }
    }

    public List<BookDto> getAllBooks(){
        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }
}
