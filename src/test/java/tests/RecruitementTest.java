package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminRecruitmentPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseTest;

public class RecruitementTest extends BaseTest {

	@Test
	public void hireEmployee() throws InterruptedException, AWTException {
		LoginPage login = new LoginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		AdminRecruitmentPage recruitement = new AdminRecruitmentPage(driver);
		
		login.Login("Admin", "admin123");
		
		Thread.sleep(3000);
		
		dashboard.goToRecruitement();
		Thread.sleep(4000);
		Assert.assertTrue(dashboard.isRecruitementDisplayed(), "You are not at Recruitement Board");
		
		recruitement.goToVacanyTab();
		Thread.sleep(5000);
		recruitement.addVacany();
		Thread.sleep(5000);
		
		Assert.assertTrue(recruitement.isCandidateBoradDisplayed(), "You are not candidate board");
		recruitement.addCandidate();
		Thread.sleep(5000);
		Assert.assertTrue(recruitement.isCandidateSubmitted(), "Candidate details are not submitted to the System");
		System.out.println("Done");
	}
}
