package vTrack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SidebarToggle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver=new FirefoxDriver();
		Actions action=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://15.207.198.150:8090/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin123");
		driver.findElement(By.id("loginbtn")).click();
		boolean Logo= driver.findElement(By.id("vTrack_logo")).isDisplayed();
		System.out.println("Logo visible "+Logo);
		WebElement toggle=driver.findElement(By.id("sidebarToggle"));
        action.click(toggle).perform();
       boolean shotLogo=driver.findElement(By.id("vTrack_logo_short")).isDisplayed();
       System.out.println("after sidebar Toggle button is clicked shot logo visible "+ shotLogo);
       Thread.sleep(500);
	   driver.quit();
	}
}
