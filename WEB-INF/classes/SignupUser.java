import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class SignupUser extends HttpServlet {
  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	    response.setContentType("text/html");
    
	    // get PrintWriter object
	    PrintWriter out = response.getWriter();

        // get values from signup form here
        String name=request.getParameter("sname");
        String email=request.getParameter("semail");
        String password=request.getParameter("spassword");
        String address=request.getParameter("saddress");

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
            Connection con=DriverManager.getConnection(url, "root", "root");

//             String myQuery = "select Id,Name,Age from JavaPreparedStatement";
//       try {
//          con = DriverManager.getConnection(JdbcURL, Username, password);
//          pstmt = con.prepareStatement(myQuery);
//          rst = pstmt.executeQuery();
//          System.out.println("Id\t\tName\t\tAge
// ");
//          while(rst.next()) {
//             System.out.print(rst.getInt(1));
//             System.out.print("\t\t"+rst.getString(2));
//             System.out.print("\t\t"+rst.getInt(3));
//             System.out.println();
//          }
        
            Statement st=con.createStatement();
        
            // query to search email from db
            String firstQuery="Select * from employees where empEmail='"+email+"' ";
        
            ResultSet rs = st.executeQuery( firstQuery );
        
            if(rs.next()){
                //email found from db means user with this email already exists
            	String u_email = rs.getString("empEmail");
                out.println("<h3>User with this account already exists please try another account</h3>");
	        }
            else{
                // no email found from db means this is new user
                // check if all fields are not empty then create this account
                if(name!=""&&email!=""&&password!=""&&address!=""){
                    String secondQuery = "INSERT INTO employees(empName,empEmail,empPassword,empAddress)VALUES('"+ name + "','"+ email + "','"+ password + "','" + address+ "') ";
                    int rws = st.executeUpdate( secondQuery );  // (executeUpdate)how many rows effected
                    if(rws==1){
                        out.println("<h3>Account created successfully</h3>");
                    }
	                else{	
                        out.println("<h3>Account could not successfully</h3>"); 		
                    }
                }
                else{
                    out.println("<h3>Please fill all the fields properly</h3>");
                }
            }
            out.println("</body></html>");
            st.close();
            con.close();
        }catch(Exception e){
            out.println(e);
        }
    }
}
