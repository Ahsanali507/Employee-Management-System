import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class UpdateEmployee extends HttpServlet {
  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	    response.setContentType("text/html");
    
	    // get PrintWriter object
	    PrintWriter out = response.getWriter();

        HttpSession session=request.getSession(false);
        if(session!=null){
            String sessionKey=(String) session.getAttribute("sessionKey");
            String uname=(String) session.getAttribute("username");
            if(sessionKey.equals("Admin")){
                String employeeid=request.getParameter("empid");
                String employeename=request.getParameter("empname");
                String employeeemail=request.getParameter("empemail");
                String employeepwd=request.getParameter("emppwd");
                String employeephone=request.getParameter("empphone");
        
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
                
                    Connection con=DriverManager.getConnection(url, "root", "root");
                
                    //PreparedStatement st = con.prepareStatement("UPDATE allEmployees SET empname='"+employeename+"', empemail='"+employeeemail+"', emppwd='"+employeepwd+"',empphone='"+employeephone+"' WHERE empid="+employeeid);
                    PreparedStatement st = con.prepareStatement("UPDATE allEmployees SET empname=?, empemail=?, emppwd=?, empphone=?,empid=? WHERE empid="+employeeid);
                    st.setString(1, employeename);
                    st.setString(2, employeeemail);
                    st.setString(3, employeepwd);
                    st.setString(4, employeephone);
                    st.setString(5,employeeid);
                    int rs = st.executeUpdate();
                    //Statement st = con.createStatement();
                    //int rs = st.executeUpdate("UPDATE allEmployees SET empname='"+employeename+"', empemail='"+employeeemail+"', emppwd='"+employeepwd+"',empphone='"+employeephone+"' WHERE empid="+employeeid);
                    if (rs > 0) {
                        out.println("<h3>Employee with this id is updated</h3>");
                    }
                    else{
                        out.println("<h3>Employee with this id could not be updated some problem occur try again</h3>");
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
