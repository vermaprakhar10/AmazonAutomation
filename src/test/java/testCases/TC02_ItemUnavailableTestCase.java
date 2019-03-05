package test.java.testCases;





import org.junit.Test;


import main.java.com.reusbales.Components;
import main.java.com.reusbales.WebDriverStartUp;

public class TC02_ItemUnavailableTestCase extends WebDriverStartUp {
	
	Components component=new Components();
	
	

	@Test
	public void TC01() throws Exception
	{		
		component.launchURL();
		component.selectCategories("Books");
		component.searchItem("data catalog");
		component.getTotalSearchResults();
		component.getItemDescription(1);
		
	}
	
	
	
}
