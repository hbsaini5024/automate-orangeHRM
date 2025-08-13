package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.JobCategoryPage;
import pages.LoginPage;
import utils.BaseTest;

public class JobCategoryTest extends BaseTest {
	
	@Test
	public void addNewUser() throws InterruptedException, IOException {
		LoginPage login = new LoginPage(driver);
		JobCategoryPage jobCategory = new JobCategoryPage(driver);

		Thread.sleep(4000);

		login.Login("Admin", "admin123");
		
		Thread.sleep(2000);
		
		jobCategory.addEmployee("SDET/Automation", "Development and Testing", "It's a kind of profile in which includes development and as well as testing");
		
//		jobCategory.editEmployee("", "", "", "");
	}

}
