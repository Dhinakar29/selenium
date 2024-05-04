package login_page_retailytix;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	
    
	WebDriver driver;
	
	//This method will provide data to any test method that declare this  Data Provider method
			@DataProvider(name = "userNames_and_passWord")
			public Object[][] createData1() {
			 return new Object[][] {
			   { "itteam@mail.com","itteam001"},
			   {"admin","password"},
			 };
			}
	
	//browser setup testEnvironment
			@BeforeTest(description="Browser_SetUp_Testing")
			public void SetUp()
			{
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		}
			
			@Test(description="Retailytix login page")
			public void loginPage() {
				//url for Website
				driver.get("http://15.207.198.150:9000/app/auth/sign-in");
				String loginPage=driver.getTitle();
				//verify the Retailytix webpage is lunched or not
				Assert.assertTrue(loginPage.contains("Sign In | Retailytix"));
				
			}
			
			@Test(priority=1,dataProvider = "userNames_and_passWord")
			public void verifyLogin(String username, String password) {
				//Enter the user name and password
				driver.findElement(By.id("mui-1")).sendKeys(username);
				driver.findElement(By.id("mui-2")).sendKeys(password);
				//click the login button
				driver.findElement(By.xpath("//button[text()='Login']")).click();
			
				
				  String title=driver.getTitle();
				  
				if(title.equals("Dashboard | Retailytix")) 
				{
				Assert.assertTrue(title.contains("Dashboard | Retailytix"));
				System.out.println("login successful");
				}
				
				else {

					driver.findElement(By.id("username")).clear();
					driver.findElement(By.id("password")).clear();
					Assert.assertFalse(true);
					}
			}
			
			@Test(priority=2,description="logOut")
			public void logOut() {
				driver.findElement(By.xpath("//button[2]")).click();
				driver.findElement(By.xpath("//ul//li[text()='Sign out']")).click();
			}
			
			@AfterTest
			public void QuitBrowser() {
			//	driver.close();
			}
			
			}
	
		
