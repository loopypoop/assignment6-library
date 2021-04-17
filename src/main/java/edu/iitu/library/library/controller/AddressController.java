package edu.iitu.library.library.controller;

import edu.iitu.library.library.entity.Address;
import edu.iitu.library.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IUserService iUserService;

    @PostMapping(value = "/create")
    public Address createOrUpdateAddress() {
        return iUserService.createOrUpdateAddress();
    }

    @GetMapping(value = "/read/all")
    public List<Address> getAllAddresses() {
        return iUserService.getAllAddresses();
    }

    @DeleteMapping(value = "/delete")
    public void deleteAddress() {
        iUserService.deleteAddress();
    }

    @GetMapping(value = "/read/byId/{userId}")
    public Address getAddressByUserId(@PathVariable Integer userId) {
        return iUserService.getAddressByUserId(userId);
    }
}
