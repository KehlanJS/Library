package com.kon.library.service.author;

import com.kon.library.controller.dto.AuthorDto;
import com.kon.library.controller.dto.AuthorMapper;
import com.kon.library.model.Author;
import com.kon.library.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;
    AuthorMapper authorMapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {

        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public Author addAuthor(Author author) {
        log.info("Dodaje autora: {}", author);
        return authorRepository.save(author);
    }

    public Author findAuthorByNameAndLastName(String author) throws IllegalArgumentException {
        String[] authorData = author.split("[ ]+");
        if(authorData.length != 2){
            throw new IllegalArgumentException("Author's name not valid");
        }
        String name = authorData[0];
        String lastName = authorData[1];
        System.out.println(name + " " + lastName);
        return authorRepository.findByNameAndLastName(name, lastName);
    }

    public List<AuthorDto> getAllAuthors() {
        List<Author> authorList = authorRepository.findAll();

        return authorList.stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList());
    }

}
