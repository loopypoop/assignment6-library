package edu.iitu.library.library.service;

import edu.iitu.library.library.entity.Address;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.User;

import java.util.List;

public interface IUserService {
    Address getAddressByUserId(Integer id);

    User login(String email, String password);

    List<User> getAllUsers();

    User createOrUpdate(User user);

    void delete(Integer id);

    Address createOrUpdateAddress(Address address);

    void deleteAddress(Integer id);

    List<Book> getOwnedBooks(Integer userId);

}
