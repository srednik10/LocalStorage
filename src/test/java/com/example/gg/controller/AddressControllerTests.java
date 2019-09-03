package com.example.gg.controller;

import com.example.gg.model.Address;
import com.example.gg.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class AddressControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    @Test
    public void saveAddressTest() throws Exception {

        Address address = new Address();
        address.setFirstName("Jan");
        address.setLastName("Kowalski");
        address.setAddress("Kraków");
        address.setPhoneNumber("123456789");
        address.setEmail("test@test.test");

        Address savedAddress = new Address();
        savedAddress.setId(1L);
        savedAddress.setFirstName("Jan");
        savedAddress.setLastName("Kowalski");
        savedAddress.setAddress("Kraków");
        savedAddress.setPhoneNumber("123456789");
        savedAddress.setEmail("test@test.test");


        when(this.addressService.save(address)).thenReturn(savedAddress);

            mockMvc.perform(post("/")
                    .content("{\n" +
                    "\t\"firstName\": \"Jan\",\n" +
                    "\t\"lastName\": \"Kowalski\",\n" +
                    "\t\"address\": \"Kraków\",\n" +
                    "\t\"phoneNumber\": \"123456789\",\n" +
                    "\t\"email\": \"test@test.test\"\n" + "}")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.firstName", is("Jan")))
                    .andExpect(jsonPath("$.lastName", is("Kowalski")))
                    .andExpect(jsonPath("$.address", is("Kraków")))
                    .andExpect(jsonPath("$.phoneNumber", is("123456789")))
                    .andExpect(jsonPath("$.email", is("test@test.test")));


    }

    @Test
    public void getAddressTest() throws Exception {

        Address address = new Address();
        address.setId(1);
        address.setFirstName("Jan");
        address.setLastName("Kowalski");
        address.setAddress("Kraków");
        address.setPhoneNumber("123456789");
        address.setEmail("test@test.test");

        when(addressService.get(1)).thenReturn(address);

        mockMvc.perform(get("/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("Jan")))
                .andExpect(jsonPath("$.lastName", is("Kowalski")))
                .andExpect(jsonPath("$.address", is("Kraków")))
                .andExpect(jsonPath("$.phoneNumber", is("123456789")))
                .andExpect(jsonPath("$.email", is("test@test.test")));


    }

    @Test
    public void updateAddressTest() throws Exception {

        Address address = new Address();
        address.setId(1);
        address.setFirstName("Jan");
        address.setLastName("Kowalski");
        address.setAddress("Kraków");
        address.setPhoneNumber("123456789");
        address.setEmail("test@test.test");

        Address updatedAddress = new Address();
        updatedAddress.setId(1L);
        updatedAddress.setFirstName("Jan");
        updatedAddress.setLastName("Kowalski");
        updatedAddress.setAddress("Kraków");
        updatedAddress.setPhoneNumber("123456789");
        updatedAddress.setEmail("test@test.test");

        when(addressService.update(address)).thenReturn(updatedAddress);

        mockMvc.perform(put("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"firstName\": \"Jan\",\n" +
                        "\t\"lastName\": \"Kowalski\",\n" +
                        "\t\"address\": \"Kraków\",\n" +
                        "\t\"phoneNumber\": \"123456789\",\n" +
                        "\t\"email\": \"test@test.test\"\n" + "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("Jan")))
                .andExpect(jsonPath("$.lastName", is("Kowalski")))
                .andExpect(jsonPath("$.address", is("Kraków")))
                .andExpect(jsonPath("$.phoneNumber", is("123456789")))
                .andExpect(jsonPath("$.email", is("test@test.test")));


    }

    @Test
    public void deleteAddressTest() throws Exception {





        mockMvc.perform(delete("/1"))
                .andExpect(status().isOk());

    }





}
