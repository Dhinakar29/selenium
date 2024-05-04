package vTrack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvaidLogin {
public static void main(String[] args) {
	WebDriverManager.firefoxdriver().setup();
	FirefoxDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	driver.manage().window().maximize();
	driver.get("http://15.207.198.150:8090/");
	String Dashboard=driver.getTitle();
	String[] userName= {"administrator","admin","administrator","admin"};        
	String[] passWord= {"admin123","admin","admin","admin123"};
	for (int i = 0; i <4;i++) {
		System.out.print(userName[i]);
		System.out.println(" "+passWord[i]);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userName[i]);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(passWord[i]);
		driver.findElement(By.id("loginbtn")).click();
		
	String LogIn=driver.getTitle();
    if (Dashboard.equals(LogIn)) {
   	 System.out.println("login not successful");
    }
    else {
   	 System.out.println("login is successful");
   	 break;
    }
    
	}
}
}
