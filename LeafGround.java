package week4.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		// Alert Box
		System.out.println("Alert box started");
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println("Alert box ended");

		// Confirm Box
		System.out.println("Confirm box started");
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert confirmAlert = driver.switchTo().alert();
		System.out.println(confirmAlert.getText());
		confirmAlert.accept();
		// confirmAlert.dismiss();
		System.out.println("Confirm box ended");

		// Prompt Box
		System.out.println("Prompt box started");
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Thread.sleep(2000);
		Alert promptAlert = driver.switchTo().alert();
		System.out.println(promptAlert.getText());
		promptAlert.sendKeys("123");
		promptAlert.accept();
		System.out.println("Prompt box ended");

		// Line Breaks
		System.out.println("Line break started");
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Alert lineBreakAlert = driver.switchTo().alert();
		System.out.println(lineBreakAlert.getText());
		lineBreakAlert.accept();
		System.out.println("Line break ended");

		// Sweet Alert
		System.out.println("Sweet alert started");
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='swal-modal']/div")).getText());
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		System.out.println("Sweet alert ended");

		System.out.println("ALert task completed!!!");

		driver.close();
	}

}
