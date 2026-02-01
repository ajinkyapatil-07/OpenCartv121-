package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
//------------------------------------------------------------------------------------------------------------------------------	
	@FindBy (xpath = "//input[@id='input-firstname']")
	WebElement textFirstName;
	
	@FindBy (xpath ="//input[@id='input-lastname']")
	WebElement textlastname;
	
	@FindBy (xpath="//input[@id='input-email']")
	WebElement textEmail;
	
	@FindBy (xpath="//input[@id='input-telephone']")
	WebElement textTelephone;
	
	@FindBy(xpath= "//input[@id='input-password']")
    WebElement textPassword;
	
	@FindBy (xpath= "//input[@id='input-confirm']")
	WebElement textConfirmpassword;

	@FindBy (xpath= "//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy (xpath= "//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
//--------------------------------------------------------------------------------------------------------------------------------	
	public void setFirstName(String fname)
	{
		textFirstName.sendKeys(fname);
	}
	
	public void setLastName(String Lname)
	{
		textlastname.sendKeys(Lname);
	}
	
	public void setEmail(String email)
	{
		textEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		textTelephone.sendKeys(telephone);
	}
	
	public void setPassword( String pwd)
	{
		textPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword( String pwd)
	{
		textConfirmpassword.sendKeys(pwd);
		
	}
	
	public void Setprivcypolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickcontinue()
	{
		btncontinue.click();
	}
//---------------------------------------------------------------------------------------------------------------------------------	
	
	public String getConfirmationMsg()
	{
		try {
			return (msgconfirmation.getText());
	}
	catch(Exception e){
		return (e.getMessage());
	}
}}
