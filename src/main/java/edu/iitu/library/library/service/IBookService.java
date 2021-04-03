package edu.iitu.library.library.service;

import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.User;

import java.util.List;

public interface IBookService {
    Book getBookById(Integer id);

    Book create();

    Book update(Book book);

    void delete();

    List<Book> getAllBooks();

    void buyBook(User user, Book book);

    Book getByName(String name);

    List<Book> getAvailableBooks();
}
