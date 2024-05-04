package datauser;

import java.io.PrintStream;

import testing.Data;

public class login {
	
	static Data data;
	static Data data=new Data();
	
	public static void login1() {
		
		 
		 System.out.println(data.userName);
			System.out.println(data.password);
	}
	
	public static void login2() {
		//Data data=new Data();
		 
		 System.out.println(data.userName);
			System.out.println(data.password);
	}
	
	public static void main(String[] args) {
		
		//Data data=new Data();
		login1();
	
		//System.out.println(data.userName);
		//System.out.println(data.password);
		
	
	}
	
}
