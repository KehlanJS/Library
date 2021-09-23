package com.kon.library.controller.dto;

import com.kon.library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorMapper {

    BookMapper bookMapper;

    @Autowired
    public AuthorMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

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
