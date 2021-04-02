package edu.iitu.library.library.service;

import edu.iitu.library.library.entity.Author;
import edu.iitu.library.library.entity.Book;

import java.util.List;

public interface IAuthorService {

    Author createOrUpdate();

    void deleteById();

    void addBook(Integer authorId, Book book);

    List<Book> getBooksByAuthorId(Integer authorId);

    List<Book> getBooksByAuthorName(String name);

    List<Author> getAll();

}
