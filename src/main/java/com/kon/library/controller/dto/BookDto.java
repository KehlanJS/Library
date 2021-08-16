package com.kon.library.controller.dto;

import com.kon.library.model.Author;

public class BookDto {

    private String name;
    private String description;
    private Author author;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Author getAuthor() {
        return author;
    }
}
