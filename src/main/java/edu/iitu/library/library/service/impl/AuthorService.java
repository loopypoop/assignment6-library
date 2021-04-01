package edu.iitu.library.library.service.impl;

import edu.iitu.library.library.entity.Author;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.repository.AuthorRepository;
import edu.iitu.library.library.repository.BookRepository;
import edu.iitu.library.library.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Author createOrUpdate(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void addBook(Integer authorId, Book book) {
        authorRepository.getById(authorId).getBooks().add(book);
    }

    @Override
    public List<Book> getBooksByAuthorId(Integer authorId) {
        return bookRepository.findAllByAuthorId(authorId);
    }

    @Override
    public List<Book> getBooksByAuthorName(String name) {
        return bookRepository.findAllByAuthorName(name);
    }

}
