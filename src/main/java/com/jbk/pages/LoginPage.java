package com.jbk.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.ObjectRepository.LoginPageRepository;
import com.base.TestBase;
import com.utility.Utility;




public class LoginPage extends LoginPageRepository {
	
	
	WebDriver driver = null;
	
    public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public DashboardPage navigatetoDashboardPage() {
	
	Utility.sendkeys(email, "kiran@gmail.com");
	Utility.sendkeys(password, "123456");
	Utility.click(button);
	return new DashboardPage(driver);
}
	public RegisterPage navigatetoRegisterPage(){
		
		Utility.click(registerLink);
		
		return new RegisterPage(driver);
	}
	
	public boolean getURLOfBrowser() {
		
		String expected = "file:///F:/Offline%20Website/Offline%20Website/index.html";
		String actual= driver.getCurrentUrl();
		if(actual.equals(expected))
		{
			pageLog().info("Url is matched");
			return true;
		}
		else{
			pageLog().info("Url is  not matched");
			return false;
			}
	}
	public boolean getTitleOfBrowser() {
		String expected="JavaByKiran | Log in";
		String actual= driver.getTitle();
		if(actual.equals(expected))
		{
			pageLog().info("Title is matched");
			return true;
		}
		else{
				pageLog().info("Title is not matched");
				return false;
			}
	}
	public boolean getPlaceholders(){
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Email");
		expData.add("Password");
		
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement ele:placeholder){
			String text=ele.getAttribute("placeholder");
			actData.add(text);
		}
		if(actData.equals(expData)){
			pageLog().info("Placeholders are matched");
			return true;}
		else{
			pageLog().info("Placeholders are not matched");
			return false;}
	}
	
	public boolean getHeading1(){
		String expected="Java By Kiran";
		String actual=Utility.getText(head1);
		 if(actual.equals(expected))
				return true;
			else
				return false;
	}
	public boolean getHeadingCourses(){
		String expected="JAVA | SELENIUM | PYTHON";
		String actual=Utility.getText(head2);
	
		 if(actual.equals(expected))
				return true;
			else
				return false;
	}
	public boolean getHeadingSign(){
		String expected="Sign in to start your session";
		String actual=Utility.getText(signhead);
	
		 if(actual.equals(expected))
				return true;
			else
				return false;
	}
	
	public boolean displayImage(){
		if(logo.isDisplayed()==true)
		{
			pageLog().info("Logo is displayed");
			return true ;
		}
		else
		{
			pageLog().info("Logo is not displayed");
			return false ;
		}
	}
	public boolean loginSuccessfully(){
		
		Utility.sendkeys(uname, "kiran@gmail.com");
		Utility.sendkeys(pass, "123456");
		Utility.click(loginButton);
		
		String actual=driver.getTitle();
		String expected="JavaByKiran | Dashboard";
		//logout.click();
		if(actual.equals(expected)){	
			pageLog().info("Title is matched");
			return true;
			}
		else{	
			pageLog().info("Title is not matched");
			return false;
			}
	}
	public boolean getErrorMsgForBlankEntry(){

		Utility.sendkeys(uname, "");
		Utility.sendkeys(pass, "");
		Utility.click(loginButton);
			
			ArrayList<String>expData=new ArrayList<String>();
			expData.add("Please enter email.");
			expData.add("Please enter password.");
				
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement ele:errormsg){
			String text=ele.getText();
			actData.add(text);
		}
		 if(actData.equals(expData))
				return true;
			else
				return false;
	}
	public boolean getErrorMsgForInvalidEntry(){
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Please enter email as kiran@gmail.com");
		expData.add("Please enter password 123456");
		
			Utility.sendkeys(uname, "kk@gmail.com");
			Utility.sendkeys(pass, "yyy");
			Utility.click(loginButton);
			
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement ele:errormsg){
			String text=ele.getText();
			actData.add(text);
		}
		 if(actData.equals(expData))
				return true;
			else
				return false;
	}
	public boolean getTitleOfRegisterPg() {
		Utility.click(registerLink);
		
		String expected="JavaByKiran | Registration Page";
		String actual= driver.getTitle();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	
	
	
	
	
	}