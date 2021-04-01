package edu.iitu.library.library.service.impl;

import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.repository.BookRepository;
import edu.iitu.library.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book createOrUpdate(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
