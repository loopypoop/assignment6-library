package edu.iitu.library.library.service;

import edu.iitu.library.library.entity.Book;

import java.util.List;

public interface IBookService {
    Book getBookById(Integer id);

    Book createOrUpdate(Book book);

    void delete(Integer id);

    List<Book> getAllBooks();
}
