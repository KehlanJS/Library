package com.kon.library.service;


import com.kon.library.model.Author;
import com.kon.library.repository.AuthorRepository;
import com.kon.library.service.author.AuthorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    void findAuthorByNameAndLastnameTest() {

        Mockito.when(authorRepository.findByNameAndLastName("Konrad", "Jurczyk"))
                .thenReturn(new Author("Konrad", "Jurczyk", new Date()));

        authorService.findAuthorByNameAndLastname("Konrad Jurczyk");

        verify(authorRepository, times(1))
                .findByNameAndLastName("Konrad", "Jurczyk");
    }

    @Test
    void findAuthorByNameAndLastnameTest_onlyName_shouldThrowIllegalArgumentException() {
        String name = "Konrad";
        assertThrows(IllegalArgumentException.class, () -> authorService.findAuthorByNameAndLastname(name));
    }

    // TODO napisac test w przypadku gdy dostane 3 stringi po spacji i naprawic metode.

    @Test
    void findAuthorByNameAndLastnameTest_name_middleName_lastName_shouldThrowIllegalArgumentException() {
//        Mockito.when(authorRepository.findByNameAndLastName("Konrad", "Jurczyk"))
//                .thenReturn(new Author("Konrad", "Jurczyk", new Date()));

        String name = "Konrad Jurczyk Celofan";

        assertThrows(IllegalArgumentException.class, () -> authorService.findAuthorByNameAndLastname(name));
//        verify(authorRepository)
//                .findByNameAndLastName("Konrad", "Jurczyk");
    }
}
