package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.cab.dao.BookingDAO;

@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get booking id and status from URL
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

        // 2. Call DAO method to update status
        BookingDAO dao = new BookingDAO();
        dao.updateBookingStatus(id, status);

        // 3. Redirect back to dashboard (refresh list)
        response.sendRedirect("viewBookings");
    }
}
