package edu.iitu.library.library.controller;

import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private IBookService iBookService;

    public Book createOrUpdate(Book book) {
        return iBookService.createOrUpdate(book);
    }

    public List<Book> getAllBooks() {
        return iBookService.getAllBooks();
    }

}
