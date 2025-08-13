package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	
	WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By addButton = By.xpath("//button[contains(@class, 'oxd-button') and contains(., 'Add')]");
	By userDropDown = By.xpath("//div[@class='oxd-select-text-input' and text()='-- Select --']");
	By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
	By usernameField = By.xpath("//input[contains(@class, 'oxd-input') and @autocomplete='off']");
	By passwordField = By.xpath("//input[@type='password']");
	By confirmPasswordField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
	By adminPage = By.xpath("//span[contains(@class, 'oxd-main-menu-item--name') and text()='Admin']");
	
	
	public void addUser(String username,String password, String confirmpassword, String Employeename) throws InterruptedException {
		
		driver.findElement(adminPage).click();
		Thread.sleep(3000);
		driver.findElement(addButton).click();
		
		Thread.sleep(3000);
		
		driver.findElement(employeeNameField).sendKeys(Employeename);
//		WebElement userDropDownField = driver.findElement(userDropDown);
//		Select dropdown = new Select(userDropDownField);
//		dropdown.selectByVisibleText("ESS");
		
		driver.findElement(By.xpath("//div[@class='oxd-select-text-input' and text()='-- Select --']")).sendKeys("ESS");
		
//		driver.findElement(By.xpath("//div[@class='dropdown-option' and text()='Option 1']")).click();

		
		
	}
	

}
