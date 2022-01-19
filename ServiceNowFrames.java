package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowFrames {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev116565.service-now.com/login.do?");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Shyama@123");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		Thread.sleep(5000);
		WebElement filter = driver.findElement(By.xpath("//input[@id='filter']"));
		filter.sendKeys("incident");
		filter.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//b[text()='All']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='input-group-btn']/button")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> windowsHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowsHandles);
		String childWindow = windows.get(1);
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//tbody[@class='list2_body']//a")).click();
		driver.switchTo().window(parentWindow);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//input[contains(@id,'short_description')])[4]")).sendKeys("Selenium driver");
		WebElement element = driver.findElement(By.xpath("//input[@id='incident.number']"));
		String incidentNumber = element.getAttribute("value");
		System.out.println("Incident Number:" + incidentNumber);
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		Thread.sleep(2000);

		WebElement searchBox = driver.findElement(By.xpath("//div[@class='input-group']/input"));
		searchBox.sendKeys(incidentNumber);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String resultincidentNumber = driver.findElement(By.xpath("//tbody[@class='list2_body']//td[@class='vt']/a"))
				.getText();
		if (resultincidentNumber.equals(incidentNumber)) {
			File source = driver.getScreenshotAs(OutputType.FILE);
			File destination = new File("./Assignment/successimage.png");
			FileUtils.copyFile(source, destination);
			System.out.println("Incident Created Successully");
		} else {
			System.out.println("Error occurred.execution failed");
		}

		driver.close();
	}

}
