package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.cab.dao.BookingDAO;
import model.Booking;

@WebServlet("/viewBookings")
public class ViewBookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BookingDAO dao = new BookingDAO();
        
        List<Booking> list = dao.getAllBookings();
        
        request.setAttribute("bookings", list);
        
        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        
        rd.forward(request, response);
        
        

    }
}
