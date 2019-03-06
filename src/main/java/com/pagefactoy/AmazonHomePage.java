package main.java.com.pagefactoy;




import org.openqa.selenium.By;
import main.java.com.reusbales.WebDriverStartUp;

public class AmazonHomePage extends WebDriverStartUp {
	
	//Icons
	private By iconamznavigation=By.id("nav-logo");
	
	//dropDowns
	
	private By amzDropDown=By.xpath("//*[@id='searchDropdownBox']");
//	private By amzDropDown=By.xpath("//div[@class='nav-search-dropdown searchSelect']");
	
	
	//Buttons
	private By searchTxtField=By.xpath("//*[@id='twotabsearchtextbox']");
	
	
	public boolean isAmazonNavLogoVisible() throws Exception
	{
		return webOpertions.isElementDisplayed(iconamznavigation);
	}
	
	public void selectCategory(String value) throws Exception
	{
		webOpertions.selectFromDropDown(amzDropDown, value);

	}
	
	public void enterSearchResults(String value) throws Exception
	{
		webOpertions.enterText(searchTxtField, value);
		webOpertions.sendENTER(searchTxtField);
	}
	
}
