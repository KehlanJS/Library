package com.kon.library.controller.dto;

import com.kon.library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

public class AuthorMapper {

    //TODO: uzyj tego by zwrocic w Controller -> DTO, to samo z Books.

    @Autowired
    BookMapper bookMapper;


    //w przypadku Find all to tak samo jak tutaj z getBooks.stream()
    public AuthorDto toDto(Author author) {
        Set<BookDto> books = author.getBooks().stream().map(bookMapper::toDto).collect(Collectors.toSet());

        return new AuthorDto.Builder()
                .name(author.getName())
                .lastName(author.getLastName())
                .birthDate(author.getBirthDate())
                .books(books)
                .build();
    }
}
