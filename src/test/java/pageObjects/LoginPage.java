package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage extends BasePage {
	
	WebDriver driver;
	public LoginPage( WebDriver driver)
	{
		super (driver);
	}

	
	 @FindBy (xpath="//input[@id='input-email']")
	 WebElement textEmail;
	 
	 @FindBy (xpath="//input[@id='input-password']")
	 WebElement textPassword;
	 
	 @FindBy (xpath="//input[@value='Login']")
	 WebElement btnlogin;
	 
	 
	 
	 public void setEmail(String email)
	 {
		textEmail.sendKeys(email);
	 }
	 
	 public void setPassword(String pwd)
	 {
		textPassword.sendKeys(pwd); 
	 }
	 
	 public void clicklog()
	 {
		 btnlogin.click();
	 }
}
