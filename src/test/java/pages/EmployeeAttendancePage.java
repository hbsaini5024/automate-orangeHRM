package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeAttendancePage {
	
	WebDriver driver;
	
	By attendanceBtn = By.xpath("//span[text()='Attendance ']");
	By employeeRecordsBtn = By.xpath("(//ul[@role='menu']/li)[3]");
	
	By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
	By viewBtn = By.xpath("//button[text()=' View ']");
	
	public EmployeeAttendancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	

	public void goToAttendance() {
		
		driver.findElement(attendanceBtn).click();
		driver.findElement(employeeRecordsBtn).click();
	}
	
	public void viewAttendance(String empName) {
		driver.findElement(attendanceBtn);
		driver.findElement(employeeNameField).sendKeys(empName);
		driver.findElement(viewBtn).click();
	}
}
