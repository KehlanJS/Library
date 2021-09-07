package com.kon.library.service.author;

import com.kon.library.model.Author;

import java.util.List;

public interface AuthorService {

    Author addAuthor(Author author);

    Author findAuthorByNameAndLastname(String author);

    List<Author> getAllAuthors();

}
