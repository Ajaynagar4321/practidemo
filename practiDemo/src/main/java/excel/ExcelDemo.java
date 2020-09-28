package excel;

import org.testng.annotations.Test;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExcelDemo {

	public static WebDriver driver;

	@Test
	public static void main() throws Exception, Exception, Exception {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		Workbook wb = WorkbookFactory.create(new FileInputStream("./data/Actitime.xlsx"));
		Sheet s = wb.getSheet("UserData");
		for (int i = 0; i <= s.getLastRowNum(); i++) {
			driver = new ChromeDriver();
			Cell username = s.getRow(i+1).getCell(0);
			Cell password = s.getRow(i+1).getCell(1);
			String untb = username.toString();
			String pwtb = password.toString();
			System.out.println(untb + " " + pwtb);
			driver.get("http://localhost/login.do");

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("username")).sendKeys(untb);
			
			driver.findElement(By.name("pwd")).sendKeys(pwtb);
			Thread.sleep(2000);
			driver.close();

		}
	}

}
