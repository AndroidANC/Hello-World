package com.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.test.base.BaseClass;

public class login extends BaseClass{
	
	//@FindBy(name="txtUsername")
	@FindBy(how = How.NAME , using ="txtUsername")
	WebElement username;

	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement SubmitBtn;
	
	public login()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/*public String UserName(String username)
	{
		username.sendKeys(username);
	}*/
}
