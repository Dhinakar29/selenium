package Sensor_page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sensors {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
	
	@Test(priority=1,description="")
	public void logIn() {
		
		//url for Website
		driver.get("http://15.207.198.150:9000/app/auth/sign-in");
		String loginPage=driver.getTitle();
		//verify the Retailytix webpage is lunched or not
		Assert.assertTrue(loginPage.contains("Sign In | Retailytix"));
		
		
		//Enter the user name and password
		driver.findElement(By.id("mui-1")).sendKeys("itteam@mail.com");
		driver.findElement(By.id("mui-2")).sendKeys("itteam001");
		//click the login button
		driver.findElement(By.xpath("//button[@value=\"grid\"]")).click();
		
		driver.findElement(By.xpath("")).click();
		
	}
	
}
