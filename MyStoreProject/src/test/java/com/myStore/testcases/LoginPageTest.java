/**
 * 
 */
package com.myStore.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.myStore.base.BaseClass;
import com.myStore.dataprovider.DataProviders;
import com.myStore.pageobjects.HomePage;
import com.myStore.pageobjects.IndexPage;
import com.myStore.pageobjects.LoginPage;
import com.myStore.utility.Log;


/**
 * @author nagin
 *
 */

public class LoginPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
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
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Log.info("Enter Username and Password");
	  //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    homePage=loginPage.login(uname,pswd,homePage);
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.info("Login is Sucess");
	    Log.endTestCase("loginTest");
	}

}