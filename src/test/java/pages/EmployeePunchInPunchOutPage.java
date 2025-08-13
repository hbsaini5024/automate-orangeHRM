package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePunchInPunchOutPage {
	
	WebDriver driver;
	
	public EmployeePunchInPunchOutPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By attendaceDropDown = By.xpath("//span[text()='Attendance ']");
	By punchInpunchOut = By.xpath("//a[text()='Punch In/Out']");
	By PunchInNote = By.xpath("//textarea[@placeholder='Type here']");
	By PunchInBtn = By.xpath("//button[text()=' In ']");
	By PunchOutBtn = By.xpath("//button[text()=' Out ']");
	By logout1 = By.xpath("//img[@alt='profile picture']");
	By logout2 = By.xpath("(//ul[@role='menu']/li)[4]");
	
	public void doPunchIn() throws InterruptedException {
		
		driver.findElement(attendaceDropDown).click();
		Thread.sleep(2000);
		driver.findElement(punchInpunchOut).click();
		
		Thread.sleep(2000);
		
		driver.findElement(PunchInNote).sendKeys("Punch In Succesfully");
		driver.findElement(PunchInBtn).click();
	}
	
	public void doPunchOut() throws InterruptedException {
		
		driver.findElement(PunchInNote).sendKeys("Punch Out Succesfully");
		driver.findElement(PunchOutBtn).click();
	}
	
	public void doLogout() {
		driver.findElement(logout1).click();
		driver.findElement(logout2).click();
	}

}
