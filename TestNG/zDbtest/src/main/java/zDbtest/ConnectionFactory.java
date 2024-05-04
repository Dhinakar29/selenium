package zDbtest;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.w3c.dom.html.HTMLFieldSetElement;
 

public class ConnectionFactory {

	private double API_VERSION =0;
	private String API="";
	
	private String METHOD ="POST";
	private String TYPE = "application/x-www-form-urlencoad";
	private String USER_AGENT ="Mozilla/5.0";
	private String data ="";
	
	private URL connection;
	private HttpURLConnection finalConnecton;
	
	private HashMap<String , String> fields =new HashMap<String ,String>();
	
	public ConnectionFactory(String[] endpoint,String url,Double version) {
		this.API_VERSION =version;
		this.API =url;
	    fields.put("version", String.valueOf(version));
	    for(int i =0; i<endpoint.length;i++) {
	    	String[] points = endpoint[i].split(";");
	    	for(int f=0; f< points.length;f++) {
	    		fields.put(points[f].split(":")[0], points[f].split(":")[1]);
	    		
	    	}
	    }
	    
	}
	
	public String buildConnection() {
		StringBuilder content =new StringBuilder();
		if(!this.getEndpoints().equalsIgnoreCase("") && !this.getEndpoints().isEmpty()) {
			String vars="";
			String vals="";
			try {
				for(Map.Entry<String, String> entry : fields.entrySet()){
			}
				vars = entry.getKey();
				vals = entry.getValue();
				data += ("&"+vars+"="+vals);
				
			}
			if(data.startsWith("&",""));
			
		}
				
	}
	
	 public String getApiversion() {
		 return String.valueOf(API_VERSION);
	 }
	
	public String getEndpoints() {
		return fields.toString();
	}
	public String getEndpointValue(String key) {
		return fields.get(key);
	}
}
