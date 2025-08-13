package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;
import pages.ViewEmployeeListPage;
import utils.BaseTest;

public class PIMTest extends BaseTest{
	
	
	@Test
	public void addEmployeeAndVerifyEmployee() throws InterruptedException {
		
		Thread.sleep(3000);
		
		LoginPage login = new LoginPage(driver);
		login.Login("Admin", "admin123");
		
		Thread.sleep(3000);
		
		DashboardPage dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.isDashboardDisplayed(), "You are not correctly land on Dashboard Page");
		dashboard.goToPIM();
		
		Thread.sleep(3000);
		
		PIMPage pim = new PIMPage(driver);
		Assert.assertTrue(pim.isPIMPageDisplayed(), "You are not succesfully redirected to PIM Page");
		pim.clickAddEmployee();
		
		Thread.sleep(3000);
		
		AddEmployeePage addEmp = new AddEmployeePage(driver);
		Assert.assertTrue(addEmp.isAddEmployeeFormVisible(), "You are not succesfully redirected to AddEmployeePage");
		String employee_ID = addEmp.addEmployee("Priyam","Saini");
		Thread.sleep(2000);
		System.out.println("Employee ID "+ employee_ID);
		
		addEmp.goToEmployeeList();
		Thread.sleep(2000);
		Assert.assertTrue(addEmp.isRedirectToEmployeeList(), "Succesfully Redirected");
		
		Thread.sleep(2000);
		
		ViewEmployeeListPage viewEmp = new ViewEmployeeListPage(driver);
		viewEmp.searchEmployee("Priyam");
		Thread.sleep(2000);
		String actualEmployee_Id = viewEmp.verifyEmployee(employee_ID);
		
		Assert.assertEquals(actualEmployee_Id, employee_ID);
	}

}
