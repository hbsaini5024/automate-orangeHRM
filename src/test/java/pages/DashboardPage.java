package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By DashboardHeading = By.xpath("//h6[text()='Dashboard']");
	By PIMModule = By.xpath("//span[text()='PIM']");
	By LeaveModule  = By.xpath("//span[text()='Leave']");
	By TimeModule = By.xpath("//span[text()='Time']");
	By recruitementTab = By.xpath("//span[text()='Recruitment']");
	By recruitementHeading = By.xpath("//h6[text()='Recruitment']");
	

//	Validation
	public boolean isDashboardDisplayed() {
	    return driver.findElement(DashboardHeading).isDisplayed();
	}
	
//	Redirection to PIM for admin
	public void goToPIM() {
		
		driver.findElement(PIMModule).click();
		
	}
	
//	Redirection to Leave Page for Normal User
	
	public void goToLeave() {
		driver.findElement(LeaveModule).click();
	}
	
	public void goToTime() {
		driver.findElement(TimeModule).click();
	}
	
	
	public void goToRecruitement() {
		driver.findElement(recruitementTab).click();
	}
	
	public boolean isRecruitementDisplayed() {
	    return driver.findElement(recruitementHeading).isDisplayed();
	}

}
