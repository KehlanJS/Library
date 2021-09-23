package com.kon.library.controller.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


public class AuthorDto implements Serializable {
    private String name;
    private String lastName;
    private Date birthDate;
    private Set<BookDto> books;

    public AuthorDto() {
    }

    public AuthorDto(String name, String lastName, Date birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    private AuthorDto(Builder builder) {
        this.name = builder.getName();
        this.lastName = builder.getLastName();
        this.birthDate = builder.getBirthDate();
        this.books = builder.getBooks();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Set<BookDto> getBooks() {
        return books;
    }

    public static class Builder {
        private String name;
        private String lastName;
        private Date birthDate;
        private Set<BookDto> books;

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public Set<BookDto> getBooks() {
            return books;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder birthDate(Date date) {
            this.birthDate = date;
            return this;
        }

        public Builder books(Set<BookDto> books) {
            this.books = books;
            return this;
        }

        public AuthorDto build() {
            return new AuthorDto(this);
        }
    }
}
