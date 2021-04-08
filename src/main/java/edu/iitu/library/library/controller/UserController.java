package edu.iitu.library.library.controller;

import edu.iitu.library.library.entity.Address;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.User;
import edu.iitu.library.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST, produces = "application/json")
    public User create() {
        return iUserService.create();
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.PUT, produces = "application/json")
    public User update(User user) {
        return iUserService.update(user);
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.DELETE, produces = "application/json")
    public void delete() {
        iUserService.delete();
    }

    @RequestMapping(value = "/user/read/all", method = RequestMethod.GET, produces = "application/json")
    public List<User> getAll() {
        return iUserService.getAllUsers();
    }

    @RequestMapping(value = "/user/read/address/byId/{userId}", method = RequestMethod.GET, produces = "application/json")
    public Address getAddressByUserId(@PathVariable Integer userId) {
        return iUserService.getAddressByUserId(userId);
    }

    @RequestMapping(value = "/user/read/books/byId/{userId}", method = RequestMethod.GET, produces = "application/json")
    public List<Book> getBooksByUserId(@PathVariable Integer userId) {
        return iUserService.getOwnedBooks(userId);
    }

    @RequestMapping(value = "/address/create", method = RequestMethod.POST, produces = "application/json")
    public Address createOrUpdateAddress() {
        return iUserService.createOrUpdateAddress();
    }

    @RequestMapping(value = "/address/read/all", method = RequestMethod.GET, produces = "application/json")
    public List<Address> getAllAddresses() {
        return iUserService.getAllAddresses();
    }

    @RequestMapping(value = "/address/delete", method = RequestMethod.DELETE, produces = "application/json")
    public void deleteAddress() {
        iUserService.deleteAddress();
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET, produces = "application/json")
    public User login() {
        return iUserService.login();
    }
}
