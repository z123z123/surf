package com.example.surf;

import com.example.surf.DTOs.BookingInformation;
import com.example.surf.DTOs.CreateUserRequest;
import com.example.surf.DTOs.Styles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private Repository surfRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<Styles> getStyles() {
        return surfRepository.getStyles();
    }

    public void bookSingleClient(BookingInformation bookingInformation) {
        surfRepository.bookSingleClient(bookingInformation);
    }

    public List<BookingInformation> getAllClients(){
        return surfRepository.getAllClients();
    }

    public void createAdminUser(String userName, String password){
        String encodedPassword = passwordEncoder.encode(password);
        surfRepository.createAdminUser(userName, encodedPassword);
    }

    public String adminLogin(String userName, String password){
        String encodedPassword = surfRepository.adminLogin(userName);
        if(passwordEncoder.matches(password, encodedPassword)){
            return "Logged in";
        } else {
            return "Wrong password";
        }
    }

}
