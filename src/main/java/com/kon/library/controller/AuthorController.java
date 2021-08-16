package com.kon.library.controller;

import com.kon.library.controller.dto.AuthorDto;
import com.kon.library.model.Author;
import com.kon.library.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "/author")
@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;


    //TODO OGARNAC ABY BIRTHDATE SIE ZAPISYWAL
    @PostMapping(path = "/add", consumes = APPLICATION_JSON_VALUE)
    public Author addAuthor(@RequestBody AuthorDto dto) {
        return authorService.addAuthor(new Author(dto.getName(), dto.getLastName(), dto.getBirthDate()));
    }
}
