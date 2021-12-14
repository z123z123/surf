package com.example.surf;

import com.example.surf.DTOs.BookingInformation;
import com.example.surf.DTOs.Styles;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private Repository surfRepository;

    public List<Styles> getStyles() {
        return surfRepository.getStyles();
    }

    public void bookSingleClient(BookingInformation bookingInformation) {
        surfRepository.bookSingleClient(bookingInformation);
    }

    public List<BookingInformation> getAllClients() {
        return surfRepository.getAllClients();
    }

    public int deleteClient(int booking_id) {
        return surfRepository.deleteClient(booking_id);
    }

    public BookingInformation editClient(int clientId, BookingInformation client) {
        return surfRepository.editClient(clientId, client);
    }


}
