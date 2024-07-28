package Sample;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPhpTravelsFormAutomation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\joesa\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			driver.get("https://phptravels.com/demo");
			
			driver.manage().window().maximize();
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			WebElement firstNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("first_name")));
			//WebElement firstNameField = driver.findElement(By.name("first_name"));
			firstNameField.sendKeys("Sanjeev");
			
			WebElement lastNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("last_name")));
			lastNameField.sendKeys("Suganthi");
			
			WebElement businessNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("business_name")));
			businessNameField.sendKeys("Joe Inc.");
			
			
			WebElement whatsAppField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("whatsapp")));
			whatsAppField.sendKeys("6369881318");
			
			WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
			emailField.sendKeys("suganthisamuel25@gmail.com");
			
			WebElement num1Field = driver.findElement(By.xpath("//*[@id=\"numb1\"]"));
			WebElement num2Field = driver.findElement(By.xpath("//*[@id=\"numb2\"]"));
			
			
			String numb1 = num1Field.getText();
			String numb2 = num2Field.getText();

			
			int number1 = Integer.parseInt(numb1);
			int number2 = Integer.parseInt(numb2);

			
			int result = number1 + number2;

			
			WebElement answerBox = driver.findElement(By.xpath("//*[@id=\"number\"]"));

			answerBox.sendKeys(String.valueOf(result));
			
			driver.findElement(By.name("submit")).click();

			WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-successfully']")));
			if(successMessage.getText().equals("form submitted successfully")) {
				System.out.println("form submitted successfully");
			}else {
				System.out.println("form Submission failed");
			}
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(screenshot, new File("screenshot.png"));
			driver.quit();
	}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			