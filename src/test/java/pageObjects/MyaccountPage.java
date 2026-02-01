package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage{
	
	WebDriver driver;
	
	public MyaccountPage( WebDriver driver)
	
	{
		super (driver);
	}
	
	@FindBy (xpath="")
	WebElement msgHeading;
	
	public boolean ismyaccountExits()
	{
		try {
			return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
