package edu.iitu.library.library.controller;

import edu.iitu.library.library.entity.Address;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.User;
import edu.iitu.library.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    public User create() {
        return iUserService.create();
    }

    public User update(User user) {
        return iUserService.update(user);
    }

    public void delete() {
        iUserService.delete();
    }

    public List<User> getAll() {
        return iUserService.getAllUsers();
    }

    public Address getAddressByUserId(Integer userId) {
        return iUserService.getAddressByUserId(userId);
    }

    public List<Book> getBooksByUserId(Integer userId) {
        return iUserService.getOwnedBooks(userId);
    }

    public Address createOrUpdateAddress() {
        return iUserService.createOrUpdateAddress();
    }

    public List<Address> getAllAddresses() {
        return iUserService.getAllAddresses();
    }

    public void deleteAddress() {
        iUserService.deleteAddress();
    }

    public User login() {
        return iUserService.login();
    }
}
