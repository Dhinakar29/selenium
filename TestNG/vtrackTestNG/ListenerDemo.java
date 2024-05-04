package vtrackTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(vtrackTestNG.TestNGListener.class)
public class ListenerDemo {

	//set driver object as global
	WebDriver driver;
	
	
	@Test
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@Test (priority=1)
	public void TestCase1() {
		driver.get("https://www.google.com/");
		String title1=driver.getTitle();
		System.out.println(title1);
		
	}
	//test case is failed for testing
	@Test(priority=2)
	public void tetsCase2() {
		driver.findElement(By.xpath(" ")).click();
	
	}
	
	//test case is skipped for testing
	@Test(priority=3,dependsOnMethods="tetsCase2")
	public void tetsCase3() {
		System.out.println("test case is skipped");
	}
	
	
	
	@Test(priority=4)
	public void quitBrowser() {
		driver.close();
	}
	
	
	
	
}
