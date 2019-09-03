package com.example.gg.service;

import com.example.gg.model.Address;

import java.io.IOException;

public interface AddressService {

    Address save(Address address) throws IOException;

    Address get(long id) throws IOException;

    Address update(Address address) throws IOException;

    void delete(long id) throws IOException;





}
