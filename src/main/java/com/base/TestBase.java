package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.utility.PageBase;

public class TestBase extends PageBase  {
	public static WebDriver driver;
	public static Properties prop;
	//public static Logger log =Logger.getLogger(TestBase.class);
public WebDriver initialization(String fileName)throws IOException {
		
		//System.getProperty("user.dir");
		 Properties prop = new Properties();//to read cong.properties and it is a class
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/"+fileName);
		prop.load(fis);
		//String browserName=System.getProperty("browser");
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
	
	
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			
		     driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Program Files\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}


