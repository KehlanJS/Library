package com.kon.library.controller.dto;

import java.io.Serializable;


public class AuthorDto implements Serializable {
    private String name;
    private String lastName;

    public AuthorDto(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
