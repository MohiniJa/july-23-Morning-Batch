package mavenNeostoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MvnNeostoxHomePg 
{
	@FindBy(xpath = "(//a[text()='OK'])[2]")private WebElement okButton; 
	@FindBy(xpath = "(//a[text()='Close'])[5]")private WebElement closeButton; 
	@FindBy(id="lbl_username")private WebElement userName;
	@FindBy(xpath = "//span[text()='Logout']")private WebElement logoutButton;
	
	public MvnNeostoxHomePg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void popUpHandle(WebDriver driver)
	{
		if(okButton.isDisplayed())
		{
			okButton.click();
			MvnUtilityClass.scollIntoView(driver, closeButton);
			MvnUtilityClass.wait(driver, 1000);
			closeButton.click();
		}
		else
		{
		MvnUtilityClass.wait(driver, 1000);
		
	}
	}
	public String getUserName()
	{
		String actualUserName=userName.getText();
		return actualUserName;
		
	}
	public void LogoutFromNeostox()
	{
		userName.click();
		logoutButton.click();
	}
}

