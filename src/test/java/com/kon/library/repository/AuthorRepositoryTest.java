package com.kon.library.repository;

import com.kon.library.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void findByNameAndLastnameTest_shouldReturnValidAuthor() {
        Author author = new Author("Lesiu", "lalala", new Date());
        authorRepository.save(author);

        final Author result = authorRepository.findByNameAndLastName("Lesiu", "lalala");

        assertNotNull(result);
        assertEquals(result.getName(), author.getName());
        assertEquals(result.getLastName(), author.getLastName());
    }

    @Test
    void findByNameAndLastnameTest_shouldReturnNull_whenAuthorNotPresent(){
        final Author result = authorRepository.findByNameAndLastName("Lesiu", "lalala");

        assertNull(result);
    }

}
