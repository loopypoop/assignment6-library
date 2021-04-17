package edu.iitu.library.library.controller;

import edu.iitu.library.library.entity.Address;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.User;
import edu.iitu.library.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/create-user")
    public void createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        iUserService.createCustom(user);
    }

    @PostMapping(value = "/create")
    public User create(@RequestBody User user) {
        return iUserService.create(user);
    }

    @PutMapping(value = "/update")
    public User update(@RequestBody User user) {
        return iUserService.update(user);
    }

    @DeleteMapping(value = "/delete")
    public void delete() {
        iUserService.delete();
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public List<User> getAll() {
        return iUserService.getAllUsers();
    }

    @GetMapping(value = "/read/books/byId/{userId}")
    public List<Book> getBooksByUserId(@PathVariable Integer userId) {
        return iUserService.getOwnedBooks(userId);
    }
}
