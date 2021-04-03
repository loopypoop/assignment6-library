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
import java.util.Scanner;

@Service
public class UserService implements IUserService {

    Scanner in = new Scanner(System.in);

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
    public User login() {
        System.out.print("Enter email: ");
        String email = in.next();
        System.out.print("Enter password: ");
        String password = in.next();

        return userRepository.getByEmailAndPassword(email, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User create() {

        System.out.print("Enter name: ");
        String name = in.next();
        System.out.print("Enter email: ");
        String email = in.next();
        System.out.print("Enter password: ");
        String password = in.next();
        System.out.print("Enter balance: ");
        Double balance = in.nextDouble();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setBalance(balance);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete() {
        System.out.print("Enter user's ID: ");
        Integer id = in.nextInt();
        userRepository.deleteById(id);
    }

    @Override
    public Address createOrUpdateAddress() {

        System.out.print("Enter street: ");
        String street = in.next();
        System.out.print("Enter house number: ");
        Integer houseNo = in.nextInt();

        Address address = new Address();
        address.setStreet(street);
        address.setHousNo(houseNo);

        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress() {
        System.out.print("Enter ID of address: ");
        Integer id = in.nextInt();
        addressRepository.deleteById(id);
    }

    @Override
    public List<Book> getOwnedBooks(Integer userId) {
        return bookRepository.getAllByUserId(userId);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.getById(id);
    }
}
