package edu.iitu.library.library.controller;

import edu.iitu.library.library.entity.Author;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private IAuthorService iAuthorService;

    @PostMapping(value = "/author/create", produces = "application/json")
    public Author createOrUpdate() {
        return iAuthorService.createOrUpdate();
    }

    @DeleteMapping(value = "/author/delete")
    public void deleteById() {
        iAuthorService.deleteById();
    }

    @GetMapping(value = "/author/read/all")
    public List<Author> getAll() {
        return iAuthorService.getAll();
    }

    @PutMapping(value = "/author/add/book/{authorId}")
    public void addBookToAuthor(@PathVariable Integer authorId,@RequestBody Book book) {
        iAuthorService.addBook(authorId, book);
    }

    @GetMapping(value = "/author/read/books/byId/{authorId}")
    public List<Book> getBooksByAuthorId(@PathVariable(value = "authorId") Integer authorId) {
        return iAuthorService.getBooksByAuthorId(authorId);
    }

    @GetMapping(value = "/author/read/books/byName/{authorName}")
    public List<Book> getBooksByAuthorName(@PathVariable(value = "authorName") String name) {
        return iAuthorService.getBooksByAuthorName(name);
    }
}
