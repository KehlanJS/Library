package com.kon.library.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NAME",nullable = false)
    private String name;

    @NotNull
    @Column(name = "DESCRIPTION",nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    private Author author;

    public Book(String name, String description, Author author) {
        this.name = name;
        this.description = description;
        this.author = author;
    }
}
