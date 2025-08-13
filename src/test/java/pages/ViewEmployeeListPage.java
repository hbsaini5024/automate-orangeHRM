package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ViewEmployeeListPage {
	
	WebDriver driver;
	
	By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
	By searchBtn = By.xpath("//button[text()=' Search ']");
	
	public ViewEmployeeListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchEmployee(String employeeName) {
		
		driver.findElement(employeeNameField).sendKeys(employeeName);
		driver.findElement(searchBtn).click();
		
	}
	
	public String verifyEmployee(String employeeId) {
		
		String visibleId = driver.findElement(By.xpath("//div[text()='"+employeeId+"']")).getText();
		return visibleId;
		
	}

}
