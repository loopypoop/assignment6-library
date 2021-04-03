package edu.iitu.library.library.service.impl;

import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.BookState;
import edu.iitu.library.library.entity.User;
import edu.iitu.library.library.repository.BookRepository;
import edu.iitu.library.library.repository.UserRepository;
import edu.iitu.library.library.service.IBookService;
import edu.iitu.library.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class BookService implements IBookService {

    Scanner in = new Scanner(System.in);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private IUserService userService;

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book create() {

        System.out.print("Enter name of Book: ");
        String bookName = in.next();
        System.out.print("Enter description: ");
        String ignore = in.nextLine();
        String description = in.nextLine();
        BookState initialState = BookState.AVAILABLE;
        System.out.print("Enter price: ");
        Double price = in.nextDouble();

        Book book = new Book();
        book.setName(bookName);
        book.setDescription(description);
        book.setState(initialState);
        book.setPrice(price);
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete() {
        System.out.print("Enter id of book: ");
        Integer id = in.nextInt();
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void buyBook(User user, Book book) {

        if (user.getBalance() >= book.getPrice()) {
            user.setBalance(user.getBalance() - book.getPrice());
            book.setState(BookState.REQUESTED);
            book.setUserId(user.getId());
            book.setUser(user);
            this.update(book);
            userService.update(user);
            System.out.println("Book successfully requested!");
        } else if (user.getBalance() < book.getPrice()) {
            System.out.println("Not enough money...");
        } else if (book.getState() != BookState.AVAILABLE) {
            System.out.println("Book is not available");
        }
    }

    @Override
    public Book getByName(String name) {
        return bookRepository.getBookByName(name);
    }

    @Override
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = bookRepository.getAllByState(BookState.AVAILABLE);
        return availableBooks;
    }
}
