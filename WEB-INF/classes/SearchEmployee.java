import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;


public class SearchEmployee extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
    
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession(false);
        if(session!=null){
            String sessionKey=(String) session.getAttribute("sessionKey");
            String uname=(String) session.getAttribute("username");
            if(sessionKey.equals("Admin")){
                String employeeid=request.getParameter("empid");

                out.println("<html><head><title>Search Book Page</title><link rel='stylesheet' href='./css/style.css'><link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'></head>");
                out.println("<body style='background-color: #f2f2f2;'>");
                out.println("<ul>");
                out.println("<li><a href='addEmployee.html'>Add Employee</a></li>");
                out.println("<li><a href='searchEmployee.html'>Search Employee</a></li>");
                out.println("<li><a href='deleteEmployee.html'>Delete Employee</a></li>");
                out.println("<li><a href='updateEmployee.html'>Update Employee</a></li>");
                out.println("<li><form action='ViewAllEmployees' method='get'><input type='submit' value='View All Employees' style='background:none;padding:16px 8px;margin:0;'></form></li>");
                out.println("<li><form action='Logout' method='get'><input type='submit' value='Logout' style='background:none;padding:16px 8px;margin:0;'></form></li>");
                out.println("</ul>");
        
        
                try{
                    // load driver
                    Class.forName("com.mysql.jdbc.Driver");
            
                    String url = "jdbc:mysql://localhost/employeesrecords";
            
                    Connection con=DriverManager.getConnection(url,"root","root");
            
                    Statement st=con.createStatement();
                    
                    String query="Select * from allEmployees where empid='"+employeeid+"' ";
            
                    ResultSet rs = st.executeQuery( query );
            
                    if(rs.next()){
	                    //out.println("<h3>Record found</h3>");
                    	String id = rs.getString("empid");
                        String name = rs.getString("empname");
                        String email = rs.getString("empemail");
                        String password = rs.getString("emppwd");
                        String phone = rs.getString("empphone");
                        out.println("<table class='table table-striped table-hover'><thead style='background-color: #04AA6D; color:white;'><tr><th>Employee Id</th><th>Employee Name</th><th>Employee Email</th><th>Employee Password</th><th>Employee Phone</th></tr></thead>");
                        out.println("<tbody><tr><td>"+id+"</td><td>"+name+"</td><td>"+email+"</td><td>"+password+"</td><td>"+phone+"</td></tr></tbody>");
                        out.println("</table>");
            
	                 }
                    else{
                    	out.println("<h3>Employee with this Id does not exist try again</h3>");
                        //response.sendRedirect("searchEmployee.html");
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
