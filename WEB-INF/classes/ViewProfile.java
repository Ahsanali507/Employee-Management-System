import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;


public class ViewProfile extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
    
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession(false);
        if(session!=null){
            String sessionKey=(String) session.getAttribute("sessionKey");
            String uname=(String) session.getAttribute("username");
            if(sessionKey.equals("User")){

                out.println("<html><head><title>View profile page</title><link rel='stylesheet' href='./css/viewprofile.css'><link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'></head>");
                out.println("<body style='background-color: #f2f2f2;'>");
                out.println("<ul>");
                out.println("<li><form action='ViewProfile' method='get'><input type='submit' value='View Profile'></form></li>");
                out.println("<li><form action='Logout' method='get'><input type='submit' value='Logout'></form></li>");
                out.println("</ul>");
        
        
                try{
                    // load driver
                    Class.forName("com.mysql.jdbc.Driver");
            
                    String url = "jdbc:mysql://localhost/employeesrecords";
            
                    Connection con=DriverManager.getConnection(url,"root","root");
            
                    Statement st=con.createStatement();
                    
                    String query="Select * from employees where empName='"+uname+"' ";
            
                    ResultSet rs = st.executeQuery( query );
            
                    if(rs.next()){
	                    //out.println("<h3>Record found</h3>");
                    	String id = rs.getString("empId");
                        String name = rs.getString("empName");
                        String email = rs.getString("empEmail");
                        String password = rs.getString("empPassword");
                        String address = rs.getString("empAddress");
                        out.println("<section class='vh-10' style='background-color: #f4f5f7;text-align:justify'><div class='container py-5 h-70'><div class='row d-flex justify-content-center align-items-center h-30'><div class='col col-lg-6 mb-4 mb-lg-0'><div class='card mb-3' style='border-radius: .5rem;'><div class='row g-0'><div class='col-md-12'><div class='card-body p-4'>");
                        out.println("<h3 style='text-align:center'>User Profile</h3>");
                        out.println("<hr class='mt-0 mb-4'>");
                        out.println("<div class='row pt-1'><div class='col-6 mb-3'><h6>Id</h6><p class='text-muted'>"+id+"</p></div><div class='col-6 mb-3'><h6>Name</h6><p class='text-muted'>"+name+"</p></div></div>");
                        out.println("<hr class='mt-0 mb-4'>");
                        out.println("<div class='row pt-1'><div class='col-6 mb-3'><h6>Email</h6><p class='text-muted'>"+email+"</p></div><div class='col-6 mb-3'><h6>Password</h6><p class='text-muted'>"+password+"</p></div></div>");
                        out.println("<hr class='mt-0 mb-4'>");
                        out.println("<div class='row pt-1'><div class='col-6 mb-3'><h6>Address</h6><p class='text-muted'>"+address+"</p></div>");
                        out.println("</div></div></div></div></div></div></div></section>");


                        // out.println("<table class='table table-striped table-hover'><thead style='background-color: #04AA6D; color:white;'><tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Address</th></tr></thead>");
                        // out.println("<tbody><tr><td>"+id+"</td><td>"+name+"</td><td>"+email+"</td><td>"+password+"</td><td>"+address+"</td></tr></tbody>");
                        // out.println("</table>");
            
	                 }
                    out.println("</body></html>");
                    st.close();
                    con.close();
                }catch(Exception e){
                  out.println(e);
                }
            }   
            else{
                response.sendRedirect("login.html");
            } 
        }
        else{
            response.sendRedirect("login.html");
        }
    }
}
