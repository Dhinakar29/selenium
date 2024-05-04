package login_page_retailytix;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_page_functioncheck {
	  
		WebDriver driver;
		
		//browser setup testEnvironment
		@BeforeTest(description="Browser_SetUp_Testing")
		public void SetUp()
		{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

		@Test(priority=1,description="Retailytix login page")
		public void loginPage() {
			//url for Website
			driver.get("http://15.207.198.150:9000/app/auth/sign-in");
			String loginPage=driver.getTitle();
			//verify the Retailytix webpage is lunched or not
			Assert.assertTrue(loginPage.contains("Sign In | Retailytix"));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		//verify error message for email field
		@Test(priority=2)
		public void Email(){
			driver.findElement(By.id("mui-1")).sendKeys("itteam");
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			driver.findElement(By.xpath("//p[@id='mui-1-helper-text']")).isDisplayed();
			String emailWarning=driver.findElement(By.xpath("//p[@id='mui-1-helper-text']")).getText();
		    System.out.println("Email warning message is display = "+emailWarning);
		    
		}
		
		//verify the password warning message
		@Test(priority=3)
		public void password() {
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			driver.findElement(By.xpath("//p[@id='mui-2-helper-text']")).isDisplayed();
			String passWordWarining=driver.findElement(By.xpath("//p[@id='mui-2-helper-text']")).getText();
			System.out.println("password warining message is display = "+passWordWarining);
			
		}
		
		//verify the Remember me checkbox
		@Test(priority=4)
		public void rememberME() {
			driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/form/div/div[5]/label/span[1]/input")).click();
			driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/form/div/div[5]/label/span[1]/input")).isDisplayed();
			driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/form/div/div[5]/label/span[1]/input")).isEnabled();
			Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/form/div/div[5]/label/span[1]/input")).isSelected());
			System.out.println("Remember me check box is clicked");
		}
		
		//verify the forgot password button
		@Test(priority=5)
		public void forgotPassword() {
			//click the forgot password
			driver.findElement(By.linkText("Forgot password?")).click();
			//login page should redirected to forgot password page.
			driver.navigate().back();
			//for clicking back button in browser.
		}
		
		//verify the Sign Up page
		@Test(priority=6)
		public void signUpPage() {
			driver.findElement(By.linkText("Sign up")).click();
			driver.navigate().back();
		}
		
	    //verify the eye icon in password field
		@Test(priority=7)
		public void eyeIcon() throws InterruptedException {
			
			driver.findElement(By.id("mui-2")).sendKeys("Abc@123");
			driver.findElement(By.xpath("//button[@aria-label='toggle password visibility']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[@aria-label='toggle password visibility']")).click();
			
		}
		
}
