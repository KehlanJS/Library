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

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    void findAuthorByNameAndLastNameTest() {

        Mockito.when(authorRepository.findByNameAndLastName("Konrad", "Jurczyk"))
                .thenReturn(new Author("Konrad", "Jurczyk", new Date()));

        authorService.findAuthorByNameAndLastName("Konrad Jurczyk");

        verify(authorRepository, times(1))
                .findByNameAndLastName("Konrad", "Jurczyk");
    }

    @Test
    void findAuthorByNameAndLastNameTest_onlyName_shouldThrowIllegalArgumentException() {
        String name = "Konrad";
        assertThrows(IllegalArgumentException.class, () -> authorService.findAuthorByNameAndLastName(name));
    }

    @Test
    void findAuthorByNameAndLastNameTest_name_middleName_lastName_shouldThrowIllegalArgumentException() {
        String name = "Konrad Jurczyk Celofan";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> authorService.findAuthorByNameAndLastName(name));

        String expectedMessage = "Author's name not valid";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
