package edu.iitu.library.library.service.impl;

import edu.iitu.library.library.entity.Address;
import edu.iitu.library.library.entity.Book;
import edu.iitu.library.library.entity.Role;
import edu.iitu.library.library.entity.User;
import edu.iitu.library.library.repository.AddressRepository;
import edu.iitu.library.library.repository.BookRepository;
import edu.iitu.library.library.repository.RoleRepository;
import edu.iitu.library.library.repository.UserRepository;
import edu.iitu.library.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class UserService implements IUserService, UserDetailsService {

    Scanner in = new Scanner(System.in);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Address getAddressByUserId(Integer userId) {
        return addressRepository.getByUserId(userId);
    }

    @Override
    public void signup(User user) {
        Role userRole = roleRepository.findByName("USER");

        System.out.println("user = " + user.getUsername());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBalance(0.0);
        user.setRoles(Arrays.asList(userRole));

        userRepository.save(user);

        System.out.println("User signed up successfully!");
    }

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User createCustom(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User: " + username + " not found!");
        }
            return user;
    }
}
