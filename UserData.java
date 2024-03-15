package userDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserData extends HttpServlet {
	//@Override
protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String age=req.getParameter("age");
		String Dob=req.getParameter("Dob");
		resp.setContentType("text/html");
	     PrintWriter out=resp.getWriter();
	     
	     out.println("<h1>Data Inserted to database Successfully........</h1>");
	     try {
	    
	     Class.forName("com.mysql.jdbc.Driver");
	     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root","mysql");
//	     String Query="create table UserDataa(Id int AUTO_INCREMENT PRIMARY KEY, name varchar(20),email varchar(30),age int,Dob varchar(40))";
	     String Query="insert into UserDataa(name,email,age,Dob) values (?,?,?,?)";
	     PreparedStatement pst = con.prepareStatement(Query);
	     int rage = Integer.parseInt(age);
         pst.setString(1, name);
         pst.setString(2,email);
	     pst.setString(3, age);
	     pst.setString(4,Dob);
	     pst.execute();}
	     
	     catch(Exception e) {
	    	 System.out.println(e);
	     }
	   
		}	
}

