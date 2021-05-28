package com.jbk.test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.jbk.pages.DashboardPage;

import com.jbk.pages.LoginPage;
import com.jbk.pages.UsefulLinksPage;


public class UsefulLinkTest extends TestBase {
	
	WebDriver driver ;
	LoginPage lp = null;
	DashboardPage dp = null;
	UsefulLinksPage  ufp = null;

	@BeforeSuite
	public void openBrowser() throws Exception {
		driver = initialization("config.properties");
		lp = new LoginPage(driver);
		ufp=lp.navigatetoDashboardPage().navigatetoUsefulLinkPage();
		
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void verifyUrl() {
		Assert.assertTrue(ufp.getURLOfBrowser());
	}

	@Test(priority = 2)
	public void verifyTitle() {
		Assert.assertTrue(ufp.getTitleOfBrowser());
	}

	@Test(priority = 3)
	public void verifyHeading() {
		Assert.assertTrue(ufp.getHeading());
	}

	@Test(priority = 4)
	public void verifySubHeading() {
		Assert.assertTrue(ufp.getSubHeading());
	}

	@Test(priority = 5)
	public void verifyFooter() {
		Assert.assertTrue(ufp.getFooter());
	}

	@Test(priority = 6)
	public void checkNavigation() {
		Assert.assertTrue(ufp.getNavigator());
	}

	@Test(priority = 7)
	public void checkRightCornerHeading() {
		Assert.assertTrue(ufp.getRightCornerHeading());
	}

	@Test(priority = 8)
	public void checkLeftCornerHeading() {
		Assert.assertTrue(ufp.getNmKiran());
	}

	@Test(priority = 9)
	public void verifyUserStatus() {
		Assert.assertTrue(ufp.getStatus());
	}

	@Test(priority = 10)
	public void checkImage() {
		Assert.assertTrue(ufp.imageDisplay());
	}

	@Test(priority = 11)
	public void leftCornerHeading() {

		Assert.assertTrue(ufp.getheadJBK());
	}

	@Test(priority = 12)
	public void checkHeadersOfTable() throws Exception {

		Assert.assertTrue(ufp.checkHeader());
	}

	@Test(priority = 13)
	public void verifyDataPresentInTable() throws Exception {
		Assert.assertTrue(ufp.getUsefulLinkTableRowdata());
	}

	@Test(priority = 14)
	public void verifyClickGO() throws Exception {
		Assert.assertTrue(ufp.clickGO());
	}

	@Test(priority = 15)
	public void verifyClickGoExcel() throws Exception {
		Assert.assertTrue(ufp.clickGoExcel());
	}

	@Test(priority = 16)
	public void verifyComplete_UsefulLinksTable() throws Exception {
		Assert.assertTrue(ufp.complete_UsefulLinksTable());
	}

	@Test(priority = 17)
	public void verifyContentForClickGo() {
		Assert.assertTrue(ufp.contentForClickCol());
	}

}
