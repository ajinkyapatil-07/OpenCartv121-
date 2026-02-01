package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.Baseclass;

public class TC002_LoginTest extends Baseclass {
	
	@Test(groups="Master")
	public void Verify_login()
	{
		logger.info("************** Starting TC_002_LoginTest *************************");
		
		//Homepage
		HomePage vp= new HomePage(driver);
		vp.clickmyacc();
		vp.clicklogin();
		
		//LoginPage
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clicklog();
		
        //Myaccount
	
	}
	}


