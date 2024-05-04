package vtrackTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvaliedLogin1 {
	
	WebDriver driver;
	
	//This method will provide data to any test method that declares that its Data Provider
		//is named "test1"
		@DataProvider(name = "userNames_and_passWord")
		public Object[][] createData1() {
		 return new Object[][] {
		   { "Admin","admin"},
		   { "mukesh", "password123"},
		   { "admin","admin123"},
		 };
		}
		
		//browser setup testEnvironment
		@BeforeTest(description="Browser_SetUp_Testing")
		public void SetUp(){
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
		
		@Test(description="Home_page_path_Setup")
		public void loginPage() {
			driver.get("http://15.207.198.150:8090/");
			String homeTitle=driver.getTitle();
			//check the title contains the correct name or not
			Assert.assertTrue(homeTitle.contains("vTrack - Login"));
			System.out.println("Login Page is verified");
		}
		
		@Test(dataProvider = "userNames_and_passWord")
		public void verifyData1(String username, String password) {
			//Enter the user name and password
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.id("password")).sendKeys("admin123");
			//click the login button
			driver.findElement(By.id("loginbtn")).click();
			System.out.println("login successful");
		}
		
		
}
