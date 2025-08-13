package tests;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.EmployeeAttendancePage;
import pages.EmployeePunchInPunchOutPage;
import pages.LoginPage;
import utils.BaseTest;

public class TimeModuleTest extends BaseTest{
	
	@Test
	public void markAttendance() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		EmployeePunchInPunchOutPage attendance = new EmployeePunchInPunchOutPage(driver);
		EmployeeAttendancePage availability = new EmployeeAttendancePage(driver);
		
//		Login as Employee
		login.Login("FMLName", "admin123");
		
		Thread.sleep(3000);
		
		dashboard.goToTime();
		
		Thread.sleep(3000);
		
		
		attendance.doPunchIn();
		Thread.sleep(10000);
		attendance.doPunchOut();
		
		Thread.sleep(2000);
		attendance.doLogout();
		
		Thread.sleep(5000);
		
//		Login as Admin
		login.Login("Admin", "admin123");
		Thread.sleep(3000);
		dashboard.goToTime();
		
		Thread.sleep(3000);
		
		availability.goToAttendance();
		Thread.sleep(2000);
		availability.viewAttendance("Qwerty LName");
		
	}

}
