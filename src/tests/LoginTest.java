package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
import utilities.Xls_Reader;

public class LoginTest {
	WebDriver driver;
	
	LoginPage lp=new LoginPage();
   DataFile df=new DataFile();
	
	
	
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\JAY SHRI KRISHNA\\Desktop\\Testing Class\\Projectfolder\\SeleniumJars\\geckodriver.exe");
		//driver=new FirefoxDriver(); 
		lp.openBrowser();
		
		//driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=R1koXnSWKfI&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiUjFrb1huU1dLZkkiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYzOTMyODI3MCwiaWF0IjoxNjM5MzI3MDcwLCJqdGkiOiI3NjkwMmJkMy0xZjg1LTQzMTQtYjY4OS1iZWNiN2IyMjJmMWYiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.BH1EJTYvWlE2nrU0Ncv_AzbOm5DureJom4cn5xd8yyyAtyUkUHwuNsrvYNJU5ZUQ1_fV11vXnM0ED7ToFXetTOMylQxcF3a89V-AwX-fDSIfoch3Ahko-fNtZQm5DPqeCo41AL2OXv6ZLPztespSYHq7n50wXVxvTU-ONVUrenONiCbXIoXrlXt9vVbiv9WpoUVsoQdx5QgmfZs8Xi4IFyi4UYKYKUDw7Cd-HUnQcnhz3M9EW0sXLraaQUVMXj3OjXIku7kLYMMfuaDizMazZmQi83YyJv_1MzwFRuSwUfxY_ZdZ_NPhORqo9_trgZk5lKgjY1W4rmam2s2vdRIdxw&preferred_environment=");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		lp.openLoginPage();
	}
	
	@AfterMethod
	public void afterMethod()  {
		//driver.close();
		
		lp.closeBrowser();
	}
  @Test(priority=1)
  public void loginWithWrongEmailPasswordTest() throws InterruptedException {
	  
	//  driver.findElement(By.id("usernameInput-input")).sendKeys("asdasdasdasdasd");
	//	driver.findElement(By.id("password-input")).sendKeys("asdasdasdasdasd");
		//driver.findElement(By.id("signIn")).click();
		//Thread.sleep(4000);
	  
	  lp.login(df.wrongEmail,df.wrongPassword);
		
		
		Assert.assertEquals(df.globalErr,lp.readGlobalError() );
		
  }
  @Test(priority=2)
  public void loginWithEmptyEmail() throws InterruptedException {
	 // driver.findElement(By.id("password-input")).sendKeys("asdasdasdasdasd");
	 // driver.findElement(By.id("signIn")).click();
	 // Thread.sleep(3000);
	  
	  lp.login("",df.wrongPassword);
	 
	  
	  Assert.assertEquals(df.emptyEmailErr,lp.readError());
	  
  }
  @Test(priority=3)
  public void loginWithEmptyPassword() throws InterruptedException {
	 // driver.findElement(By.id("usernameInput-input")).sendKeys("asdasdasdasdasd");
	 // driver.findElement(By.id("signIn")).click();
	 // Thread.sleep(3000);
	  lp.login(df.wrongEmail,"");
	 
	  
	  Assert.assertEquals(df.emptyPasswordErr,lp.readError());
	  
  }
  @Test(priority=4)
  public void loginWithSpecialCharacters() throws InterruptedException {
	  // driver.findElement(By.id("usernameInput-input")).sendKeys("akash@#$%");
		//driver.findElement(By.id("password-input")).sendKeys("asdasdasdasdasd");
		//driver.findElement(By.id("signIn")).click();
		//Thread.sleep(4000);
	  
	  lp.login(df.emailWithSpecialChar,df.wrongPassword);
		Assert.assertEquals(df.emailWithSpecCharErr,lp.readError());
  }
  
}
