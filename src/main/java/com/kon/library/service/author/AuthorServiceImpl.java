package com.kon.library.service.author;

import com.kon.library.model.Author;
import com.kon.library.model.Book;
import com.kon.library.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService{


    AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addAuthor(Author author) {
        log.info("Dodaje autora: {}", author);
        return authorRepository.save(author);
    }

    public Author findAuthorByNameAndLastname(String author){
        String [] tmp = author.split(" ");
        String name = tmp[0].trim();
        String lastName = tmp[1].trim();
        System.out.println(name + " " + lastName);
        return authorRepository.findByNameAndLastName(name,lastName);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }


}
