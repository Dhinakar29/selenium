package login_page_retailytix;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Store {

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
	
	//verify to open the Store page
	@Test(priority=2,description="")
	public void TC_S_01() {
		
		 driver.findElement(By.xpath("//div//span[text()='Stores']")).click(); String
		 dashBoard=driver.getTitle();
		 
		//Assert.assertTrue(dashBoard.contains(""));
		
	}
	@Test(priority=3,description="")
	public void TC_S_02() throws Exception {
		//this line is used to click the Gride button
		Thread.sleep(200);
		boolean grid=driver.findElement(By.xpath("//table")).isDisplayed();
		driver.findElement(By.xpath("//button[text()='GridView']")).click();
		try {
		driver.findElement(By.xpath("//table"));
		}
		catch(Exception e) {
			//System.out.println(e);
		System.out.println("grid view is clicked");
		}
		Assert.assertTrue(grid);
	}
	
		@Test(priority=4,description="")
		public void TC_S_03() {
			
		        driver.findElement(By.xpath("//button[text()='ListView']")).click();
		        
		        driver.findElement(By.xpath("//tbody//tr[1]//button[@aria-label='expand row']")).click();
		        
		        int l=1;
		        for (int i = 1; i <10; i++) {
					l=l+2;
				
		        driver.findElement(By.xpath("//tbody//tr["+l+"]//button[@aria-label='expand row']")).click();
		        }
		}
		
		@Test(priority=5,description="")
		public void TC_04() throws InterruptedException {
			driver.findElement(By.xpath("//button[@aria-label='Go to next page']")).click();
			Thread.sleep(1000);
			
			 driver.findElement(By.xpath("//tbody//tr[1]//button[@aria-label='expand row']")).click();
		        
		        int l=1;
		        for (int i = 1; i <10; i++) {
					l=l+2;
				
		        driver.findElement(By.xpath("//tbody//tr["+l+"]//button[@aria-label='expand row']")).click();
		       }
	      }
		@Test(priority=6)
		public void exit() {
			driver.quit();
		}
 
	  }
		
	    
	



