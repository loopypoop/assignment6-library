package edu.iitu.library.library;

import edu.iitu.library.library.config.SpringConfig;
import edu.iitu.library.library.controller.AuthorController;
import edu.iitu.library.library.controller.BookController;
import edu.iitu.library.library.controller.UserController;
import edu.iitu.library.library.entity.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserController userController = context.getBean(UserController.class);
        BookController bookController = context.getBean(BookController.class);
        AuthorController authorController = context.getBean(AuthorController.class);

        Scanner in = new Scanner(System.in);

        System.out.println("1. CRUD");
        System.out.println("2. Login");
        System.out.println("0. Exit");

        int initialChoice = in.nextInt();

        switch (initialChoice) {
            //CRUD
            case 1:
                int entityChoice = -1;
                while (entityChoice != 0) {
                    System.out.println("1. User");
                    System.out.println("2. User's Address");
                    System.out.println("3. Book");
                    System.out.println("4. Author");
                    System.out.println("0. Back");

                    entityChoice = in.nextInt();
                    int crudChoice = -1;

                    switch (entityChoice) {
                        case 1:
                            System.out.println("1. Create");
                            System.out.println("2. Show all");
                            System.out.println("3. Delete");
                            crudChoice = in.nextInt();

                            switch (crudChoice) {
                                case 1:
                                    userController.create();
                                    break;
                                case 2:
                                    userController.getAll();
                                    break;
                                case 3:
                                    userController.delete();
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("1. Create");
                            System.out.println("2. Show all");
                            System.out.println("3. Delete");

                            crudChoice = in.nextInt();

                            switch (crudChoice) {
                                case 1:
                                    userController.createOrUpdateAddress();
                                    break;
                                case 2:
                                    userController.getAllAddresses();
                                    break;
                                case 3:
                                    userController.delete();
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("1. Create");
                            System.out.println("2. Show all");
                            System.out.println("3. Delete");

                            crudChoice = in.nextInt();

                            switch (crudChoice) {
                                case 1:
                                    bookController.create();
                                    break;
                                case 2:
                                    bookController.getAllBooks();
                                    break;
                                case 3:
                                    bookController.delete();
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println("1. Create");
                            System.out.println("2. Show all");
                            System.out.println("3. Delete");

                            crudChoice = in.nextInt();

                            switch (crudChoice) {
                                case 1:
                                    authorController.createOrUpdate();
                                    break;
                                case 2:
                                    authorController.getAll();
                                    break;
                                case 3:
                                    authorController.deleteById();
                                    break;
                            }
                            break;
                        case 0:
                            return;
                    }
                }
                break;

            //SERVICES
            case 2:
                User currentUser = userController.login();

                if (currentUser != null) {
                    //MENU
                    int userChoice = -1;
                    while (userChoice != 0) {
                        System.out.println("WELCOME " + currentUser.getName());
                        System.out.println("1. Show all books");
                        System.out.println("2. Search book");
                        System.out.println("3. Show available books");
                        System.out.println("0. Logout");

                        userChoice = in.nextInt();

                        switch (userChoice) {
                            case 1:
                                List<Book> books = bookController.getAllBooks();
                                for (int i = 1; i <= books.size(); i++) {
                                    System.out.println(i + ". " + books.get(i - 1).getName());
                                }
                                int bookChoice = in.nextInt();
                                if (bookChoice > books.size() || bookChoice <= 0) {
                                    System.out.println("Wrong choice!");
                                } else {
                                    Book currentBook = books.get(bookChoice - 1);
                                    System.out.println(currentBook);
                                    System.out.println("Do you want to buy this book?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");

                                    int buyChoice = in.nextInt();

                                    if (buyChoice == 1) {
                                        bookController.buy(currentUser, currentBook);
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("Enter name of book");
                                String searchName = in.next();

                                Book currentBook = new Book();
                                currentBook = bookController.getByName(searchName);
                                if (currentBook != null) {
                                    System.out.println(currentBook);
                                    System.out.println("Do you want to buy this book?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");

                                    int buyChoice = in.nextInt();

                                    if (buyChoice == 1) {
                                        bookController.buy(currentUser, currentBook);
                                    }
                                } else {
                                    System.out.println("No such book!");
                                }
                                break;
                            case 3:
                                List<Book> availableBooks = bookController.getAvailableBooks();
                                for (int i = 1; i <= availableBooks.size(); i++) {
                                    System.out.println(i + ". " + availableBooks.get(i - 1).getName());
                                }
                                int bookSelect = in.nextInt();
                                if (bookSelect > availableBooks.size() || bookSelect <= 0) {
                                    System.out.println("Wrong choice!");
                                } else {
                                    Book currentBook1 = availableBooks.get(bookSelect - 1);
                                    System.out.println(currentBook1);
                                    System.out.println("Do you want to buy this book?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");

                                    int buyChoice = in.nextInt();

                                    if (buyChoice == 1) {
                                        bookController.buy(currentUser, currentBook1);
                                    }
                                }
                                break;
                            case 0:
                                break;

                        }
                    }

                } else {
                    System.out.println("Wrong email or password!");
                }
                break;
            case 0:
                System.out.println("Good bye!");
                return;
        }

//        Scanner in = new Scanner(System.in);
//
//        System.out.print("Enter name: ");
//        String name = in.next();
//        System.out.print("Enter email: ");
//        String email = in.next();
//        System.out.print("Enter password: ");
//        String password = in.next();
//
//        User user = new User();
//        user.setName(name);
//        user.setEmail(email);
//        user.setPassword(password);
//
//        userController.createOrUpdate(user);
//        System.out.println("User created successfully!");
//
//        System.out.print("Enter street: ");
//        String street = in.next();
//        System.out.print("Enter house number: ");
//        Integer houseNo = in.nextInt();
//
//        Address address = new Address();
//        address.setStreet(street);
//        address.setHousNo(houseNo);
//
//        address.setUser(user);
//
//        userController.createOrUpdateAddress(address);
//        System.out.println("Address added to user!");
//        System.out.println(userController.getAddressByUserId(user.getId()));
//
//        System.out.print("Enter name of Book: ");
//        String bookName = in.next();
//        System.out.print("Enter description: ");
//        String ignore = in.nextLine();
//        String description = in.nextLine();
//        BookState initialState = BookState.AVAILABLE;
//        System.out.print("Enter price: ");
//        Double price = in.nextDouble();
//
//        Book book = new Book();
//        book.setName(bookName);
//        book.setDescription(description);
//        book.setState(initialState);
//        book.setPrice(price);
//        book.setUserId(user.getId());
//
//        bookController.createOrUpdate(book);
//
//        System.out.println("Book created!");
//
//        System.out.println(userController.getBooksByUserId(user.getId()));
//
//        System.out.print("Enter author's name: ");
//        String authorName = in.next();
//        System.out.print("Enter something about him/her: ");
//        String ignore1 = in.nextLine();
//        String about = in.nextLine();
//
//        Author author = new Author();
//        author.setName(authorName);
//        author.setAbout(about);
//
//        authorController.createOrUpdate(author);
//
//        authorController.addBookToAuthor(author.getId(), book);
//
////        System.out.println("Start by id");
////        System.out.println(authorController.getBooksByAuthorId(author.getId()));
////        System.out.println("End by id");
//
//        System.out.println("Start by author name");
//        System.out.println(authorController.getBooksByAuthorName(author.getName()));
//        System.out.println("End by author name");
    }
}
