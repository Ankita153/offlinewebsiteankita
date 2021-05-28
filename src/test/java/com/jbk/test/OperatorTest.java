package com.jbk.test;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.base.TestBase;



import com.jbk.pages.LoginPage;
import com.jbk.pages.OperatorPage;

public class OperatorTest extends TestBase{
	
	
	
	
	
	
	LoginPage lp = null;
    OperatorPage op = null;

	@BeforeMethod
	public void openBrowser() throws Exception {
		driver = initialization("config.properties");
		lp = new LoginPage(driver);
		op=lp.navigatetoDashboardPage().navigatetoOperatorPage();
		
	}
	
	
  @AfterMethod
  public void tearDown(){
		driver.close();
  }
		
		
		
	@Test (priority=1)
	public void verifycontactNoLength()
	{
		Assert.assertTrue(op.contactNoLength());
	}
	
	@Test (priority=2)
	public void verifyNamesInAlphabeticalOrder()
	{
		Assert.assertTrue(op.namesInAlphabeticalOrder());
	}
	
	@Test (priority=3)
	public void verifyPrefferedWayToConnect_WhatsApp()
	{
		Assert.assertTrue(op.prefferedWayToConnect_WhatsApp());
	}
	
	@Test (priority=4)
	public void verifyPrefferedWayToConnect_PhoneCall()
	{
		Assert.assertTrue(op.prefferedWayToConnect_PhoneCall());
	}
	
	@Test (priority=5)
	public void verifyPrefferedWayToConnect_WhatsApp_And_PhoneCall()
	{
		Assert.assertTrue(op.prefferedWayToConnect_WhatsApp_And_PhoneCall());
	}
	
	@Test (priority=6)
	public void verifyPrefferedWayToConnect_WhatsApp_ButNot_PhoneCall()
	{
		Assert.assertTrue(op.prefferedWayToConnect_WhatsApp_ButNot_PhoneCall());
	}
	
	@Test (priority=7)
	public void verifyFacultiesAvailableOnMonday()
	{
		Assert.assertTrue(op.facultiesAvailableOnMonday());
	}
	
	@Test (priority=8)
	public void verifyFacultiesNotAvailableOnSunday()
	{
		Assert.assertTrue(op.facultiesNotAvailableOnSunday());
	}
	
	/*@AfterSuite
	public void CloseBrowser()
	{
		driver.quit();
	}
*/
}
