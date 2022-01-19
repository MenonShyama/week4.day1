package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		Thread.sleep(2000);
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		WebElement clickMeButton = driver.findElement(By.tagName("button"));
		File source = clickMeButton.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Assignment/clickMeButton.png");
		FileUtils.copyFile(source, destination);
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		findElements.size();
		System.out.println("Number of iframe:" + findElements);

	}

}
