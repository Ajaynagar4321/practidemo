package excel;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenDemo {
	public WebDriver driver;

	@DataProvider
	public String[][] data() throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream("./data/Actitime.xlsx"));
		Sheet s = wb.getSheet("UserData");
		int row = s.getLastRowNum();//4
		int col = s.getRow(0).getLastCellNum();//2
		String[][] data = new String[row][col];
          
		for (int i = 0; i < row; i++) {
			data[i][0] = s.getRow(i + 1).getCell(0).toString();
			data[i][1] = s.getRow(i + 1).getCell(1).toString();
		}

		return data;

	}

	@Test(dataProvider = "data" )
	public void testData(String username, String password) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys(username);

		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.close();

	}

}