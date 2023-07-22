import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class AdminHomePage extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        // get PrintWriter object
        PrintWriter out=response.getWriter();
 
        // httpsession if not null then do your work otherwise redirect to login.html page
        HttpSession session=request.getSession(false);
        if(session!=null){
            String sessionKey=(String) session.getAttribute("sessionKey");
            String uname=(String) session.getAttribute("username");
            if(sessionKey.equals("Admin")){
                out.println("<html><head><title>Admin home page</title><link rel='stylesheet' href='./css/style.css'></head>");
                out.println("<body style='background-color: #f2f2f2;'>");
                out.println("<ul>");
                out.println("<li><a href='addEmployee.html'>Add Employee</a></li>");
                out.println("<li><a href='searchEmployee.html'>Search Employee</a></li>");
                out.println("<li><a href='deleteEmployee.html'>Delete Employee</a></li>");
                out.println("<li><a href='updateEmployee.html'>Update Employee</a></li>");
                out.println("<li><form action='ViewAllEmployees' method='get'><input type='submit' value='View All Employees' style='background:none;padding:16px 8px;margin:0;'></form></li>");
                out.println("<li><form action='Logout' method='get'><input type='submit' value='Logout' style='background:none;padding:16px 8px;margin:0;'></form></li>");
                out.println("</ul>");
                out.println("<div class='homeheading'>");
                out.println("<h1>Wellcome Admin "+uname+" </h1>");
                out.println("</body>");
                out.println("</html>");
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