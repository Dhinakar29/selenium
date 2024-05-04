package datauser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.bouncycastle.asn1.dvcs.Data;

public  class Loginuser {
	 FileReader reader;
	Properties data1; 
    	
	public void Loginuser()throws IOException {

		  reader=new FileReader("/home/radhakrishnan/eclipse-workspace/Retailytix/src/main/java/testing/dataProvider.properties");
	      data1=new Properties();
	     data1.load(reader);
	     data1.getProperty("");
	}

  

public static void main(String[] args)  {
data1.ge
}




}
