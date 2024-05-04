package vtrackTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SideBarToggle {

WebDriver driver;
	
	//browser set for testing
		@Test(description="Browser_SetUp_Testing")
		public void SetUp(){
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}

		//verify the login page
				@Test(priority=1,dependsOnMethods="SetUp",description="Home_page_path_Setup")
				public void loginPage() {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					driver.manage().window().maximize();
					driver.get("http://15.207.198.150:8090/");
					String homeTitle=driver.getTitle();
					Assert.assertTrue(homeTitle.contains("vTrack - Login"));
					
					//Enter userName and password to login
						driver.findElement(By.id("username")).sendKeys("admin");
						driver.findElement(By.id("password")).sendKeys("admin123");
						driver.findElement(By.id("loginbtn")).click();
						String dashBoadTitle1=driver.getTitle();
						Assert.assertTrue(dashBoadTitle1.contains("vTrack - Dashboard"));	
						System.out.println("login successful");
						
				}
				
//verify the v-track log on the left corner of the web page	
@Test(priority=2,dependsOnMethods="loginPage",description="validate the v_track logo")
public void VerifyLogo() {
	boolean Logo= driver.findElement(By.id("vTrack_logo")).isDisplayed();
	Assert.assertTrue(Logo);
	System.out.println("v-track log is visible");
}

// check the toggle button action to reduce the width of the side menu
@Test(priority=3,description="verify the Toggle button, shot logo visible and width is reduced  ")
public void toggleButton() {
	Actions action=new Actions(driver);
	WebElement toggle=driver.findElement(By.id("sidebarToggle"));
    action.click(toggle).perform();
    boolean shotLogo=driver.findElement(By.id("vTrack_logo_short")).isDisplayed();
    Assert.assertTrue(shotLogo);
    System.out.println("after sidebar Toggle button is clicked shot logo visible and width is reduced");
}

//to close browser
@Test(priority=4)
public void closeBroser() {
	driver.quit();
}


}


