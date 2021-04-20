package edu.iitu.library.library.controller;

import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.User;
import edu.iitu.library.library.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "User Controller Class", description = "This class allows to interact with User object")
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
    @ApiOperation(value = "Method to get list of users", response = List.class)
    public List<User> getAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication = " + authentication.getName());
        return iUserService.getAllUsers();
    }

    @GetMapping(value = "/read/books/byId/{userId}")
    public List<Book> getBooksByUserId(@PathVariable Integer userId) {
        return iUserService.getOwnedBooks(userId);
    }
}
