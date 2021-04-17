package edu.iitu.library.library.service;

import edu.iitu.library.library.entity.Address;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.User;

import java.util.List;

public interface IUserService {
    Address getAddressByUserId(Integer id);

    void signup(User user);

    User login(User user);

    List<User> getAllUsers();

    User create(User user);

    User createCustom(User user);

    User update(User user);

    void delete();

    Address createOrUpdateAddress();

    void deleteAddress();

    List<Book> getOwnedBooks(Integer userId);

    List<Address> getAllAddresses();

    User getById(Integer id);
}
