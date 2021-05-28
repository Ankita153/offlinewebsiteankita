package com.jbk.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.jbk.pages.DashboardPage;
import com.jbk.pages.LoginPage;



public class LoginTest extends TestBase {
	WebDriver driver = null;
   public static LoginPage lp=null;
   DashboardPage dp=null;

	@BeforeSuite
	public void openBrower() throws IOException {

		
		driver = initialization("config.properties");
        lp=new LoginPage(driver);
	
	}

	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
	@Test(priority=1)
	public void checkUrl(){
		Assert.assertTrue(lp.getURLOfBrowser());
	}
	
	@Test(priority=2)
	public void checkLogo(){
		Assert.assertTrue(lp.displayImage());
	}
	@Test(priority=3)
	public void verifyTitle(){ 
		Assert.assertTrue(lp.getTitleOfBrowser());
	}
	@Test(priority=4)
	public void checkHeadingJavabykiran(){
		Assert.assertTrue(lp.getHeading1());
	}
	@Test(priority=5)
	public void verifyCoursesHeading(){
		Assert.assertTrue(lp.getHeadingCourses());
	}
	@Test(priority=6)
	public void verifySignInHeading()
	{
		Assert.assertTrue(lp.getHeadingSign());
	}
	@Test(priority=7)
	public void checkPlaceholderList(){
		Assert.assertTrue(lp.getPlaceholders());
	}
	
	@Test(priority=8)
	public void checkLoginSuccessfullyDone()
	{	
		Assert.assertTrue(lp.loginSuccessfully());
		dp.logoutBtn.click();
	}
	@Test(priority=9)
	public void verifyBlankEmailPasswordErrorMsg()
	{  
		Assert.assertTrue(lp.getErrorMsgForBlankEntry());
	}
	
	@Test(priority=10)
	public void verifyInvalidLoginEntryErrorMessage()
	{
		Assert.assertTrue(lp.getErrorMsgForInvalidEntry());
	}
	
	@Test(priority=11)
	public void checkRegistrationTitle()
	{
		Assert.assertTrue(lp.getTitleOfRegisterPg());
	}
		
}

