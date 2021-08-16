package com.kon.library.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    @NotNull
    private Long id;

    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "LASTNAME", nullable = false)
    @NotNull
    private String lastName;

    @Column(name = "BIRTHDATE", nullable = true)
    @NotNull
    private Date birthDate;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    public Author(String name, String lastName, Date birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Author(){}
}
