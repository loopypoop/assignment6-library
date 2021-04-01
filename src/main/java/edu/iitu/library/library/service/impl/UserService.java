package edu.iitu.library.library.service.impl;

import edu.iitu.library.library.entity.Address;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.User;
import edu.iitu.library.library.repository.AddressRepository;
import edu.iitu.library.library.repository.BookRepository;
import edu.iitu.library.library.repository.UserRepository;
import edu.iitu.library.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BookRepository bookRepository;


    @Override
    public Address getAddressByUserId(Integer userId) {
        return addressRepository.getByUserId(userId);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.getByEmailAndPassword(email, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Address createOrUpdateAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Book> getOwnedBooks(Integer userId) {
        return bookRepository.getAllByUserId(userId);
    }
}
