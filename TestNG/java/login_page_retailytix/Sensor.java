package login_page_retailytix;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sensor {
WebDriver driver;
	
	@BeforeTest
	public void stUp() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
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
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
	@Test(priority=2,description="")
	public void TC_1() {
		
		//selsct the Sensor page 
		driver.findElement(By.linkText("Sensors")).click();
		String title =driver.findElement(By.xpath("//h4[text()='Sensors']")).getText();
		//System.out.println(title);
		Assert.assertTrue(title.contains("Sensors"));
	
	}
	
	@Test(priority=3,description="")
	public void TC_2()  {
		//for (int i = 0; i <100; i++) {
			
		driver.findElement(By.xpath("//button[text()='Used']")).click();
		
		driver.findElement(By.xpath("//button[text()='Un-Used']")).click();
	
		driver.findElement(By.xpath("//button[text()='All']")).click();

		driver.findElement(By.xpath("//button[text()='Un-Used']")).click();
	
		driver.findElement(By.xpath("//button[text()='Used']")).click();
		driver.findElement(By.xpath("//button[text()='All']")).click();

		Assert.assertTrue(true);
		
		//}
	}
	
	
	@Test(priority=4,description="")
	public void TC_3() {
		driver.findElement(By.xpath("//input[@placeholder='Search by sensor name']")).sendKeys("Sensor_36");
		Assert.assertTrue(driver.findElement(By.xpath("//tr/td/p[text()='Sensor_36']")).isDisplayed());
	}
	
	
//	@AfterTest
//	public void close() {
//		driver.quit();
//	}
}
