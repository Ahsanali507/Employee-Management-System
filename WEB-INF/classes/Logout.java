import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;


public class Logout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
    
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession(false);
        session.removeAttribute("sessionKey");
        session.removeAttribute("username");
        session.invalidate();
        response.sendRedirect("login.html");
    }
}
