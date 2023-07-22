import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class UserHomePage extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        // get PrintWriter object
        PrintWriter out=response.getWriter();

        // httpsession if not null then do your work else redirect to login.html page
        HttpSession session=request.getSession(false);
        if(session!=null){
            String sessionKey=(String) session.getAttribute("sessionKey");
            String uname=(String) session.getAttribute("username");
            if(sessionKey.equals("User")){
                out.println("<html><head><title>User home page</title><link rel='stylesheet' href='./css/style.css'></head>");
                out.println("<body style='background-color: #f2f2f2;'>");
                out.println("<ul>");
                out.println("<li><form action='ViewProfile' method='get'><input type='submit' value='View Profile'></form></li>");
                out.println("<li><form action='Logout' method='get'><input type='submit' value='Logout' style='margin-left:14px;'></form></li>");
                out.println("</ul>");
                out.println("<div class='homeheading'>");
                out.println("<h1>Wellcome "+uname+" </h1>");
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