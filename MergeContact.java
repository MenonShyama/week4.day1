package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch URL "http://leaftaps.com/opentaps/control/login"

		driver.get("http://leaftaps.com/opentaps/control/login");
		Thread.sleep(5000);
		// Enter UserName and Password Using Id Locator

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button using Class Locator

		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// Click on Widget of From Contact
		driver.findElement(By.xpath("//table[@class='twoColumnForm']//img[1]")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> WindowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(WindowHandles);
		String childWindow = windows.get(1);
		driver.switchTo().window(childWindow);

		// Click on First Resulting Contact
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a")).click();
		driver.switchTo().window(parentWindow);

		// Click on Widget of To Contact
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following::a")).click();
		Thread.sleep(2000);
		String parentWindoww = driver.getWindowHandle();
		Set<String> WindowHandless = driver.getWindowHandles();
		List<String> windowss = new ArrayList<String>(WindowHandless);
		String childWindoww = windowss.get(1);
		driver.switchTo().window(childWindoww);
		Thread.sleep(2000);

		// Click on Second Resulting Contact
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/following::a[@class='linktext']")).click();
		driver.switchTo().window(parentWindoww);

		// Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Thread.sleep(2000);

		// Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		// Verify the title of the page
		String pageTitle = "View Contact | opentaps CRM";
		String title = driver.getTitle();
		System.out.println(title);
		if (pageTitle.equals(title)) {
			System.out.println("Execution success and the page title matches");
		} else {
			System.out.println("Execution failed,page title doesn't match");
		}

		driver.close();

	}

}
