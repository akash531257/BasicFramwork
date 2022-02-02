package pages;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {

	
	WebDriver driver;
	
	//Driver is null if we use webelement here
//	public WebElement email= driver.findElement(By.id("usernameInput-input"));
//	public WebElement password=driver.findElement(By.id("password-input"));
//	public WebElement logInButton=driver.findElement(By.id("signIn"));
//	public WebElement globalError=driver.findElement(By.id("globalError"));
//	public WebElement generalError=driver.findElement(By.className("Error__text"));
 
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement logInButton;
	
	@FindBy(id = "globalError")
    public WebElement globalError;
	
	@FindBy(className = "Error__text")
    public WebElement generalError;

	
	
	 
	 
	public void openBrowser() throws IOException {
		Properties prop =new Properties();
		 String path;
		FileInputStream fis = new FileInputStream("C:\\Users\\JAY SHRI KRISHNA\\Desktop\\Testing Class\\Projectfolder\\Selenium_Workspace\\BasicFrameWork59\\src\\repo.properties");
		prop.load(fis);
		path=prop.getProperty("firefoxPath");
		
		System.setProperty("webdriver.gecko.driver",path);
		driver=new FirefoxDriver();
		
		PageFactory.initElements(driver,this);
		
		
	}
	public void openLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=KMVyG8LSwnA&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiS01WeUc4TFN3bkEiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY0MzA1MjAzOSwiaWF0IjoxNjQzMDUwODM5LCJqdGkiOiJlNWNkN2M4Mi1kZjg0LTRkYjMtOTViYy0wNDJlODIwMDc0YWQiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.tVS8mB2ZYCQx3r8Ra8yqlQlHjauCJbiuRwquxnS8FcpC73rBI5CuizK0eCs_W0yo8ikjjz4U8TZMCmOhXBqCzjUMfsAZvFl2DqIObUHuw8u6XbhPDg_X-WHrUrF4vbgiT8KDFRnexAsizZrkRyJ53-wKxlpuGXaruaL3SOp8eB5UONJEedcxuF6OGirJ1XWZZ-VSfdeyQFdbNpy7qHuL1EbAW5DtjLbWlcSFzQR9X03-2CjfXbzTSUXeHBn7hj-DM2bAmPnBFG4kF2v3h11GMxyNQvETSvfQfUetAed2KLakMh2zmNSymMjhIAUKyL8y9UunoxET4POhALfvJNKDow&preferred_environment="
				 );
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void closeBrowser() {
		driver.close();
	}
	public void login(String a,String b) throws InterruptedException {
		   email.sendKeys(a);
			password.sendKeys(b);
			logInButton.click();
			Thread.sleep(4000);
	}
	public String readGlobalError() {
        String p=globalError.getText();
		//System.out.println(p);
		return p;
	}
	public String readError() {
		 String p=generalError.getText();
		 //System.out.println(p);
		return p;
	}
}
