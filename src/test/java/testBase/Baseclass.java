package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Baseclass {
	
	public static WebDriver driver;
	public Logger logger;  // Log4j2.xml
	public Properties p;
	
	@BeforeClass(groups={"Sanity","Regression","Master","DataDriven"})
	@Parameters({"os","browser"})  // for parallel and crossbrowsing testing
	public void Setup(String os , String br) throws IOException
	{
		//Loading Config.properties file
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger= LogManager.getLogger(this.getClass());  // Log4j2.xml
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))// for WINDOWS-----------------------------------

		{
           DesiredCapabilities capabilities=new DesiredCapabilities();

		//os----------------------------------------------------------------------------
          if(os.equalsIgnoreCase("windows"))

		{    
        	  capabilities.setPlatform (Platform.WIN11);
		}
          else if(os.equalsIgnoreCase("linux"))
          {
        	  capabilities.setPlatform (Platform.LINUX);  
          }
         else if (os.equalsIgnoreCase("mac"))
       {
             capabilities.setPlatform (Platform.MAC);
		}
		else
		{
              System.out.println("No matching os");
             return;
		}

		//browser------------------------------------------------------------------------------
		switch(br.toLowerCase())
		{
		case "chrome": capabilities.setBrowserName("chrome"); break;
        case "firefox": capabilities.setBrowserName("firefox");break;
        case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
        default: System.out.println("No matching browser"); return;
		}

		driver=new RemoteWebDriver(new URL("http://172.21.32.1:4444/"), capabilities);
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))// for Local--------------------------------
		
		switch(br.toLowerCase())   
		{
		case "chrome" :  driver= new ChromeDriver(); break;
		case "edge" :    driver= new EdgeDriver(); break;
		case "firefox":  driver= new FirefoxDriver();break;
		default : System.out.println("Invalid broswer name"); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appurl")); //Reading url from properties file
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups={"Sanity","Regression","Master","DataDriven"})
	public void TearDown()
	{
		driver.quit();
	}

	public String randomeString()
	{
		String generateString= RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	
	public String randomenumber()
	{
		String generatednumber= RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomeAlphaNumeric()
	{
		String generateString= RandomStringUtils.randomAlphabetic(3);
		String generatednumber= RandomStringUtils.randomNumeric(3);
		return(generateString+ "@" +generatednumber);
	}
	
	public String captureScreen(String tname)throws IOException {
			
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takescreenshot= (TakesScreenshot) driver;
		File sourceFile= takescreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";   
	
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
}
