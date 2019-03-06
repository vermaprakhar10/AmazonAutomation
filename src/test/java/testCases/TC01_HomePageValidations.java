package test.java.testCases;





import java.util.LinkedHashMap;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;


import main.java.com.reusbales.Components;
import main.java.com.reusbales.ExcelFunctions;
import main.java.com.reusbales.WebDriverStartUp;

public class TC01_HomePageValidations extends WebDriverStartUp {
	
	Components component=new Components();
	
	static String TC001Status="FAIL";
	static String TC002Status="FAIL";
	static String TC003Status="FAIL";
	
	

	@Test
	public void TC01() throws Exception
	{		
		component.launchURL();
		component.selectCategories("Books");
		component.searchItem("data catalog");
		component.getTotalSearchResults();
		component.getItemDescription(1);
		
	
		
		// Assuming Item Should Have Estimated DeliveryDate
		
		if((component.isDeliveryDataEstimated())==true) {
			TC001Status="PASS";
		}
		
		//Book should be available in Paperback
		LinkedHashMap<String, String> platformMap=component.returnPlatformAvailability();
		
		if(platformMap.get("Paperback").equals("true")) {
			TC002Status="PASS";
		}
		
		//if Item is Availale then price should be displayed
		try {
			String price=component.getAllEditionsPrice();
			TC003Status="PASS";
		}catch (Exception e) {
			Assert.fail("Price Not Displayed");
		}
	}
	
	@AfterClass
	public static void PrintResult() throws Exception
	{
		ExcelFunctions.writeExcel("", "Results", new String[] {"TC01_DeliveryTextValidation",TC001Status});
		ExcelFunctions.writeExcel("", "Results", new String[] {"TC02_IsPaperBackAvailable",TC002Status});
		ExcelFunctions.writeExcel("", "Results", new String[] {"TC02_IsPriceDisplayed",TC003Status});
	}
	
}
