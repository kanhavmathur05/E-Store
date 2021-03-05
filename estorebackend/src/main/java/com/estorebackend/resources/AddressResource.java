package com.estorebackend.resources;

import com.estorebackend.entities.Address;
import com.estorebackend.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressResource {

    @Autowired
    AddressService addressService;

    @PostMapping("/add-address")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        Address addressDetails = addressService.addAddress(address);
        return ResponseEntity.status(HttpStatus.OK).body(addressDetails);
    }

    @PostMapping("/update-address")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        Address addressDetails = addressService.addAddress(address);
        return ResponseEntity.status(HttpStatus.OK).body(addressDetails);
    }

    @GetMapping("/all-address/{userId}")
    public ResponseEntity<Page<Address>> getAllAddressOfUser(@PathVariable int userId, Pageable pageable) {
        Page<Address> allAddressOfUser = addressService.listAddress(userId, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(allAddressOfUser);
    }

    @GetMapping("/address/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable int addressId) {
        Address address = addressService.getAddressById(addressId);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @DeleteMapping("/delete-address/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable int addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
