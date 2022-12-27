package mvnNeostoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mavenNeostoxPom.MvnNeostoclksSignInPg;
import mavenNeostoxPom.MvnNeostoxHomePg;
import mavenNeostoxPom.MvnNeostoxPasswordPg;
import mavenNeostoxPom.MvnUtilityClass;
public class MvnneostoxValidation extends MvnBaseClass
{
	MvnNeostoclksSignInPg signIn;
	MvnNeostoxPasswordPg Password;
	MvnNeostoxHomePg home;
	 @BeforeClass
	  public void launchNeostox()
	 {
		 launchBrowser();
		 signIn=new MvnNeostoclksSignInPg(driver);
		 Password=new MvnNeostoxPasswordPg(driver);
		home=new MvnNeostoxHomePg(driver);
	  }
  
  @BeforeMethod
  public void signInToNeostox() throws IOException, InterruptedException
  {Thread.sleep(1000);
	signIn.sendMbNum(MvnUtilityClass.ReadDataFromExcelSheet(0, 0), driver);  
	signIn.clickOnSignInButton(driver);
	
	Thread.sleep(5000);
	Password.sendPWD(MvnUtilityClass.ReadDataFromExcelSheet(0, 1), driver);
	Password.clickSubmit(driver);
	  
	Thread.sleep(1000);
	home.popUpHandle(driver);
  }

  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
  {
	Assert.assertEquals(home.getUserName(),MvnUtilityClass.ReadDataFromExcelSheet(0, 2), "Tc failed,actual and expeced username mot matching");
	  MvnUtilityClass.takeScreenShot(driver, home.getUserName());
	
  }
  
  @AfterMethod
  public void afterMethod() 
  {
	  home.LogoutFromNeostox();
  }

  @AfterClass
  public void afterClass() throws InterruptedException 
  {
	  closeBrowser();
  }

}
