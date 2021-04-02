package edu.iitu.library.library.service;

import edu.iitu.library.library.entity.Address;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.User;

import java.util.List;

public interface IUserService {
    Address getAddressByUserId(Integer id);

    User login();

    List<User> getAllUsers();

    User createOrUpdate();

    void delete();

    Address createOrUpdateAddress();

    void deleteAddress();

    List<Book> getOwnedBooks(Integer userId);

    List<Address> getAllAddresses();


}
