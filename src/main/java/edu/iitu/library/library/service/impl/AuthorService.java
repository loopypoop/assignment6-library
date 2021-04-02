package edu.iitu.library.library.service.impl;

import edu.iitu.library.library.entity.Author;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.repository.AuthorRepository;
import edu.iitu.library.library.repository.BookRepository;
import edu.iitu.library.library.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class AuthorService implements IAuthorService {

    Scanner in = new Scanner(System.in);

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Author createOrUpdate() {
        System.out.print("Enter author's name: ");
        String authorName = in.next();
        System.out.print("Enter something about him/her: ");
        String ignore1 = in.nextLine();
        String about = in.nextLine();

        Author author = new Author();
        author.setName(authorName);
        author.setAbout(about);
        return authorRepository.save(author);
    }

    @Override
    public void deleteById() {
        System.out.print("Enter author's ID: ");
        Integer id = in.nextInt();
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

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
