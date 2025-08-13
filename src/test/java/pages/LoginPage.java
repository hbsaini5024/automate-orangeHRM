package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	By usernameField = By.xpath("//input[@name='username']");
	By passwordField = By.xpath("//input[@name='password']");
	
	By button = By.xpath("//button[@type='submit']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Login(String username, String Password) throws InterruptedException {
		
		Thread.sleep(2000);
		
		driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(Password);
        driver.findElement(button).click();
        
        Thread.sleep(3000);
	}

}
