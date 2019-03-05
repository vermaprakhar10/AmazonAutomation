package test.java.testCases;





import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import main.java.com.reusbales.Components;
import main.java.com.reusbales.ExcelFunctions;
import main.java.com.reusbales.WebDriverStartUp;

public class TC02_ItemUnavailableTestCase extends WebDriverStartUp {
	static String TC003_Status="FAIL";
	
	Components component=new Components();
	
	
	

	@Test
	public void TC01() throws Exception
	{		
		component.launchURL();
		component.selectCategories("Books");
		component.searchItem("data catalog");
		component.getTotalSearchResults();
		component.getItemDescription(1);
		String internalText=component.parseInternalItemDesc(1);
		if(!internalText.contains("Currently unavailable")) {
			TC003_Status="Item: "+component.getItemDescription(1)+" Should be Unavaiable";
			Assert.fail("Item: "+component.getItemDescription(1)+" Should be Unavaiable");
		}
		TC003_Status="PASS";
		
		
	}
	
	@AfterClass
	public static void PrintResult() throws Exception
	{
		ExcelFunctions.writeExcel("", "Results", new String[] {"TC03_NotAvailbleItemCheck",TC003_Status});
	}
	
}
