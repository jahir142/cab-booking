package com.cab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cab.dao.BookingDAO;

@WebServlet("/BookCabServlet")

public class BookCabServlet extends javax.servlet.http.HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String pickup = request.getParameter("pickup");
        String drop = request.getParameter("drop");

        
        System.out.println("Servlet Reached");
        
        BookingDAO dao=new BookingDAO();
        dao.saveBooking(name, phone, pickup, drop);
//        // For now just print in console
//        System.out.println("New Booking:");
//        System.out.println("Name: " + name);
//        System.out.println("Phone: " + phone);
//        System.out.println("Pickup: " + pickup);
//        System.out.println("Drop: " + drop);

        // Redirect to success page
        response.sendRedirect("success.jsp");
    }

}
