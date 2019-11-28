package org.cts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Example extends Base {
   public static void main(String[] args) throws Exception {
	
	   System.out.println("default thing");
	   System.out.println("Constructor");

		load("https://www.facebook.com");
		WebElement user = driver.findElement(By.id("email"));
		fill(user,getData(0,0));
		
		
		
}
		
	

	
}
