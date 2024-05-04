package vtrackTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInOut {
	//set driver as global
	WebDriver driver;
	
	//browser setup testEnvironment
		@BeforeTest(description="Browser_SetUp_Testing")
		public void SetUp(){
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
		
		//verify the login page
		@Test(description="Home_page_path_Setup")
		public void loginPage() {
			driver.get("http://15.207.198.150:8090/");
			String homeTitle=driver.getTitle();
			//check the title contains the correct name or not
			Assert.assertTrue(homeTitle.contains("vTrack - Login"));
			System.out.println("Login Page is verified");
		}
		
		//using user name and password to login
		@Test(priority=1,dependsOnMethods="loginPage",description="TestCase1")
		public void logIn() {
			//Enter the user name and password
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.id("password")).sendKeys("admin123");
			//click the login button
			driver.findElement(By.id("loginbtn")).click();
			System.out.println("login successful");
		}
			
		//verify the home page is open after login
			@Test(priority=2,dependsOnMethods="logIn",description="testCase2")
			public void homePage() {
				String homeTitle=driver.getTitle();
				Assert.assertTrue(homeTitle.contains("vTrack - Dashboard"));	
			}
			
			//logout the v_track
			@Test(priority=3,dependsOnMethods={"homePage","logIn"},description="TestCase3")
			public void logOut() {
				//to logout the V_track 
				driver.findElement(By.linkText("admin")).click();
				driver.findElement(By.className("dropdown-item")).click();
				driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/a")).click();
				String logInPage=driver.getTitle();
				Assert.assertTrue(logInPage.contains("vTrack - Login"));
				System.out.println("logOut successful");
			}
		
		//close the browser and driver
		@AfterTest
		public void closeBroser() {
			driver.quit();
		}
	
}
