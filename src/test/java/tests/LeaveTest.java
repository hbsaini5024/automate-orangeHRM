package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.EmployeeLeavePage;
import pages.LoginViaUserPage;
import utils.BaseTest;

public class LeaveTest extends BaseTest{

	@Test(priority=1)
	public void applyLeaveFromUser() throws InterruptedException {
		
		LoginViaUserPage loginUser = new LoginViaUserPage(driver);
		loginUser.loginWithUserCredentials("rangaakunuria", "admin123");
		
		Thread.sleep(3000);
		
		DashboardPage dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.isDashboardDisplayed(), "You are not correctly land on Dashboard Page");
		dashboard.goToLeave();
		
		Thread.sleep(3000);
		
		EmployeeLeavePage leave = new EmployeeLeavePage(driver);
		leave.goToApplyLeave();
		
		Thread.sleep(2000);
		leave.applyLeave();
	}
	
	@Test(priority=2,enabled=false)
	public void approveLeaveFromAdmin() {
		
	}
	
}
