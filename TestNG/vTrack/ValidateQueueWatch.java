package vTrack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateQueueWatch {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.firefoxdriver().setup();
	FirefoxDriver driver=new FirefoxDriver();
	//Actions action=new Actions(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	driver.manage().window().maximize();
	driver.get("http://15.207.198.150:8090/");
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("admin123");
	driver.findElement(By.id("loginbtn")).click();
	Thread.sleep(200);
	driver.findElement(By.linkText("Configurations")).click();
	driver.findElement(By.partialLinkText("Queue Watch")).click();
	String title=driver.getTitle();
	//System.out.println(title);
	if (title.equals("vTrack - Queue Watch")) {
		System.out.println("Queue Watch option is clicked. Queue Configuration webpage is open successful");
		}
		else {
			System.out.println("Queue Watch - Configuration webpage is not open ");
		}
		driver.quit();
}
}
