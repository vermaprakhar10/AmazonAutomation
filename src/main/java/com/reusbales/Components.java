package main.java.com.reusbales;



import java.util.ArrayList;
import java.util.Arrays;
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

	/**
	 * Method enters the search parameter in the search bar
	 * @throws Exception
	 */
	public void searchItem(String itemToSearch) throws Exception {
		try {
			amazonHomePage.enterSearchResults(itemToSearch);
		}catch (Exception e) {
			throw new Exception("Failed to search Data in Amazon Search bar");
		}
	}
	
	/**
	 * Method retruns the total search Results
	 * @throws Exception
	 */
	public String  getTotalSearchResults() throws Exception
	{
		String totalResult=resultsPage.totalSearchResults();
		if(Integer.parseInt(totalResult)<=0) {
			Assert.fail("0 test Results Found");
		}
		System.out.println("Search Assertion Passed");
		return totalResult;
	}
	
	/**
	 * Returns the Item Description of based on the Item Indexs
	 * @throws Exception
	 */
	public String getItemDescription(int resultIndex) throws Exception
	{
		String text=resultsPage.getItemDetails(resultIndex);
		parseInternalItemDesc(resultIndex);
		return text;
	}
	
	/**
	 *  Returns the internal Product Description
	 * @throws Exception
	 */
	public String parseInternalItemDesc(int resultIndex) throws Exception
	{
		parseData=resultsPage.getInternalItemDesc(1).trim();	
		String parseData=resultsPage.getInternalItemDesc(resultIndex).trim();	
		return parseData;
	}
	
	
	/**
	 *  Check whether the Delivery Date is Estimated
	 *  @return Boolean
	 * @throws Exception
	 */
	public boolean isDeliveryDataEstimated() throws Exception
	{
		if(parseData.contains("Get it by")) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 *  Retruns Availble Platform Type ie Paperback Kindle or Hardcover
	 *  @return {@link LinkedHashMap}
	 * @throws Exception
	 */
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
	
	
	public String getAllEditionsPrice() throws Exception
	{
		LinkedHashMap<String, String> hMap=returnPlatformAvailability();
		String price="";
		
		ArrayList<String> convertToList=new ArrayList<>(Arrays.asList(parseData.split(" ")));
		if(hMap.get("Paperback").equals("true")) {
			price=convertToList.get(1);
		}
		
	return price;
	}

}
