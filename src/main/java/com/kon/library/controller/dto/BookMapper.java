package com.kon.library.controller.dto;

import com.kon.library.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public BookDto toDto(Book book) {

        final String author = book.getAuthor().getName() + " " + book.getAuthor().getLastName();

        return new BookDto.Builder()
                .name(book.getName())
                .description(book.getDescription())
                .author(author)
                .build();
    }
}
