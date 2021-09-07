package com.kon.library.controller.dto;

import com.kon.library.model.Author;

public class BookDto {

    private String name;
    private String description;
    private String author;

    private BookDto(Builder builder){
        this.name = builder.getName();
        this.description = builder.getDescription();
        this.author = builder.getAuthor();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public static class Builder{
        private String name;
        private String description;
        private String author;

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getAuthor() {
            return author;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder author(String author){
            this.author = author;
            return this;
        }

        public BookDto build(){
            return new BookDto(this);
        }
    }
}
