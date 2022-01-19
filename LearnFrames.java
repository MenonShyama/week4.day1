package week4.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//h1")).getText());
		System.out.println(driver.findElement(By.xpath("//label")).getText());
		driver.switchTo().frame("frame1").findElement(By.xpath("//input")).sendKeys("123");
		driver.switchTo().frame("frame3").findElement(By.xpath("//input[@id='a']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='animals']"));
		Select dd=new Select(dropDown);
		dd.selectByVisibleText("Baby Cat");
		driver.switchTo().defaultContent();
		driver.close();
		
		

	}

}
