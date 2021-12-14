package com.example.surf;

import com.example.surf.DTOs.BookingInformation;
import com.example.surf.DTOs.CreateUserRequest;
import com.example.surf.DTOs.LoginUserRequest;
import com.example.surf.DTOs.Styles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Controller {
    @Autowired
    private Service surfService;

    @GetMapping("api/public/getstyles")
    public List<Styles> getStyles() {
        return surfService.getStyles();
    }

    @PostMapping("api/public/bookingsingle")
    public void bookSingleClient(@RequestBody BookingInformation bookingInformation) {
        surfService.bookSingleClient(bookingInformation);
    }

    @GetMapping("api/getallclients")
    public List<BookingInformation> getAllClients(){
        return surfService.getAllClients();
    }

    @PostMapping("api/public/createadminuser")
    public void createAdminUser(@RequestBody CreateUserRequest request){
        String userName = request.getUserName();
        String password = request.getPassword();
        surfService.createAdminUser(userName, password);
    }
    @PostMapping("api/public/login")
    public String adminLogin(@RequestBody LoginUserRequest request){
        String userName = request.getUserName();
        String password = request.getPassword();
        return surfService.adminLogin(userName, password);
    }
    @DeleteMapping("api/deleteclient/{id}")
    public int deleteClient(@PathVariable("id") int booking_id) {
        return surfService.deleteClient(booking_id);
    }

    @PutMapping("api/editclient/{id}")
    public BookingInformation editClient(@PathVariable("id") int clientId, @RequestBody BookingInformation client) {
        return surfService.editClient(clientId, client);
    }
}
