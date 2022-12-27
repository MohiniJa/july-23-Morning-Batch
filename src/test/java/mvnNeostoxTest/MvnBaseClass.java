package mvnNeostoxTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import mavenNeostoxPom.MvnUtilityClass;

public class MvnBaseClass 
{
protected WebDriver driver;
	public  void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\23 july morn B22 java\\chromedriver.exe");
		
	      driver=new ChromeDriver();
	      driver.get("https://neostox.com/sign-in");
	      driver.manage().window().maximize();
	      MvnUtilityClass.wait(driver, 1000);
	}
	public  void closeBrowser() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}
	
}
