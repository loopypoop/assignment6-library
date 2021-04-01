package edu.iitu.library.library.controller;

import edu.iitu.library.library.entity.Author;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private IAuthorService iAuthorService;

    public Author createOrUpdate(Author author) {
        return iAuthorService.createOrUpdate(author);
    }

    public void deleteById(Integer id) {
        iAuthorService.deleteById(id);
    }

    public void addBookToAuthor(Integer authorId, Book book) {
        iAuthorService.addBook(authorId, book);
    }

    public List<Book> getBooksByAuthorId(Integer authorId) {
        return iAuthorService.getBooksByAuthorId(authorId);
    }

    public List<Book> getBooksByAuthorName(String name) {
        return iAuthorService.getBooksByAuthorName(name);
    }
}
