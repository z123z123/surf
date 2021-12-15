package com.example.surf;

import com.example.surf.DTOs.BookingInformation;
import com.example.surf.DTOs.CreateUserRequest;
import com.example.surf.DTOs.Styles;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

    public void bookGroup(BookingInformation bookingInformation) {
        surfRepository.bookGroup(bookingInformation);
    }



    public List<BookingInformation> getAllClients() {
        return surfRepository.getAllClients();
    }

    public void createAdminUser(String userName, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        surfRepository.createAdminUser(userName, encodedPassword);
    }

    public String adminLogin(String userName, String password) {
        String encodedPassword = surfRepository.adminLogin(userName);
        if (passwordEncoder.matches(password, encodedPassword)) {
            JwtBuilder builder = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, "secret")
                    .claim("userName", userName);
            return builder.compact();
        } else {
            throw new ApplicationException("Wrong password");
        }
    }

    public int deleteClient(int booking_id) {
        return surfRepository.deleteClient(booking_id);
    }

    public BookingInformation editClient(int clientId, BookingInformation client) {
        return surfRepository.editClient(clientId, client);
    }

}
