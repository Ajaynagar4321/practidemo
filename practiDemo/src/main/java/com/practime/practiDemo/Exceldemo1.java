package com.practime.practiDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exceldemo1 {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws EncryptedDocumentException, Exception, Exception {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
		Workbook wb = WorkbookFactory.create(new FileInputStream("./datos/ApplicationData.xlsx"));
		Sheet s = wb.getSheet("AppData");
		
		for (int i = 0; i <=s.getLastRowNum(); i++) {
			
			
			Cell username = s.getRow(i+1).getCell(0);
			Cell password = s.getRow(i+1).getCell(1);
			
			String untb = username.toString();
			String pwtb = password.toString();
			
			System.out.println(untb+" "+pwtb);
			
			
			driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("http://localhost/login.do");
			
			driver.findElement(By.id("username")).sendKeys("untb");
			driver.findElement(By.name("pwd"));
			driver.findElement(By.xpath("//div[.='Login ']"));
			driver.close();
			
		}
		
		
		
		
		
	}

}