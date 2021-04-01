package edu.iitu.library.library.repository;

import edu.iitu.library.library.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address getByUserId(Integer id);
}
