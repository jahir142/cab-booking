<%@ page import="java.util.*, model.Booking" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="Stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Driver Dashboard</title>
<meta http-equiv="refresh" content="5">
</head>
<body style="text-align:center; font-family: Arial;">
   
    <h2>Driver Dashboard</h2>
    <p>Booking requests will be shown here.</p>

    <table border="1" align="center" cellpadding="10">
        <tr>
            <th>Phone</th>
            <th>Pickup</th>
            <th>Drop</th>
            <th>Status</th>
            <th>Booking Time</th>
            <th>Action</th>
        </tr>
        

<%
List<Booking> list = (List<Booking>) request.getAttribute("bookings");
if(list != null){
    for(Booking b : list){
%>
        <tr class="<%= "pending".equalsIgnoreCase(b.getStatus()) ? "pending-row" : "" %>">
            <td><%= b.getPhone() %></td>
            <td><%= b.getPickup() %></td>
            <td><%= b.getDropLocation() %></td>
            <td><%= b.getStatus() %></td>
            <td><%= b.getBookingTime() %></td>
            
             <td>
            <%
                if("pending".equalsIgnoreCase(b.getStatus())){
            %>
                <a href="<%= request.getContextPath() %>/updateStatus?id=<%= b.getId() %>&status=ACCEPTED">Accept</a> |
                <a href="<%= request.getContextPath() %>/updateStatus?id=<%= b.getId() %>&status=REJECTED">Reject</a>
            <%
                } else {
                	out.print("<span class='no-action'>No Action</span>");

                }
            %>
            </td>
        </tr>
<%
    }
} else {
%>
        <tr>
            <td colspan="6">No bookings found</td>
        </tr>
<%
}
%>

    </table>

</body>
</html>
