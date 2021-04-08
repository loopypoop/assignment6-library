package edu.iitu.library.library.controller;

import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.User;
import edu.iitu.library.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private IBookService iBookService;

    @RequestMapping(value = "/books/create", method = RequestMethod.POST, produces = "application/json")
    public Book create() {
        return iBookService.create();
    }

    @RequestMapping(value = "/books/read/all", method = RequestMethod.GET, produces = "application/json")
    public List<Book> getAllBooks() {
        return iBookService.getAllBooks();
    }

    @RequestMapping(value = "/books/delete", method = RequestMethod.DELETE, produces = "application/json")
    public void delete() {
        iBookService.delete();
    }

    @RequestMapping(value = "/books/user/buy", method = RequestMethod.PUT, produces = "application/json")
    public void buy(@RequestBody User user,@RequestBody Book book) {
        iBookService.buyBook(user, book);
    }

    @RequestMapping(value = "/books/read/byName/{bookName}", method = RequestMethod.GET, produces = "application/json")
    public Book getByName(@PathVariable(value = "bookName") String name) {
        return iBookService.getByName(name);
    }

    @RequestMapping(value = "/books/read/available", method = RequestMethod.GET, produces = "application/json")
    public List<Book> getAvailableBooks() {
        return iBookService.getAvailableBooks();
    }

}
