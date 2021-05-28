package com.jbk.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.ObjectRepository.DashboardPageRepository;
import com.base.TestBase;
import com.utility.ExcelUtility;
import com.utility.Utility;


public class DashboardPage extends DashboardPageRepository  {
	WebDriver driver;
	
	

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		

	}
	
	
	public UsersPage navigatetoUsersPage(){
		Utility.click(userBtn);
		return new UsersPage(driver);
		
	}
	
	public DownloadPage navigatetoDownloadPage(){
		Utility.click(downloadsBtn);
		return new DownloadPage(driver);
		
	}
	
	public OperatorPage navigatetoOperatorPage(){
		Utility.click(operatorBtn);
		return new OperatorPage(driver);
		
	}
	
	public UsefulLinksPage navigatetoUsefulLinkPage(){
		Utility.click(usefulLinkBtn);
		return new UsefulLinksPage(driver);
		
	}
	
	
	
	
	public boolean url()
	{
		String expectedUrl = "file:///F:/Offline%20Website/Offline%20Website/pages/examples/dashboard.html" ; 
		String actualUrl = driver.getCurrentUrl() ;
		
		if(actualUrl.equals(expectedUrl))
		{
			pageLog().info("Url is matched");
			return true ;
		}
		else
		{
			pageLog().info("Url is not matched");
			return false ;
		}
	}
	public boolean title() 
	{ 	
		String expectedTitle = "JavaByKiran | Dashboard" ; 
		String actualTitle = driver.getTitle() ;
		
		if(actualTitle.equals(expectedTitle))
		{
			pageLog().info("Title is matched");
			return true ;
		}
		else 
		{
			pageLog().info("Title not matched");
			return false ;
		}		
	}
	public boolean userImage() 
	{	
		if(image.isDisplayed()==true)
		{
			pageLog().info("User Image is displayed");
			return true ;
		}
		else
		{
			pageLog().info("User Image is not displayed");
			return false ;
		}
	}
	public boolean cornerHeading() 
	{ 	
		String actCornerHeading = Utility.getText(heading1);
		String expCornerHeading = "Java By Kiran" ;
		
		if(actCornerHeading.equals(expCornerHeading))
		{
			pageLog().info("Corner Heading is matched");
			return true ;
		}
		else 
		{
			pageLog().info("Corner Heading not matched");
			return false ;
		}
	}
	
	public boolean getStatus() {
		String expected="Online";
		String actual= Utility.getText(onlineStatus);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getSeq() {
		String expected="Home Dashboard";
		String actual=Utility.getText(seqHD);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getNmKiran() {
		String expected="Kiran";
		String actual=Utility.getText(kiranHead);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getCourses() {
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Selenium");
		expData.add("Java / J2EE");
		expData.add("Python");
		expData.add("Php");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : courses) {
			String text = ele.getText();
			actData.add(text);
		}
		if(actData.equals(expData))
			return true;
		else 
			return false;
	}

	public boolean getSubCourses() {
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Automation Testing");
		expData.add("Software Development");
		expData.add("Data Science");
		expData.add("Web Development");
		
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : subcourse) {
			String text = ele.getText();
			actData.add(text);
		}
		if(actData.equals(expData))
			return true;
		else 
			return false;
	}

	public boolean getDashHeading() {
		String actMainHeading =Utility.getText(dashHeading);
		String expMainHeading = "Dashboard Courses Offered" ;
		
		if(actMainHeading.equals(expMainHeading))
		{
			pageLog().info("Main Heading is matched");
			return true ;
		}
		else 
		{
			pageLog().info("Main Heading not matched");
			return false ;
		}
	}

	public boolean usefulLinkMenu() {
		Utility.click(usefulLinkBtn);
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Useful Links" ;
		
		Utility.click(dashboard);
	
		if(actTitle.equals(expTitle))
		{
			pageLog().info("Useful Links Menu is working properly");
			return true ;
		}
		else 
		{
			pageLog().info("Useful Links Menu is not working properly");
			return false ;
		}
	}
	public boolean downloadsMenu () 
	{	Utility.click(downloadsBtn);
	
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Downloads" ;
		
		Utility.click(dashboard);		
		
		if(actTitle.equals(expTitle))
		{
			pageLog().info("Downloads Menu is working properly");
			return true ;
		}
		else 
		{
			pageLog().info("Downloads Menu is not working properly");
			return false ;
		}
	}

	

	public boolean usersMenu() {
		Utility.click(userBtn);
	
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | User" ;
		
		Utility.click(dashboard);	
		
		if(actTitle.equals(expTitle))
		{
			pageLog().info("Users Menu is working properly");
			return true ;
		}
		else 
		{
			pageLog().info("Users Menu is not working properly");
			return false ;
		}
	}

	
	public boolean operatorsMenu () 
	{	Utility.click(operatorBtn);
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Operators" ;
		
		Utility.click(dashboard);		
		
		if(actTitle.equals(expTitle))
		{
			pageLog().info("Operators Menu is working properly");
			return true ;
		}
		else 
		{
			pageLog().info("Operators Menu is not working properly");
			return false ;
		}
	}

	public boolean verifyRightCornerLogOutLink() 
	{	Utility.click(logoutBtn);
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Log in" ;
		
		if(actTitle.equals(expTitle))
		{
			return true ;
		}
		else 
		{
			return false ;
		}
	}

	public boolean getAllWindow() {
		
		Set <String> expNewWindowUrls = new HashSet <String>();
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf");
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/java-j2ee-syllabus-jbk.pdf");		
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/python-syllabus.pdf");
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/dashboard.html#");
		
		Set<String> actNewWindowUrls=Utility.getWindowHandleCheckingUrl(driver, moreinfo);

		if(actNewWindowUrls.equals(expNewWindowUrls))
		return true;
		else
			return false;
	}

	public boolean getFooter() {
		String expected = "Design for Selenium Automation Test V 2.3.0\n" +"Copyright © 2005-2019 JavaByKiran. All rights reserved.";

		String actual= footer.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	
	public boolean getMoreInfoLinks() throws Exception {

		ArrayList <String>expMoreInfoTags=ExcelUtility.getDataOfAnyColumn("Data.xlsx","moreinfo",0);
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : moreinfo) {
			String text = ele.getText();
			actData.add(text);
		}
		if(actData.equals(expMoreInfoTags))
			return true;
		else 
			return false;
	}

	public boolean getNavigatorLinks() {
		ArrayList<String> expNavigationMenuText=Utility.getExpectedNavigation();
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : navigator) {
			String text = ele.getText();
			pageLog().info(text);
			actData.add(text);
		}
		if(actData.equals(expNavigationMenuText))
			return true;
		else 
			return false;
	}
	public boolean jbk_Link () throws Exception 
	{	String expWindowTitle = "Java Classes in Pune | Selenium Training | Python Courses in pune";
		String actWindowTitle=Utility.getSingleWindowHandleVerifyTitle(driver, jbkLink);

		if(actWindowTitle.equals(expWindowTitle))
		{
			pageLog().info("New window title is matched");
			return true ;
		}
		else 
		{
			pageLog().info("New window title is not matched");
			return false ;
		}
	}
	public boolean courseHeadingExcel () throws Exception
	{
		ArrayList <String>actData = new ArrayList <String>();
		for (WebElement element : courses)
		{
			actData.add(element.getText());
		}
		ArrayList <String>expData =ExcelUtility.getDataOfAnyColumn("Data.xlsx","courses",0);
	
		if(actData.equals(expData))
			return true ;
		else 
			return false ;
	}
	

	public boolean courseSubHeadingExcel () throws Exception
	{
		ArrayList <String>actData = new ArrayList <String>();
		ArrayList <String>expData =ExcelUtility.getDataOfAnyColumn("Data.xlsx","subcourses",0);
		
		for (WebElement element : subcourse)
		{
			actData.add(element.getText());
		}
		
		if(actData.equals(expData))
			return true ;
		else 
			return false ;
	}
}
	    

	






