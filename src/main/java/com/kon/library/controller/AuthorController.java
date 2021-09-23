package com.kon.library.controller;

import com.kon.library.controller.dto.AuthorDto;
import com.kon.library.controller.dto.AuthorMapper;
import com.kon.library.model.Author;
import com.kon.library.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//TODO: PRZYDEKOROWAC KONTROLLERY W RESPONSE ENTITY

@RequestMapping(path = "/author")
@RestController
public class AuthorController {

    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(path = "/add", consumes = APPLICATION_JSON_VALUE)
    public void addAuthor(@RequestBody AuthorDto dto) {
        Author author = new Author(dto.getName(), dto.getLastName(), dto.getBirthDate());
        authorService.addAuthor(author);
    }

    @ResponseBody
    @GetMapping(path = "/all")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        final var authorList = authorService.getAllAuthors();

        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }
}
