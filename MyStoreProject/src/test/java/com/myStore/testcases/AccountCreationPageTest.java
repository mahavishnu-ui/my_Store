/**
 * 
 */
package com.myStore.testcases;

//import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.myStore.base.BaseClass;
import com.myStore.dataprovider.DataProviders;
import com.myStore.pageobjects.AccountCreationPage;
import com.myStore.pageobjects.HomePage;
import com.myStore.pageobjects.IndexPage;
import com.myStore.pageobjects.LoginPage;
import com.myStore.utility.Log;

/**
 * @author nagin
 *
 */
public class AccountCreationPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private AccountCreationPage acountCreationPage;
	private HomePage homePage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser ) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test( groups = "Sanity",dataProvider = "Email", dataProviderClass = DataProviders.class)
	public void verifyCreateAccountPageTest(String email) throws Throwable {
		Log.startTestCase("verifyCreateAccountPageTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		acountCreationPage=loginPage.createNewAccount(email);
		boolean result=acountCreationPage.VerifyAccdetails();
		Assert.assertTrue(result);
		Log.endTestCase("verifyCreateAccountPageTest");
	}
	
	
	
	}
