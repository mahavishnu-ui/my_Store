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
import com.myStore.pageobjects.IndexPage;
import com.myStore.pageobjects.SearchResultPage;
import com.myStore.utility.Log;


/**
 * @author nagin
 *
 */

public class SearchResultPageTest extends BaseClass {
	private IndexPage index;
	private SearchResultPage searchResultPage;
	
	//@Parameters("browser")
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser ) {
		launchApp(browser); 
	}

	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvailabilityTest(String productName) throws Throwable {
		Log.startTestCase("productAvailabilityTest");
		index= new IndexPage();
		searchResultPage=index.searchProduct(productName);
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("productAvailabilityTest");
	}

}