package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {
	
	WebDriver driver;
	
	By fullNameTag = By.xpath("//label[text()='Employee Full Name']");
	
	By firstNameField = By.xpath("//input[@name='firstName']");
	By lastNameField = By.xpath("//input[@name='lastName']");
	By submitBtn = By.xpath("//button[@type='submit']");
	
	By employeeListBtn = By.xpath("//a[text()='Employee List']");
	By searchBtn = By.xpath("//button[text()=' Search ']");
	
	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isAddEmployeeFormVisible() {
	    return driver.findElement(fullNameTag).isDisplayed();
	}
	
	public String addEmployee(String firstName, String lastName) {
		
		driver.findElement(firstNameField).sendKeys(firstName);
		driver.findElement(lastNameField).sendKeys(lastName);
		String emp_id = driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")).getAttribute("value");
		driver.findElement(submitBtn).click();
		System.out.println(emp_id);
		return emp_id;
	}
	
	public void goToEmployeeList() {
		driver.findElement(employeeListBtn).click();
	}
	
	public boolean isRedirectToEmployeeList() {
		
		return driver.findElement(searchBtn).isDisplayed();
	}

}
