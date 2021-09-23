package com.kon.library.repository;

import com.kon.library.model.Author;
import com.kon.library.model.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void findAllTest() {
        Author author = new Author("asfas", "adfdsfa", new Date());
        Author author2 = new Author("asfasdas", "adfdasdsfa", new Date());
        authorRepository.saveAll(List.of(author, author2));

        Book book1 = new Book("adf", "adfad", author);
        Book book2 = new Book("aaddf", "adfaadd", author2);
        List<Book> booksToSave = bookRepository.saveAll(List.of(book1, book2));

        final List<Book> result = bookRepository.findAll();

        assertEquals(booksToSave, result);
    }

}