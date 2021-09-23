package com.kon.library.repository;

import com.kon.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //TODO napisac test dla findAll(), storz dwie ksiazki i zapisz na baze i znajdz, operacje na listach

}
