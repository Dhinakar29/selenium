package zDbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	
	private String JdbcURL="jdbc:mysql://127.0.0.1:3306/test";
	private String Username="root";
	private  String password="";
	public boolean link=true;
	 Connection con = null;
	
	protected  boolean connec(int id ,String name , int cash) throws SQLException {
       
        //boolean link=true;

		 try {
	         System.out.println("Connecting to database..............."+JdbcURL);
	         con=DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	      }
	      catch(Exception e) {
	       //  e.printStackTrace();
	         link=false;
	      }
	if (link==true) {
	    // Setting the initial value of the auto-incremented column
	      Statement stmt = con.createStatement();
	      stmt.execute("alter table Name AUTO_INCREMENT = 1001");
	      
	      //Query to Insert values to the sales table
	      String insertQuery = "INSERT INTO Name (id,name,money) VALUES (?, ?, ?)";
	      //Creating a PreparedStatement object
	      PreparedStatement pstmt = con.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
	      pstmt.setInt(1,id);
	      pstmt.setString(2,name);
	      pstmt.setInt(3,cash);
	     // pstmt.setTime(4, new Time(1567315800000L);
	    // pstmt.setInt(5, 7000);
	   //   pstmt.setString(6, "Hyderabad");
	      pstmt.addBatch();
	      pstmt.executeBatch();
	     return link;
	}
	else {
		return link;
	}
	
	}
	
	public String stats() {
		if (link==true) {
		    	String output="it updated";
		    	return output;}
		    else {
		    	String output1="Check your connection";
		    	return output1;}
	}
	protected void getDataSql() throws SQLException {
		

	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from test"); 
	
	}
	}  

	




