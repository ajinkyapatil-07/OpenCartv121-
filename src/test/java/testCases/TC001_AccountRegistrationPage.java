package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.Baseclass;

public class TC001_AccountRegistrationPage extends Baseclass {
	
//	WebDriver driver;
	
	@Test(groups={"Sanity", "Master"})
	public void verify_account()
	{
		
		logger.info("***************** Starting TC001_AccountRegistrationTest ************************");
		try {
		HomePage hp= new HomePage(driver);
		hp.clickmyacc();
		logger.info("Clicked on My account link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		
		AccountRegistrationPage ar= new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details......");
		ar.setFirstName(randomeString().toUpperCase());
		ar.setLastName(randomeString().toUpperCase());
		ar.setEmail(randomeString() +"@gmail.com");
		ar.setTelephone(randomenumber());
		
		//String password=randomeAlphaNumeric();
		ar.setPassword("password");
		ar.setConfirmPassword("password");
		
		ar.Setprivcypolicy();
		ar.clickcontinue();
		
		logger.info("Validating expecting message");
		String confsmsg=ar.getConfirmationMsg();
		//Assert.assertEquals(confsmsg, "Your Account Has Been Created!1");
		
		if(confsmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			logger.error("Debug logs..");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
			
			Assert.fail();
			
		}
	
	   logger.info("************** Finished TC001_AccountRegestrtionTest **************************");
	}

	}
