package login_page_retailytix;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Loadtestcase extends Thread  {
	WebDriver driver;
    int counter= 0;
    public static void main(String args[]) throws Throwable {      
    	Loadtestcase t[] = new Loadtestcase[5];
        for (int j=0; j<=5;j++) {
            t[j] = new Loadtestcase();
            t[j].start();       
        }          
    }
    public void run() {
        try {
            System.out.println("thread " + Thread.currentThread().getName()+" step "+counter++);
        } 
        catch (Throwable t) { 
            t.printStackTrace();
        }
        
       // System.out.println("test");
        WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("http://15.207.198.150:9000/app/auth/sign-in");
		String loginPage=driver.getTitle();
		//verify the Retailytix webpage is lunched or not
		//Assert.assertTrue(loginPage.contains("Sign In | Retailytix"));
		
		driver.findElement(By.id("mui-1")).sendKeys("itteam@mail.com");
		driver.findElement(By.id("mui-2")).sendKeys("itteam001");
		//click the login button
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Dashboard']")));
		//wait.until(ExpectedConditions.titleContains("Dashboard | Retailytix")(getTitle());
		
		String title=driver.getTitle();
			if(title.equals("Dashboard | Retailytix")){
		
		System.out.println("pass");
		driver.close();}
		
			else {
				System.out.println("fail");
				driver.close();
			}
		
			driver.close();
			
    }
}

