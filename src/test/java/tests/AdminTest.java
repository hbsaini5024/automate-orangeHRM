package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.LoginPage;
import utils.BaseTest;

public class AdminTest extends BaseTest{
	
	@Test
	public void addNewUser() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		AdminPage admin = new AdminPage(driver);
		login.Login("Admin", "admin123");
		
		Thread.sleep(3000);
		
		admin.addUser("hbsaini5024", "abc@123", "abc@123", "Harsh Bobby");
		
		Thread.sleep(2000);
		
	}
}
