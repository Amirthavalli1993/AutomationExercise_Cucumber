package base;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties p;
	public static Logger log;
	
	public static WebDriver initializeBrowser() throws IOException
	{
		p=getProperties();
		String execution_env=p.getProperty("execution_env");
		String browser=p.getProperty("browser");
		String os=p.getProperty("os");
		
		if(execution_env.equalsIgnoreCase("remote"))
		{
			//set browser & os
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//set Os
			switch(os)
			{
				case "windows": capabilities.setPlatform(Platform.WIN11); break;
				case "mac": capabilities.setPlatform(Platform.MAC); break;
				case "linux": capabilities.setPlatform(Platform.LINUX); break;
				default: System.out.println("Invalid OS"); return null;			
			}
			
			//set browser
			switch(browser)
			{
				case "chrome": capabilities.setBrowserName("chrome"); break;
				case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
				case "firefox": capabilities.setBrowserName("firefox"); break;
				default: System.out.println("Invalid Browser"); return null;
			}	
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		else if(execution_env.equalsIgnoreCase("local"))
		{
			switch(browser)
			{
				case "chrome": driver=new ChromeDriver(); break;
				case "edge": driver=new EdgeDriver(); break;
				case "firefox": driver=new FirefoxDriver(); break;
				default: System.out.println("Invalid Browser"); return null;			
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().deleteAllCookies();
		}
		
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static Properties getProperties() throws IOException
	{
		FileReader file=new FileReader(".//src/test/resources/config.properties");
		p=new Properties();
		p.load(file);		
		return p;
	}
	
	public static Logger getLogger()
	{
		log=LogManager.getLogger();
		return log;
	}
	
	public static String randomString()
	{
		String randomeString=RandomStringUtils.randomAlphabetic(7);
		return randomeString;
	}
	
	public static String randomNumber()
	{
		String randomeNumber=RandomStringUtils.randomNumeric(10);
		return randomeNumber;
	}
	
	public static String randomNumberAndString()
	{
		String randomeString=RandomStringUtils.randomAlphabetic(7);
		String randomeNumber=RandomStringUtils.randomNumeric(5);
		return (randomeString+"@"+randomeNumber);
	}
}
