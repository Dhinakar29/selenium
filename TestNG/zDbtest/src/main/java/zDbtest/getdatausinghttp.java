package zDbtest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class getdatausinghttp{
public void Inset(){

    String UserName="Edward";

   //String Company = company.getText().toString();
   // Shares = shares.getText().toString();
   // String Date = date.getText().toString();

    String Company = "AHCL";
    String Shares= "10";
    String Date= "23-04-2015";


try {
      // open a connection to the site
      URL url = new URL("http://10.0.2.2:8080//test/example.php");
      URLConnection con = url.openConnection();
      // activate the output
      con.setDoOutput(true);
      PrintStream ps = new PrintStream(con.getOutputStream());
      // send your parameters to your site
      ps.print("&Username=" + UserName);
      ps.print("&Company=" + Company);               
      ps.print("&Shares=" + Shares);
      ps.print("&Date=" + Date);

      // we have to get the input stream in order to actually send the request
      con.getInputStream();

      // close the print stream
      ps.close();
      } catch (MalformedURLException e1) {
          e1.printStackTrace();
      } catch (IOException e2) {
          e2.printStackTrace();
      }
}
}

//////////////////////////////////////////////////////
/*
String UserName="Edward";
String Company = "AHCL";
String Shares= "10";
String Date= "23-04-2015";

try {
  // open a connection to the site
  URL url = new URL("http://10.0.2.2:8080//test/example.php");
  URLConnection con = url.openConnection();
  // activate the output
  con.setDoOutput(true);
  PrintStream ps = new PrintStream(con.getOutputStream());
  // send your parameters to your site
  ps.print("&Username=" + Username);
  ps.print("&Company=" + Company);               
  ps.print("&Shares=" + Shares);
  ps.print("&Date=" + Date);


  // we have to get the input stream in order to actually send the request
  con.getInputStream();
  // print out to confirm
  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
  String line = null;
  while ((line = in.readLine()) != null) {
  System.out.println(line);
  // close the print stream
  ps.close();
  } catch (MalformedURLException e1) {
      e1.printStackTrace();
  } catch (IOException e2) {
      e2.printStackTrace();
  }

///////////





// creating new product in background thread
//new CreatePortfolio().execute();

////////////////////////////////////////////////////////////////

   // creating new product in background thread
   //new CreatePortfolio().execute();
}
}

<?php 
foreach ($_POST as $key => $value) {
    switch ($key) {
        case 'firstKey':
             $Username = $value;
            break;
        case 'secondKey':
            $Company = $value;
            break;
    case 'thirdKey':
              $Shares= $value;
            break;
        case 'fourthKey':
            $Date = $value; 
            
$file = fopen("data.txt","a"); 
$details=$Username."\t".$Company."\t".$Shares."\t".$Date;
fwrite($file,$details."\n");
fclose($file);
       break;
        default:
            break;
    }
}
?>
*/
