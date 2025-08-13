package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminRecruitmentPage {
	
	WebDriver driver;
	
	public AdminRecruitmentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	By vacaniesTab = By.xpath("//a[text()='Vacancies']");
	By addVacaniesBtn = By.xpath("//button[text()=' Add ']");
	
	By vacanyNameField = By.xpath("//div[contains(@class,\"oxd-input-field-bottom-space\")]//input[contains(@class,\"oxd-input--active\")]");
	By vacanyDescField = By.xpath("//textarea[@placeholder='Type description here']");
	By vacanyTitleField = By.xpath("//div[text()='-- Select --']");
	By hiringManagerField = By.xpath("//input[@placeholder='Type for hints...']");
	By saveVacanyBtn = By.xpath("//button[text()=' Save ']");
	//div[@role="option" and contains(@class, "oxd-select-option")]/span[contains(text(), "Pre-Sales Coordinator")]
	
	
//	Candidate Board
	By addCandidateBtn = By.xpath("//button[@type='button' and contains(@class, 'oxd-button--secondary')]");
	By candidateFirstName = By.xpath("//input[@placeholder='First Name']");
	By candidateLastName = By.xpath("//input[@placeholder='Last Name']");
	By selectVacany = By.xpath("//div[contains(text(),'-- Select --')]");
	By emailField = By.xpath("(//input[@class='oxd-input oxd-input--active' and @placeholder='Type here'])[1]");
	By saveCandidateBtn = By.xpath("//button[@type='submit' and text()=' Save ']");
	
	By submitCandidate = By.xpath("//div[@class='orangehrm-recruitment-status']/p");
	By shortlistCandidate = By.xpath("//button[text()=' Shortlist ']");
	
	
	public void goToVacanyTab() {
		
		driver.findElement(vacaniesTab).click();
		
	}
	
	public void addVacany() throws InterruptedException {
		
		driver.findElement(addVacaniesBtn).click();
		
		Thread.sleep(3000);
		driver.findElement(vacanyNameField).sendKeys("Talent Accquistion");
		
		try {
			driver.findElement(vacanyTitleField).click();
			List<WebElement> options = driver.findElements(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]/div"));
			
			for (WebElement opt : options) {
	            if (opt.getText().equals("HR Associate")) {
	                opt.click();
	                
	                break;
	            }
	        }
			
		}catch(StaleElementReferenceException e) {
			System.out.println(e);
		}
		Thread.sleep(4000);
		driver.findElement(vacanyDescField).sendKeys("New vacany");
		driver.findElement(hiringManagerField).sendKeys("Rahul Das");
		driver.findElement(saveVacanyBtn).click();
		
	}

	public Boolean isCandidateBoradDisplayed() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Candidates']")).click();
		Thread.sleep(3000);
		return driver.findElement(By.xpath("//h5[text()='Candidates']")).isDisplayed();
	}
	
	public void addCandidate() throws InterruptedException, AWTException {
		
		driver.findElement(addCandidateBtn).click();
		Thread.sleep(3000);
		driver.findElement(candidateFirstName).sendKeys("Aman");
		driver.findElement(candidateLastName).sendKeys("Rajput");
		driver.findElement(selectVacany).click();
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='option' and @class='oxd-select-option']"));
		
		for(WebElement option : options) {
			System.out.println(option.getText());
			if(option.getText().contains("Senior QA Lead")) {
				option.click();
				break;
			}
		}
		driver.findElement(emailField).sendKeys("harsh456@gmail.com");
		
		//file upload
		driver.findElement(By.xpath("//div[text()='No file selected']")).click();

		Robot rb = new Robot();
		rb.delay(2000); // Wait for dialog to open

		// Copy file path to clipboard
		StringSelection filePath = new StringSelection("C:\\Users\\DELL\\Desktop\\hello.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		// Press Ctrl+V to paste
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		// Press Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		
		driver.findElement(saveCandidateBtn).click();
		
	}
	
	public Boolean isCandidateSubmitted() {
		return driver.findElement(submitCandidate).getText().contains("Application Initiated");
	}
	
	public void shortlistCandidate() {
		driver.findElement(shortlistCandidate).click();
	}

}
