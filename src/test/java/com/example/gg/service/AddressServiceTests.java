package com.example.gg.service;

import com.example.gg.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {

    @Autowired
    private AddressService addressService;

    @Test
    public void saveTest() throws IOException {

        Address address = new Address();
        address.setFirstName("Jan");
        address.setLastName("Kowalski");
        address.setAddress("Kraków");
        address.setPhoneNumber("123456789");
        address.setEmail("test@test.test");

        Address savedAddress = new Address();
        savedAddress.setId(1);
        savedAddress.setFirstName("Jan");
        savedAddress.setLastName("Kowalski");
        savedAddress.setAddress("Kraków");
        savedAddress.setPhoneNumber("123456789");
        savedAddress.setEmail("test@test.test");

        assertEquals(addressService.save(address),savedAddress);
    }

    @Test
    public void getTest() throws IOException {

        Address address = new Address();
        address.setFirstName("Jan");
        address.setLastName("Kowalski");
        address.setAddress("Kraków");
        address.setPhoneNumber("123456789");
        address.setEmail("test@test.test");

        Address resultAddress = new Address();
        resultAddress.setId(1);
        resultAddress.setFirstName("Jan");
        resultAddress.setLastName("Kowalski");
        resultAddress.setAddress("Kraków");
        resultAddress.setPhoneNumber("123456789");
        resultAddress.setEmail("test@test.test");


        addressService.save(address);

        assertEquals(addressService.get(1),resultAddress);

    }

    @Test
    public void updateTest() throws IOException {

        Address address = new Address();
        address.setFirstName("Jan");
        address.setLastName("Kowalski");
        address.setAddress("Kraków");
        address.setPhoneNumber("123456789");
        address.setEmail("test@test.test");

        Address updatedAddress = new Address();
        updatedAddress.setId(1);
        updatedAddress.setFirstName("Janina");
        updatedAddress.setLastName("Kowalska");
        updatedAddress.setAddress("Kraków");
        updatedAddress.setPhoneNumber("123456789");
        updatedAddress.setEmail("test@test.test");

        addressService.save(address);

        assertEquals(addressService.update(updatedAddress), updatedAddress);

    }

    @Test
    public void deleteTest() throws IOException {

        Address address = new Address();
        address.setFirstName("Jan");
        address.setLastName("Kowalski");
        address.setAddress("Kraków");
        address.setPhoneNumber("123456789");
        address.setEmail("test@test.test");

        addressService.save(address);

        addressService.delete(1);
    }



}
