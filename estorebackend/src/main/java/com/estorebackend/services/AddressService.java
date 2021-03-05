package com.estorebackend.services;

import com.estorebackend.entities.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService {
    Address addAddress(Address address);

    void deleteAddress(int addressId);

    Page<Address> listAddress(int userId, Pageable pageable);

    Address getAddressById(int addressId);

    Address updateAddress(Address address);
}
