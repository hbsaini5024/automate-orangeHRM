package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobCategoryPage {
	
	WebDriver driver;
	
	public JobCategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	

	By adminPage = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
	By JobOption = By.xpath("//span[text()='Job ']");
	By JobTitles = By.xpath("//a[text()='Job Titles']");
	By addButton = By.xpath("//button[text()=' Add ']");
	By JobName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");
    By JobDescription = By.xpath("//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')]");
    By JobNote = By.xpath("//textarea[@placeholder='Add note']");
    By submitButton = By.xpath("//button[@type='submit']");
    
//    Edit JobTitles
    By editTitleName = By.xpath("//div[text()='SDET']/parent::div/parent::div/div[4]/div/button[2]");
    By browserUploadBtn = By.xpath("//div[text()='Browse']");
    
    public void addEmployee(String jobName, String jobDescription, String jobNote) throws InterruptedException, IOException {
    	
    	Thread.sleep(3000);
    	
    	driver.findElement(adminPage).click();
    	
    	Thread.sleep(3000);
    	driver.findElement(JobOption).click();
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement element = wait.until(
    		    ExpectedConditions.presenceOfElementLocated(JobTitles)
    	);
    	driver.findElement(JobTitles).click();
    	
    	Thread.sleep(4000);
    	
    	driver.findElement(addButton).click();
    	
    	Thread.sleep(4000);
    	
//    	Add a Job Title
    	driver.findElement(JobName).sendKeys(jobName);
    	driver.findElement(JobDescription).sendKeys(jobDescription);
    	driver.findElement(JobNote).sendKeys(jobNote);
    	
    	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File dest = new File("screenshots/screenshot1.png");
    	FileUtils.copyFile(src, dest);
    	
    	driver.findElement(submitButton).click();
    	
    	Thread.sleep(2000);
    }
    
    public void editEmployee(String jobName, String jobDescription, String jobNote, String filePath) throws InterruptedException {
    	
       Thread.sleep(3000);
    	
    	driver.findElement(adminPage).click();
    	
    	Thread.sleep(3000);
    	driver.findElement(JobOption).click();
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement element = wait.until(
    		    ExpectedConditions.presenceOfElementLocated(JobTitles)
    	);
    	driver.findElement(JobTitles).click();
    	
    	driver.findElement(editTitleName).click();
    	Thread.sleep(3000);
    	
//    	Edit the Values
    	driver.findElement(browserUploadBtn);
    }

}
