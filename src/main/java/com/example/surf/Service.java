package com.example.surf;

import com.example.surf.DTOs.*;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private Repository surfRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Styles> getStyles() {
        return surfRepository.getStyles();
    }

    public void bookClient(BookingInformation bookingInformation) throws MessagingException {
        surfRepository.bookClient(bookingInformation);

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port","587");

        BookingInformation client = bookingInformation;

        String bookingText = "Thank you for choosing Fuerteventura surfschool. You booking details:\n" +
                "Booking id: " + client.getBookingId() + "\nName: " + client.getFirstName() + " " + client.getLastName() + "\n"
                + "Date: " + client.getDate() + "\nTime: " + client.getTime();

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("surfschoolproject","Surfschool123");
                    }
                });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("surfschoolproject@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(client.getEmail()));
        message.setSubject("Surf school booking confirmation ID: " + client.getBookingId());
        message.setText(bookingText);
        Transport.send(message);
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

    public void bookGroup(List<BookingInformation> bookingInformation) throws MessagingException {
        for (int i = 0; i <bookingInformation.size(); i++) {
            surfRepository.bookClient(bookingInformation.get(i));

            Properties prop = new Properties();
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port","587");

            BookingInformation client = bookingInformation.get(i);

            String bookingText = "Thank you for choosing Fuerteventura surfschool. You booking details:\n" +
                    "Booking id: " + client.getBookingId() + "\nName: " + client.getFirstName() + " " + client.getLastName() + "\n"
                    + "Date: " + client.getDate() + "\nTime: " + client.getTime();

            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator(){
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("surfschoolproject","Surfschool123");
                        }
                    });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("surfschoolproject@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(client.getEmail()));
            message.setSubject("Surf school booking confirmation ID: " + client.getBookingId());
            message.setText(bookingText);
            Transport.send(message);
        }

    }
}
