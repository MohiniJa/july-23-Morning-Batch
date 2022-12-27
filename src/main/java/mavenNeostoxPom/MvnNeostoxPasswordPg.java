package mavenNeostoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MvnNeostoxPasswordPg

	{
		@FindBy(id="txt_accesspin")private WebElement PWDField;
		@FindBy(id="lnk_submitaccesspin")private WebElement submitButton;


	
public MvnNeostoxPasswordPg(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void sendPWD(String pass, WebDriver driver)
{
	PWDField.sendKeys(pass);
}
public void clickSubmit( WebDriver driver)
{
	MvnUtilityClass.wait(driver, 1000);
	submitButton.click();
}
}