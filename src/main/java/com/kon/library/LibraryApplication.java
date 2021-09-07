package com.kon.library;

import com.kon.library.controller.AuthorController;
import com.kon.library.controller.BookController;
import com.kon.library.controller.dto.AuthorDto;
import com.kon.library.controller.dto.BookDto;
import com.kon.library.service.author.AuthorServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
}
