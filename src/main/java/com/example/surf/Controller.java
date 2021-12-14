package com.example.surf;

import com.example.surf.DTOs.BookingInformation;
import com.example.surf.DTOs.Styles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Controller {
    @Autowired
    private Service surfService;

    @GetMapping("api/getstyles")
    public List<Styles> getStyles() {
        return surfService.getStyles();
    }

    @PostMapping("api/bookingsingle")
    public void bookSingleClient(@RequestBody BookingInformation bookingInformation) {
        surfService.bookSingleClient(bookingInformation);
    }

    @GetMapping("api/getallclients")
    public List<BookingInformation> getAllClients() {
        return surfService.getAllClients();
    }

    @DeleteMapping("api/deleteclient/{id}")
    public int deleteClient(@PathVariable("id") int booking_id) {
        return surfService.deleteClient(booking_id);
    }

    @PutMapping("api/editclient/{id}")
    public BookingInformation(@PathVariable("id") int booking_id, @RequestBody BookingInformation client) {
        return surfService.editClient(booking_id, client);
    }

}
