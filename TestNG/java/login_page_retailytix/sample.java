package login_page_retailytix;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample {
	WebDriver driver;
	
	//browser setup testEnvironment
	@BeforeTest(description="Browser_SetUp_Testing")
	public void SetUp()
	{
	WebDriverManager.firefoxdriver().setup();
	 driver=new FirefoxDriver();
	//driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
}

	@Test(priority=1,description="Retailytix login page")
	public void loginPage() {
		//url for Website
		driver.get("https://test.vmeasure.cloud/customer/login");
		String loginPage=driver.getTitle();
		//verify the Retailytix webpage is lunched or not
		Assert.assertTrue(loginPage.contains("Sign In | Retailytix"));
	}
	

	@Test(priority=2)
	public void verifyLogin(String username, String password) {
		//Enter the user name and password
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[2]/div[2]/form/div[1]/input")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"passwordShowHide\"]")).sendKeys(password);
		//click the login button
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[2]/div[2]/form/button")).click();
	}
}
