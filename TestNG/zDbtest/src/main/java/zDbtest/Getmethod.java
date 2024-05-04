package zDbtest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class Getmethod {
	String adress = "http://localhost/get_data.php";
	InputStream inputStream = null;
	String line = null, result = null, data[];

	private void get_data(){
	    try {
	        URL url = new URL(adress);
	        HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();
	        httpsURLConnection.setRequestMethod("GET");

	        inputStream = new BufferedInputStream(httpsURLConnection.getInputStream());

	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // read input stream into a string
	    try{
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	        StringBuilder stringBuilder = new StringBuilder();

	        while ((line = bufferedReader.readLine()) != null){
	            stringBuilder.append(line + "\n");
	        }

	        inputStream.close();
	        result = stringBuilder.toString();
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }

	    // Parse json data
	    try{
	        JSONArray jsonArray = new JSONArray(result);
	        JSONObject jsonObject = null;

	        data = new String[jsonArray.length()];
	        for (int i=0; i<jsonArray.length(); i++){
	            jsonObject = jsonArray.getJSONObject(i);
	            data[i] = jsonObject.getString("user_adress"); // column name
	        }
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	}
}
/*
<?php 
require "conn.php";

$user_name = $_POST["username"];

$query = mysqli_query($conn, "select * from android_data where username='$user_name'");

if ($query) {
    while ($row = mysqli_fetch_array($query)) {
        $flag[] = $row;
    }
    print(json_encode($flag));
}

$conn->close();
 ?> */
