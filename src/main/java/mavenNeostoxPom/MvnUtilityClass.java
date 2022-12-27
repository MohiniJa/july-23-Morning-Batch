package mavenNeostoxPom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class MvnUtilityClass 
{
	public static String ReadDataFromExcelSheet(int row, int cell) throws EncryptedDocumentException, IOException
	{
		File myFile=new File("C:\\eclipse\\23 july morn B22 java\\Book1.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet1");
		String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
	public static void takeScreenShot(WebDriver driver, String filename) throws IOException
	{
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File dest=new File("C:\\eclipse\\23 july morn B22 java\\screenshot "+filename+".jpg");
	  FileHandler.copy(src, dest);
	}
	
	public static void scollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}
	
	public static void wait(WebDriver driver, int waittime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waittime));
	}
	
	public static String ReadDataFromPropertyFile(String key) throws IOException
	{
		Properties obj=new Properties();
		FileInputStream objFile=new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\july23_morn_B22\\myProperty.properties");
		obj.load(objFile);
		String value = obj.getProperty(key);
		return value;
	}

}
