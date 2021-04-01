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

    public User createOrUpdate(User user) {
        return iUserService.createOrUpdate(user);
    }

    public void delete(Integer id) {
        iUserService.delete(id);
    }

    public Address createOrUpdateAddress(Address address) {
        return iUserService.createOrUpdateAddress(address);
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
}
