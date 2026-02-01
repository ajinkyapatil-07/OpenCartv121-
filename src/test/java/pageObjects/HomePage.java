package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//Invoked constructor
	
	WebDriver driver;
    public HomePage( WebDriver driver)
    {
    	super(driver);
    	
    }
    
    //Locators
    
    @FindBy(xpath ="//span[normalize-space()='My Account']")
    WebElement InMyaccount;
    
    @FindBy(xpath="(//a[normalize-space()='Register'])[1]")
    WebElement lnkRegister;
    
    @FindBy (xpath="//a[normalize-space()='Login']")
	 WebElement clicklgn;
    
    //ActionMethods
    
    public void clickmyacc()
    {
       InMyaccount.click();
    }
    
    public void clickRegister()
    {
    	lnkRegister.click();
    }
    
    public void clicklogin()
	 {
		 clicklgn.click();
	 }
}
