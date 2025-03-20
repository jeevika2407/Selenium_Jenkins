package com.kiot;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle5 {

	public static void main(String[] args) {
		        WebDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        
		        driver.get("https://leafground.com/window.xhtml");
		        
		        String parentWindow = driver.getWindowHandle();
		        System.out.println("Parent window handle: " + parentWindow);

		        WebElement open = driver.findElement(By.xpath("//span[text()='Close Windows']"));
		        open.click();

		        Set<String> allWindows = driver.getWindowHandles();
		        
		        for (String window : allWindows) {
		            if (!window.equals(parentWindow)) {
		                driver.switchTo().window(window);
		                driver.close();  
		            }
		        }

		        driver.switchTo().window(parentWindow);
		        WebElement multipletabs=driver.findElement(By.xpath("//span[text()='Open Multiple']"));
		        multipletabs.click();
		        Set<String> multiple=driver.getWindowHandles();
		        System.out.println(multiple.size());

	}

}
