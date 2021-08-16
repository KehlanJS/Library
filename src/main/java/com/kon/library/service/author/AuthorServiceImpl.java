package com.kon.library.service.author;

import com.kon.library.model.Author;
import com.kon.library.model.Book;
import com.kon.library.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        log.info("Dodaje autora: {}", author);
        return authorRepository.save(author);
    }
}
