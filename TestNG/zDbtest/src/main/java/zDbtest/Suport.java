package zDbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Suport  {


    private static String JdbcURL="jdbc:mysql://127.0.0.1:3306/test";
	private static String Username="root";
	private static String password="";
	public boolean linkStatus=true;
	public boolean writeSatus=true;
	 Connection con = null;
	// Statement stmt;
	 
	 
	 
	protected boolean dataBaselinker()throws SQLException {
	
		
			 try {
		        // System.out.println("Connecting to database..............."+JdbcURL);
		         con=DriverManager.getConnection(JdbcURL, Username, password);
		         //System.out.println("Connection is successful!!!!!!");
		         linkStatus=true;
		         return linkStatus;
		      }
		      catch(Exception e) {
		       // e.printStackTrace();//in case of testing use to debug this line
		         linkStatus=false;
		         return linkStatus;
	}
	}
	
	protected boolean writeDataBase(int id ,String name, int cash) {
		try {
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
	      writeSatus =true;
	      return writeSatus;
		}
		catch(Exception e) {
			writeSatus=false;
			return writeSatus;
			
		}
	}
	
	//////////////////////////////////////////////////////
	//get data from the data base table
//	protected boolean getDatadb() {
//		 String sql = "SELECT first_name, last_name, email " +
//                 "FROM candidates";
//		
//	}
	/////////////////////////////////////////////////////////
	
	//get data base link information
	public String linkDataStatus() {
		String meage1="successfully connected to the data base";
		String meage2="check your connection data base not connected";
		if(linkStatus==true) {
		return meage1;}
		else {
			return meage2;
		}
	}
	
	//get write information
	public String writeDataStatus() {
		String meage1="give data is upload successfully";
		String meage2="Can't able to upload your data";
		if(linkStatus==true) {
		return meage1;}
		else {
			return meage2;
	
		}
	}
	
	
}
