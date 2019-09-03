package com.example.gg.controller;

import com.example.gg.model.Address;
import com.example.gg.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;


    @PostMapping("/")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) throws IOException {
        Address result = addressService.save(address);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable long id) throws IOException {
        return ResponseEntity.ok(addressService.get(id));

    }

    @PutMapping("/")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) throws IOException {
        return ResponseEntity.ok(addressService.update(address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAddress(@PathVariable long id) throws IOException {
        addressService.delete(id);
        return ResponseEntity.ok("");
    }

}
