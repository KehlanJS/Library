package com.kon.library.controller.dto;

import java.io.Serializable;
import java.util.Date;


public class AuthorDto implements Serializable {
    private String name;
    private String lastName;
    private Date birthDate;

    public AuthorDto(String name, String lastName, Date birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate(){
        return birthDate;
    }
}
