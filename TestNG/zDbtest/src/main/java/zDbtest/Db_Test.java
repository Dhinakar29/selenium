package zDbtest;

import java.sql.SQLException;
import zDbtest.DataBase;
import zDbtest.Suport;

public class Db_Test  { 
	
	 public static void main(String args[]) throws SQLException{
		 //creat object to your database connecter
		 DataBase calldb=new DataBase();
		
		//this line is used to write data in the data base in 3 column 
		calldb.connec(9,"ball", 700);
	
		System.out.println(calldb.stats());
	
	      }
}
