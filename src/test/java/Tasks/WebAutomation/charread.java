package Tasks.WebAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class charread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        //Chrome Browser Invokation
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vignesh.thangavel\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Hit url
		driver.get("https://github.com");
		//Maximize window
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Search GitHub']")).sendKeys("react");
		driver.findElement(By.id("jump-to-suggestion-search-global")).click();
		driver.findElement(By.linkText("Advanced search")).click();
		//Static dropdowns using Select Class
		WebElement Languages = driver.findElement(By.id("search_language"));
		Select desiredlanguage = new Select(Languages);
		desiredlanguage.selectByValue("JavaScript");
		driver.findElement(By.id("search_stars")).sendKeys(">45");
		driver.findElement(By.id("search_followers")).sendKeys(">50");
		WebElement licenses = driver.findElement(By.id("search_license"));
		Select desiredLicense = new Select(licenses);
		desiredLicense.selectByVisibleText("Boost Software License 1.0");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// retrieve the text value
		String actualText = driver.findElement(By.xpath(
				"//div[@class='d-flex flex-column flex-md-row flex-justify-between border-bottom pb-3 position-relative']"))
				.getText();
		//Verify using assert(Actual vs Expected)
		Assert.assertEquals(actualText, "1 repository result");
		String actualRepositoryname = driver.findElement(By.xpath("//a[@class='v-align-middle']")).getText();
		Assert.assertEquals(actualRepositoryname, "mvoloskov/decider");
		driver.findElement(By.xpath("//a[@class='v-align-middle']")).click();
		//Limiting the scope of the driver
	    WebElement readmeDriver = driver.findElement(By.xpath("//div[@data-target='readme-toc.content']"));
	    String expectedText = readmeDriver.getText();
	    //Printing the first 300 characters
	    System.out.println(expectedText.substring(0, 300));
		

	}

}
