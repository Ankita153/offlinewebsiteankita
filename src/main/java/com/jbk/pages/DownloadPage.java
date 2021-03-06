package com.jbk.pages;



import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ObjectRepository.DownloadPageRepository;
import com.utility.ExcelUtility;
import com.utility.Utility;



public class DownloadPage extends DownloadPageRepository {
	WebDriver driver;

	public DownloadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean getURLOfBrowser() {
		String expected = "file:///F:/Offline%20Website/Offline%20Website/pages/examples/downloads.html";
		String actual= driver.getCurrentUrl();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getTitleOfBrowser() {
		String expected="JavaByKiran | Downloads";
		String actual= driver.getTitle();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getHeading() {
		String expected="Downloads";
		String actual=Utility.getText(heading);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getSubHeading() {
		String expected="Downloads List";
		String actual=Utility.getText(subheading);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getFooter() {
		String expected="Design for Selenium Automation Test V 2.3.0\n"
				+ "Copyright ? 2005-2019 JavaByKiran. All rights reserved.";
		String actual=Utility.getText(footer);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getRightCornerHeading() {
		String expected="Home Downloads";
		String actual=Utility.getText(homeUserRight);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getStatus() {
		String expected="Online";
		String actual=Utility.getText(onlineStatus);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getheadJBK() {
		String expected="Java By Kiran";
		String actual=Utility.getText(jbk);
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
	public boolean imageDisplay() {
		return image.isDisplayed();
	}
	
	public boolean checkHeader() throws Exception {
		ArrayList<String> exp=ExcelUtility.getTableColumnData("Data.xlsx","downloadHeader",0);
		ArrayList<String> actData = Utility.getActualListOfHeadingOfTable(headers);
	
		if(actData.equals(exp))
			return true;
		else
			return false;
	}
	public boolean getNavigator() {
		
		ArrayList<String> expNavigationMenuText=Utility.getExpectedNavigation();
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : navigator) {
			String text = element.getText();
			actData.add(text);
		}
		if(actData.equals(expNavigationMenuText))
			return true;
		else
			return false;
	}
	public boolean getNmFor32bit() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Google Chrome");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : bit32s) {
			if (ele.getText().equals("32bit")) {
				String name = vendors.get(i).getText();

				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getNmFor64bit() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Google Chrome");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : bit64s) {
			if (ele.getText().equals("64bit")) {
				String name = vendors.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getNmForCommonbtnAndOther() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Selenium Server Standalon Jar");
		expData.add("Selenium Server Source Jar");
		expData.add("Google Chrome Driver");
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : commonCol) {
			if (ele.getText().contains("Common") || ele.getText().contains("2.52.0")) {
				String name = vendors.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getNmForCommonColBlankData() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Google Chrome");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : commonCol) {
			String text = ele.getText();
			if (text.equals("")) {
				String name = vendors.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getNmForVersion76() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Google Chrome");
		expData.add("Google Chrome Driver");
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : versions) {
			String text = ele.getText();
			if (text.equals("76.0")) {
				String name = vendors.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getNmForOfficialWeb() {
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Selenium Server Standalon Jar");
		expData.add("Selenium Server Source Jar");
		expData.add("Google Chrome");
		expData.add("Google Chrome Driver");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		for (WebElement ele : official) {
			String text = ele.getText();
			if (text.equals("Official Website"))
			{
				String name = vendors.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean completeDownloadsTable() throws Exception
	{
		ArrayList <String>actData=Utility.getActualDataOfTableFully(headers, tableData);
		ArrayList <String>expData=ExcelUtility.getTableDataFully("Data.xlsx","download");
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;
	}

}
