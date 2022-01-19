package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		Thread.sleep(2000);
		
		//Open Home Page
		System.out.println("Open Home Page:Started");
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		String parentWindow=driver.getWindowHandle();
		Set<String> windowsHandles=driver.getWindowHandles();
		List<String> windows=new ArrayList<String>(windowsHandles);
		String childWindow=windows.get(1);
		driver.switchTo().window(childWindow);
		System.out.println("Title of childPage:"+driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println("Title of HomePage:"+driver.getTitle());
		driver.close();
		System.out.println("Open Home Page:Ended");
		
		//Open Multiple Windows
		System.out.println("Open multiple windows:Started");
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		String windowParent=driver.getWindowHandle();
		Set<String> windowsHandless=driver.getWindowHandles();
		List<String> windowss=new ArrayList<String>(windowsHandless);
		String childWindoww=windowss.get(1);
		driver.switchTo().window(childWindoww);
		System.out.println(driver.getTitle());
		driver.close();
		String childWindowww=windowss.get(2);
		driver.switchTo().window(childWindowww);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(windowParent);
		System.out.println(driver.getTitle());
		driver.close();
		System.out.println("Open multiple windows:Ended");
		
		
		//Do Not Close Me
		System.out.println("Do Not Close Me:Started");
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		String parentWin=driver.getWindowHandle();
		Set<String> winHandles=driver.getWindowHandles();
		List<String> win=new ArrayList<String>(winHandles);
		String childWin=win.get(1);
		driver.switchTo().window(childWin);
		System.out.println(driver.getTitle());
		driver.close();
		String childWind=win.get(2);
		driver.switchTo().window(childWind);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWin);
		System.out.println(driver.getTitle());
		System.out.println("Open multiple windows:Ended");
		
		//Wait for 5 seconds
		System.out.println("Wait for 5 seconds:Started");
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		String parWin=driver.getWindowHandle();
		Set<String> winHand=driver.getWindowHandles();
		List<String> wind=new ArrayList<String>(winHand);
		String chilWin=wind.get(1);
		driver.switchTo().window(chilWin);
		System.out.println(driver.getTitle());
		String childWindowPage=wind.get(2);
		driver.switchTo().window(childWindowPage);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parWin);
		System.out.println(driver.getTitle());
		driver.quit();
		System.out.println("Wait for 5 seconds:Ended");		
		
		

	}

}
