package edu.iitu.library.library.controller;

import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.User;
import edu.iitu.library.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private IBookService iBookService;

    public Book create() {
        return iBookService.create();
    }

    public List<Book> getAllBooks() {
        return iBookService.getAllBooks();
    }

    public void delete() {
        iBookService.delete();
    }

    public void buy(User user, Book book) {
        iBookService.buyBook(user, book);
    }

    public Book getByName(String name) {
        return iBookService.getByName(name);
    }

    public List<Book> getAvailableBooks() {
        return iBookService.getAvailableBooks();
    }

}
