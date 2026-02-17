package model;

import java.sql.Timestamp;

public class Booking {

    private String phone;
    private String pickup;
    private String dropLocation;
    private String status;
    private Timestamp bookingTime;
    private int id;
    // Default Constructor
    public Booking() {
    }

    // Parameterized Constructor
    public Booking(String phone, String pickup, String dropLocation, String status, Timestamp bookingTime) {
        this.phone = phone;
        this.pickup = pickup;
        this.dropLocation = dropLocation;
        this.status = status;
        this.bookingTime = bookingTime;
    }

    // Getters and Setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Timestamp bookingTime) {
        this.bookingTime = bookingTime;
    }
}

