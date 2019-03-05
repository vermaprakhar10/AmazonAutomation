package test.java.testCases;





import java.util.LinkedHashMap;

import org.junit.AfterClass;
import org.junit.Test;


import main.java.com.reusbales.Components;
import main.java.com.reusbales.WebDriverStartUp;

public class TC01_HomePageValidations extends WebDriverStartUp {
	
	Components component=new Components();
	
	

	@Test
	public void TC01() throws Exception
	{		
		component.launchURL();
		component.selectCategories("Books");
		component.searchItem("data catalog");
		component.getTotalSearchResults();
		component.getItemDescription(1);
		

		
		// Assuming Item Should Have Estimated DeliveryDate
		boolean deliveryDate=component.isDeliveryDataEstimated();
		
		//Book should be available in Paperback
		LinkedHashMap<String, String> platformMap=component.returnPlatformAvailability();
		
		//if Item is Availble then price should be displayed
		
	}
	
	@AfterClass
	public void PrintResult() throws Exception
	{
		
	}
	
}
