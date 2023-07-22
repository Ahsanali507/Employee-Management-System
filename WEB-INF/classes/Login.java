import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;


public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
    
        // get PrintWriter ojbect
        PrintWriter out = response.getWriter();

        // get values from login form
        String email=request.getParameter("lemail");
        String password=request.getParameter("lpassword");
        
        out.println("<html><head><title>Admin page</title><link rel='stylesheet' href='./css/style.css'></head>");
        out.println("<body style='background-color: #f2f2f2;'>");
        out.println("<ul>");
        out.println("<li><a href='index.html'>Home</a></li>");
        out.println("<li><a href='signUp.html'>Sign up</a></li>");
        out.println("<li><a href='login.html'>Login</a></li>");
        out.println("</ul>");


        try{
            // load driver
            Class.forName("com.mysql.jdbc.Driver");
    
            String url = "jdbc:mysql://localhost/employeesrecords";
    
            // connection with db
            Connection con=DriverManager.getConnection(url,"root","root");
    
            Statement st=con.createStatement();
            
            String query="Select * from employees where empEmail='"+email+"' ";
       
            ResultSet rs = st.executeQuery( query );
       
            if(rs.next()){
	            // record found for this user so get user_type to know this user is admin or user
            	String u_email = rs.getString("empEmail");
            	String u_password = rs.getString("empPassword");
            	String u_type = rs.getString("empType");
            	String u_name = rs.getString("empName");
                if(email.equals(u_email)&&password.equals(u_password)){
                    HttpSession session;
                    if(u_type.equals("Admin")){
                        session = request.getSession(true);
                        response.sendRedirect("AdminHomePage");
                    }
                    else{
                        session=request.getSession(true);
                        // session.setAttribute("sessionKey",u_type);
                        // session.setAttribute("username",u_name);
                        response.sendRedirect("UserHomePage");
                    }
                    session.setAttribute("sessionKey",u_type);
                    session.setAttribute("username",u_name);
                    // Cookie c1=new Cookie(u_type,username);
                    // c.setMaxAge(2*24*60*60);
                    // res.addCookie(c1);
                }
                else{
                out.println("<h3>Invalid email or password</h3>");
                }
    
	         }
            else{
            	// no record found for this user means invalid user
                out.println("<h3>Invalid email or password</h3>");
            }
            out.println("</body></html>");
            st.close();
            con.close();
        }catch(Exception e){
          out.println(e);
        }
    }
}
