package com.cab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;
import model.Booking;
import com.cab.util.DBConnection;

public class BookingDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/cabdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Jahir14@";

    public void saveBooking(String name, String phone, String pickup, String drop) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            String sql = "INSERT INTO booking (name, phone, pickup, drop_location, status, booking_time) VALUES (?, ?, ?, ?, 'pending', NOW())";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, pickup);
            ps.setString(4, drop);

            ps.executeUpdate();
            conn.close();

            System.out.println("Succesfully Added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Booking> getAllBookings() {
        List<Booking> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM booking ORDER BY " +
                         "CASE " +
                         "WHEN status='pending' THEN 1 " +
                         "WHEN status='ACCEPTED' THEN 2 " +
                         "WHEN status='REJECTED' THEN 3 " +
                         "END, booking_time DESC";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Booking b = new Booking();
                b.setId(rs.getInt("id"));
                b.setPhone(rs.getString("phone"));
                b.setPickup(rs.getString("pickup"));
                b.setDropLocation(rs.getString("drop_location"));
                b.setStatus(rs.getString("status"));
                b.setBookingTime(rs.getTimestamp("booking_time"));

                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateBookingStatus(int id, String status) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE booking SET status=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

