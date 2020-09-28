package takesscreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeightWidth {
	
public static WebDriver driver;
	
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost/login.do");
		WebElement untb = driver.findElement(By.id("username"));
		WebElement pwtb = driver.findElement(By.name("pwd"));
		
		int usntb_height = untb.getSize().getHeight();
		int pswd_height = pwtb.getSize().getHeight();
		System.out.println(usntb_height);
		System.out.println(pswd_height);
		
		
	if(usntb_height==pswd_height)
	{
		System.out.println("Both fields are alligned");
	}
	else
	{
		System.out.println("Not alligned");
	}
	String version = driver.findElement(By.xpath("//nobr[contains(text(),'actiTIME')]")).getText();
	
	System.out.println(version);
	
	
	
}
}