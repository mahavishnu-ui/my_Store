package com.myStore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actiondtiver.Action;
import com.myStore.base.BaseClass;

public class AccountCreationPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
	private WebElement VerifyAccdetails ;
	
	@FindBy(id = "uniform-id_gender1")
	private WebElement mr;
	
//	@FindBy(id = "id_gender2")
	@FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[2]/label")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;

	@FindBy(name = "firstname")
	private WebElement customerNirstName;

	@FindBy(name = "lastname")
	private WebElement customerLastName;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(name = "address1")
	private WebElement address;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "id_state")
	private WebElement state;

	@FindBy(name = "postcode")
	private WebElement postCode;

	@FindBy(name = "id_country")
	private WebElement country;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "phone_mobile")
	private WebElement mobile;

	@FindBy(name = "alias")
	private WebElement ref;

	@FindBy(name = "submitAccount")
	private WebElement registerBtn;

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year,
			String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone) throws Throwable {
		
		if(gender.equalsIgnoreCase("Mr")) {
			action.click(getDriver(), mr);
		} else {
			action.click(getDriver(), mrs);
		}
		
		action.type(firstName, fName);
		action.type(lastName, lName);
		action.type(passWord, pswd);
		action.selectByValue(days, day);
		action.selectByValue(months, month);
		action.selectByValue(years, year);
		action.type(companyName, comPany);
		action.type(address, addr);
		action.type(city, cityString);
		action.selectByVisibleText(stateName, state);
		action.type(postCode, zip);
		action.selectByVisibleText(countryName, country);
		action.type(mobile, mobilePhone);
		
		
		
	}
	
	public boolean VerifyAccdetails()
	{
		return  action.isDisplayed(getDriver(), VerifyAccdetails);
		
		
	}

	public HomePage validateRegistrationButton() {
		
		action.click(getDriver(), registerBtn);
		return new HomePage();
	}

		
	
	
	
}