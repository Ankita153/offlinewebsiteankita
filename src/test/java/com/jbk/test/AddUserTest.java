package com.jbk.test;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.jbk.pages.AddUserPage;
import com.jbk.pages.LoginPage;



public class AddUserTest extends TestBase {

	LoginPage lp=null;
	AddUserPage ap=null;
	
	
	@BeforeSuite
    public void openBrowser() throws Exception{
		
		driver=initialization("config.properties");
		lp=new LoginPage(driver);
		ap=lp.navigatetoDashboardPage().navigatetoUsersPage().navigatetoAddUserPage();
		
	}
	
	
  @AfterSuite
	public void tearDown(){
		driver.close();
	}
	@Test(priority=1)
	public void addUser(){
		AssertJUnit.assertTrue(ap.addUserValid());
	}
	
	@Test(priority=2)
	public void checkLabels(){
	AssertJUnit.assertTrue(ap.getLabels());
	}
	@Test(priority=3)
	public void verifyStateList(){
		AssertJUnit.assertTrue(ap.getListOfStateOptions());
	}
	@Test(priority=4)
	public void verifyStateListThroughExcel() throws Exception{
		AssertJUnit.assertTrue(ap.getOptFromExcel());
	}
	

}
