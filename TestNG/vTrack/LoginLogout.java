package vTrack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginLogout {
	
    public static void main(String[] args) {
		
	
	WebDriverManager.firefoxdriver().setup();
	FirefoxDriver driver=new FirefoxDriver();
	//Actions action=new Actions(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	driver.manage().window().maximize();
	
	
	driver.get("http://15.207.198.150:8090/");
	
	
	String LogIn=driver.getTitle();
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("admin123");
	driver.findElement(By.id("loginbtn")).click();
	driver.findElement(By.linkText("admin")).click();
	
	
    
	
	
     driver.quit();
}
}
