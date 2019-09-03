package com.example.gg.service;

import com.example.gg.model.Address;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class AddressServiceImpl implements AddressService {

    AtomicLong idCounter = new AtomicLong();

    @Override
    public Address save(Address address) throws IOException {

        address.setId(idCounter.incrementAndGet());
        String addressAsString = addressToCommaSeparatedString(address);

        Files.write(Paths.get(address.getId() + ".txt"), addressAsString.getBytes());

        return address;

    }

    @Override
    public Address get(long id) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(id + ".txt")));
        return commaSeparatedStringToAddress(content);
    }

    @Override
    public Address update(Address address) throws IOException {

        if (!Files.exists(Paths.get(address.getId() + ".txt"))) {
            throw new FileSystemNotFoundException();
        }

        String addressAsString = addressToCommaSeparatedString(address);
        Files.write(Paths.get(address.getId() + ".txt"), addressAsString.getBytes());

        return address;
    }

    @Override
    public void delete(long id) throws IOException {
        Files.delete(Paths.get(id + ".txt"));
    }


    private String addressToCommaSeparatedString(Address address) {
        return address.getId() + "," + address.getFirstName() + "," + address.getLastName() + "," + address.getPhoneNumber() + "," + address.getAddress() + "," + address.getEmail();
    }

    private Address commaSeparatedStringToAddress(String addressAsString) {
        String[] addressElements = addressAsString.split(",");
        Address address = new Address();
        address.setId(new Long(addressElements[0]));
        address.setFirstName(addressElements[1]);
        address.setLastName(addressElements[2]);
        address.setPhoneNumber(addressElements[3]);
        address.setAddress(addressElements[4]);
        address.setEmail(addressElements[5]);
        return address;
    }


}
