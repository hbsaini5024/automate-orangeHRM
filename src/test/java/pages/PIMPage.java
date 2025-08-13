package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage {
	
	WebDriver driver;
	
	By addEmployeeBtn = By.xpath("//button[text()=' Add ']");
	
	public PIMPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPIMPageDisplayed() {
	    return driver.getCurrentUrl().contains("/pim");
	}

	
	public void clickAddEmployee() {
		
		driver.findElement(addEmployeeBtn).click();
		
	}

}
