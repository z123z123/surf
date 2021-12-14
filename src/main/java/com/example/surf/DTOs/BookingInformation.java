package com.example.surf.DTOs;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class BookingInformation {

    private int bookingId;
    private Date date;
    private Time time;
    private int surfStyle;
    private String firstName;
    private String lastName;
    private String level;
    private boolean wetsuit;
    private String gender;
    private int weight;
    private int height;
    private String email;
    private int clientId;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getSurfStyle() {
        return surfStyle;
    }

    public void setSurfStyle(int surfStyle) {
        this.surfStyle = surfStyle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isWetsuit() {
        return wetsuit;
    }

    public void setWetsuit(boolean wetsuit) {
        this.wetsuit = wetsuit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
