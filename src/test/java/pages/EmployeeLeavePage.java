package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeLeavePage {
	
	WebDriver driver;
	
	public EmployeeLeavePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By applyLeaveBtn = By.xpath("//a[text()='Apply']");
	By SelectBtn = By.xpath("//div[text()='-- Select --']");
	By LeaveType = By.xpath("//div[@role='listbox']/div[2]");
	
	By startDate = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");
	By endDate = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
	By submitButton = By.xpath("//button[text()=' Apply ']");
	
	public boolean isEmployeePageDisplayed() {
		return false;
		
	}
	
	public void goToApplyLeave() {
		
		driver.findElement(applyLeaveBtn).click();
	}
	
	public void applyLeave() {
		driver.findElement(SelectBtn).click();
		driver.findElement(LeaveType).click();
		
		driver.findElement(startDate).sendKeys("2025-06-08");
		driver.findElement(endDate).sendKeys("2025-06-08");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Leaved Applied");
		driver.findElement(submitButton).click();
	}

}
