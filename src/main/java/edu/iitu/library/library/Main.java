package edu.iitu.library.library;

import edu.iitu.library.library.config.SwaggerConfig;
import edu.iitu.library.library.controller.*;
import edu.iitu.library.library.entity.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//
//        UserController userController = context.getBean(UserController.class);
//        BookController bookController = context.getBean(BookController.class);
//        AuthorController authorController = context.getBean(AuthorController.class);
//        AuthController authController = context.getBean(AuthController.class);
//        AddressController addressController = context.getBean(AddressController.class);
//
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("1. CRUD");
//        System.out.println("2. Login");
//        System.out.println("3. Signup");
//        System.out.println("0. Exit");
//
//        int initialChoice = in.nextInt();
//
//        switch (initialChoice) {
//            //CRUD
//            case 1:
//                int entityChoice = -1;
//                while (entityChoice != 0) {
//                    System.out.println("1. User");
//                    System.out.println("2. User's Address");
//                    System.out.println("3. Book");
//                    System.out.println("4. Author");
//                    System.out.println("0. Back");
//
//                    entityChoice = in.nextInt();
//                    int crudChoice = -1;
//
//                    switch (entityChoice) {
//                        case 1:
//                            System.out.println("1. Create");
//                            System.out.println("2. Show all");
//                            System.out.println("3. Delete");
//                            crudChoice = in.nextInt();
//
//                            switch (crudChoice) {
//                                case 1:
//                                    System.out.print("Enter name: ");
//                                    String name = in.next();
//                                    System.out.print("Enter email: ");
//                                    String email = in.next();
//                                    System.out.print("Enter password: ");
//                                    String password = in.next();
//                                    System.out.print("Enter balance: ");
//                                    Double balance = in.nextDouble();
//
//                                    User userCreate = new User();
//                                    userCreate.setName(name);
//                                    userCreate.setEmail(email);
//                                    userCreate.setPassword(password);
//                                    userCreate.setBalance(balance);
//                                    userController.create(userCreate);
//                                    break;
//                                case 2:
//                                    userController.getAll();
//                                    break;
//                                case 3:
//                                    userController.delete();
//                                    break;
//                            }
//                            break;
//                        case 2:
//                            System.out.println("1. Create");
//                            System.out.println("2. Show all");
//                            System.out.println("3. Delete");
//
//                            crudChoice = in.nextInt();
//
//                            switch (crudChoice) {
//                                case 1:
//                                    addressController.createOrUpdateAddress();
//                                    break;
//                                case 2:
//                                    addressController.getAllAddresses();
//                                    break;
//                                case 3:
//                                    userController.delete();
//                                    break;
//                            }
//                            break;
//                        case 3:
//                            System.out.println("1. Create");
//                            System.out.println("2. Show all");
//                            System.out.println("3. Delete");
//
//                            crudChoice = in.nextInt();
//
//                            switch (crudChoice) {
//                                case 1:
//                                    bookController.create();
//                                    break;
//                                case 2:
//                                    bookController.getAllBooks();
//                                    break;
//                                case 3:
//                                    bookController.delete();
//                                    break;
//                            }
//                            break;
//                        case 4:
//                            System.out.println("1. Create");
//                            System.out.println("2. Show all");
//                            System.out.println("3. Delete");
//
//                            crudChoice = in.nextInt();
//
//                            switch (crudChoice) {
//                                case 1:
//                                    authorController.createOrUpdate();
//                                    break;
//                                case 2:
//                                    authorController.getAll();
//                                    break;
//                                case 3:
//                                    authorController.deleteById();
//                                    break;
//                            }
//                            break;
//                        case 0:
//                            return;
//                    }
//                }
//                break;
//
//            //SERVICES
//            case 2:
//                System.out.print("Enter email: ");
//                String username = in.next();
//                System.out.print("Enter password: ");
//                String password = in.next();
//
//                User currentUser = new User();
//                currentUser.setUsername(username);
//                currentUser.setPassword(password);
//                        authController.login(currentUser);
//
//                if (currentUser != null) {
//                    //MENU
//                    int userChoice = -1;
//                    while (userChoice != 0) {
//                        System.out.println("WELCOME " + currentUser.getName());
//                        System.out.println("1. Show all books");
//                        System.out.println("2. Search book");
//                        System.out.println("3. Show available books");
//                        System.out.println("0. Logout");
//
//                        userChoice = in.nextInt();
//
//                        switch (userChoice) {
//                            case 1:
//                                List<Book> books = bookController.getAllBooks();
//                                for (int i = 1; i <= books.size(); i++) {
//                                    System.out.println(i + ". " + books.get(i - 1).getName());
//                                }
//                                int bookChoice = in.nextInt();
//                                if (bookChoice > books.size() || bookChoice <= 0) {
//                                    System.out.println("Wrong choice!");
//                                } else {
//                                    Book currentBook = books.get(bookChoice - 1);
//                                    System.out.println(currentBook);
//                                    System.out.println("Do you want to buy this book?");
//                                    System.out.println("1. Yes");
//                                    System.out.println("2. No");
//
//                                    int buyChoice = in.nextInt();
//
//                                    if (buyChoice == 1) {
//                                        bookController.buy(currentUser, currentBook);
//                                    }
//                                }
//                                break;
//                            case 2:
//                                System.out.print("Enter name of book");
//                                String searchName = in.next();
//
//                                Book currentBook = new Book();
//                                currentBook = bookController.getByName(searchName);
//                                if (currentBook != null) {
//                                    System.out.println(currentBook);
//                                    System.out.println("Do you want to buy this book?");
//                                    System.out.println("1. Yes");
//                                    System.out.println("2. No");
//
//                                    int buyChoice = in.nextInt();
//
//                                    if (buyChoice == 1) {
//                                        bookController.buy(currentUser, currentBook);
//                                    }
//                                } else {
//                                    System.out.println("No such book!");
//                                }
//                                break;
//                            case 3:
//                                List<Book> availableBooks = bookController.getAvailableBooks();
//                                for (int i = 1; i <= availableBooks.size(); i++) {
//                                    System.out.println(i + ". " + availableBooks.get(i - 1).getName());
//                                }
//                                int bookSelect = in.nextInt();
//                                if (bookSelect > availableBooks.size() || bookSelect <= 0) {
//                                    System.out.println("Wrong choice!");
//                                } else {
//                                    Book currentBook1 = availableBooks.get(bookSelect - 1);
//                                    System.out.println(currentBook1);
//                                    System.out.println("Do you want to buy this book?");
//                                    System.out.println("1. Yes");
//                                    System.out.println("2. No");
//
//                                    int buyChoice = in.nextInt();
//
//                                    if (buyChoice == 1) {
//                                        bookController.buy(currentUser, currentBook1);
//                                    }
//                                }
//                                break;
//                            case 0:
//                                break;
//
//                        }
//                    }
//
//                } else {
//                    System.out.println("Wrong email or password!");
//                }
//                break;
//            case 3:
//                System.out.print("Enter name: ");
//                String newName = in.next();
//                System.out.print("Enter email: ");
//                String newEmail = in.next();
//                System.out.print("Enter password: ");
//                String newPassword = in.next();
//
//                User newUser = new User();
//                newUser.setName(newName);
//                newUser.setEmail(newEmail);
//                newUser.setPassword(newPassword);
//                authController.signup(newUser);
//                break;
//            case 0:
//                System.out.println("Good bye!");
//                return;
//        }
    }
}
