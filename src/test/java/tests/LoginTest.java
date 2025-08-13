package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void doLogin() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		
		Thread.sleep(4000);
		
		login.Login("Admin" , "admin123");
		
//		WebElement img = driver.findElement(By.xpath("//img[@alt='client brand banner']"));
//		Assert.assertTrue(img.isDisplayed(), "Login is not happened succesfully");
		
	}
	
}