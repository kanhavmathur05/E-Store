package com.estorebackend.services.impl;

import com.estorebackend.entities.Address;
import com.estorebackend.repositories.AddressRepository;
import com.estorebackend.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(int addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public Page<Address> listAddress(int userId, Pageable pageable) {
        return addressRepository.findAllByUserId(userId, pageable);
    }

    @Override
    public Address getAddressById(int addressId) {
        return addressRepository.findById(addressId).get();
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }
}
