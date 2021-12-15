package com.example.surf;

import com.example.surf.DTOs.*;
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

    public void bookClient(BookingInformation bookingInformation) {
        surfRepository.bookClient(bookingInformation);
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

    public List<AvailableTime> getTimes() {
        return surfRepository.getTimes();
    }

    public void updateTimes(UpdateTime updateTime) {
        int id = updateTime.getId();
        int newCount = updateTime.getNewCount();
        surfRepository.updateTimes(id, newCount);
    }

    public void bookGroup(List<BookingInformation> bookingInformation) {
        for (int i = 0; i <bookingInformation.size(); i++) {
            surfRepository.bookClient(bookingInformation.get(i));
        }

    }

}
