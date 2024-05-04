package zDbtest;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;

public class Test {


    public static void main(String[] args)  {
    	int c=89;
    	int b=1;
for (int x = 0; x < 9; x++) {
	for (int y = 0; y <9; y++) {
	  b=(11*x)+(100*y);
	 System.out.println(b);
	 if(c==b) {
		 System.out.println(x +"x and y"+y);
	 }
	}
}
    }
}

