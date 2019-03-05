package main.java.com.reusbales;



import java.awt.print.Paper;
import java.util.LinkedHashMap;


import org.junit.Assert;


import main.java.com.pagefactoy.AmazonHomePage;
import main.java.com.pagefactoy.Resultpage;

public class Components extends WebDriverStartUp {
	
	static String parseData;
	
	AmazonHomePage amazonHomePage = new AmazonHomePage();
	Resultpage resultsPage=new Resultpage();
	/**
	 * Method Launches the any Given Web URL as mentioned in the config.properties
	 * @throws Exception
	 */
	public void launchURL() throws Exception {
		String URI = configProperties.getString("url");
		driver.get(URI);
	}

	
	/**
	 * Method select the catergory as passed in the Argument
	 * @throws Exception
	 */
	public void selectCategories(String category) throws Exception {
		try {
			amazonHomePage.selectCategory(category);
		}catch (Exception e) {
			throw new Exception("Failed in Selecting "+category+" from the Category DropDown");
		}
	}

	
	public void searchItem(String itemToSearch) throws Exception {
		try {
			amazonHomePage.enterSearchResults(itemToSearch);
		}catch (Exception e) {
			throw new Exception("Failed to search Data in Amazon Search bar");
		}
	}
	
	
	public String  getTotalSearchResults() throws Exception
	{
		String totalResult=resultsPage.totalSearchResults();
		if(Integer.parseInt(totalResult)<=0) {
			Assert.fail("0 test Results Found");
		}
		System.out.println("Search Assertion Passed");
		return totalResult;
	}
	
	
	public void getItemDescription(int resultIndex) throws Exception
	{
		System.out.println(resultsPage.getItemDetails(resultIndex));
		parseInternalItemDesc(resultIndex);
	}
	
	
	public String parseInternalItemDesc(int resultIndex) throws Exception
	{
		parseData=resultsPage.getInternalItemDesc(1).trim();	
		String parseData=resultsPage.getInternalItemDesc(resultIndex).trim();	
		return parseData;
	}
	
	
	public boolean isDeliveryDataEstimated() throws Exception
	{
		if(parseData.contains("Get it by")) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public LinkedHashMap<String, String> returnPlatformAvailability() throws Exception
	{
		LinkedHashMap<String, String> hMap=new LinkedHashMap<String, String>();
		if(parseData.contains("Paperback")) {
			hMap.put("Paperback", "true");
		}else {
			hMap.put("Paperback", "false");
		}
		if (parseData.contains("Hardcover")) {
			hMap.put("Hardcover", "true");
		} else {
			hMap.put("Hardcover", "true");
		}
		if (parseData.contains("Kindle")) {
			hMap.put("Kindle", "true");
		} else {
			hMap.put("Kindle", "false");
		}
		return hMap;
	}
	
	public void getAllEditionsPrice() throws Exception
	{
		LinkedHashMap<String, String> hMap=returnPlatformAvailability();
		
		if(hMap.get("Paperback").equals("true")) {
			
		}
	}

}
