package com.kon.library.service.author;

import com.kon.library.controller.dto.AuthorDto;
import com.kon.library.model.Author;

import java.util.List;

public interface AuthorService {

    Author addAuthor(Author author);

    Author findAuthorByNameAndLastName(String author);

    List<AuthorDto> getAllAuthors();

}
