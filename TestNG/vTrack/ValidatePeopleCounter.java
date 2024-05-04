package vTrack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidatePeopleCounter   {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.firefoxdriver().setup();
	FirefoxDriver driver=new FirefoxDriver();
	//Actions action=new Actions(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	driver.get("http://15.207.198.150:8090/");
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("admin123");
	driver.findElement(By.id("loginbtn")).click();
	String windoHomeId=driver.getTitle();
	Thread.sleep(200);
	driver.findElement(By.linkText("Configurations")).click();
	String list1=driver.findElement(By.linkText("People Counter")).getText();
	String list2=driver.findElement(By.linkText("No Entry Zones")).getText();
	String list3=driver.findElement(By.linkText("Queue Watch")).getText();
	driver.findElement(By.linkText("People Counter")).click();
	String title1=driver.getTitle();
	if(windoHomeId.equals("vTrack - Dashboard"))
	{
	System.out.println("vTrack login successful");
	}
	else {
		System.out.println("login not successful");
	}
	System.out.println("Configurations dropdown list--");	
	System.out.println("1 -"+list1);
	System.out.println("2 -"+list2);
	System.out.println("3 -"+list3);
	if (title1.equals("vTrack - People Counter")) {
	System.out.println("People Counter option is clicked. Gate Configuration webpage is open successful");
	}
	else {
		System.out.println("People Counter is not clicked -Configuration webpage is not open");
	}
	driver.quit();
}
}
