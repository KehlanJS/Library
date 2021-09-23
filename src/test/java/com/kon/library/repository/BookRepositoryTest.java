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

    @Test
    void findAllTest(){
        Book book1 = new Book("adf", "adfad", new Author("asfas","adfdsfa", new Date()));
        Book book2 = new Book("aaddf", "adfaadd", new Author("asfasdas","adfdasdsfa", new Date()));

        bookRepository.save(book1);
        bookRepository.save(book2);
        List<Book> booksInRepo = bookRepository.findAll();


        List<Book> booksInTest = new ArrayList<>();
        booksInTest.add(book1);
        booksInTest.add(book2);

        assertEquals(booksInTest,booksInRepo);
    }


}