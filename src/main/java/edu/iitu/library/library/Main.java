package edu.iitu.library.library;

import edu.iitu.library.library.config.SpringConfig;
import edu.iitu.library.library.controller.AuthorController;
import edu.iitu.library.library.controller.BookController;
import edu.iitu.library.library.controller.UserController;
import edu.iitu.library.library.entity.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserController userController = context.getBean(UserController.class);
        BookController bookController = context.getBean(BookController.class);
        AuthorController authorController = context.getBean(AuthorController.class);

        Scanner in = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = in.next();
        System.out.print("Enter email: ");
        String email = in.next();
        System.out.print("Enter password: ");
        String password = in.next();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        userController.createOrUpdate(user);
        System.out.println("User created successfully!");

        System.out.print("Enter street: ");
        String street = in.next();
        System.out.print("Enter house number: ");
        Integer houseNo = in.nextInt();

        Address address = new Address();
        address.setStreet(street);
        address.setHousNo(houseNo);

        address.setUser(user);

        userController.createOrUpdateAddress(address);
        System.out.println("Address added to user!");
        System.out.println(userController.getAddressByUserId(user.getId()));

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
        book.setUserId(user.getId());

        bookController.createOrUpdate(book);

        System.out.println("Book created!");

        System.out.println(userController.getBooksByUserId(user.getId()));

        System.out.print("Enter author's name: ");
        String authorName = in.next();
        System.out.print("Enter something about him/her: ");
        String ignore1 = in.nextLine();
        String about = in.nextLine();

        Author author = new Author();
        author.setName(authorName);
        author.setAbout(about);

        authorController.createOrUpdate(author);

        authorController.addBookToAuthor(author.getId(), book);

//        System.out.println("Start by id");
//        System.out.println(authorController.getBooksByAuthorId(author.getId()));
//        System.out.println("End by id");

        System.out.println("Start by author name");
        System.out.println(authorController.getBooksByAuthorName(author.getName()));
        System.out.println("End by author name");
    }
}
