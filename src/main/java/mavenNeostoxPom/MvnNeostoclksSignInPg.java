package mavenNeostoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MvnNeostoclksSignInPg
{
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber")private WebElement MbNoField;
	@FindBy(id="lnk_signup1")private WebElement signInButton;

	public MvnNeostoclksSignInPg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendMbNum(String MbNum, WebDriver driver)
	{
		MvnUtilityClass.wait(driver, 1000);
		MbNoField.sendKeys(MbNum);
	}
	public void clickOnSignInButton(WebDriver driver)
	{
		MvnUtilityClass.wait(driver, 1000);
		signInButton.click();
	}
	

}
