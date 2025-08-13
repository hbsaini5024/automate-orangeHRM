package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginViaUserPage {
	
	WebDriver driver;
	
	public LoginViaUserPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By usernameField = By.xpath("//input[@name='username']");
	By passwordField = By.xpath("//input[@name='password']");
	
	By button = By.xpath("//button[@type='submit']");
	
	public void loginWithUserCredentials(String username, String Password) throws InterruptedException {
		
       Thread.sleep(2000);
		
		driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(Password);
        driver.findElement(button).click();
        
        Thread.sleep(3000);
		
	}

}
