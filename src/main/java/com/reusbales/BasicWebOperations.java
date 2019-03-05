package main.java.com.reusbales;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasicWebOperations extends WebDriverStartUp{
	public final static Logger LOGGER = Logger.getLogger(BasicWebOperations.class.getName());
	
	WebElement webElement=null;


	public void click(By locator) throws Exception
	{
		webElement=driver.findElement(locator);
		webElement.click();
		LOGGER.info("Clicked: "+locator);
	
	}
	
	public void enterText(By locator,String data) throws Exception
	{
		webElement=driver.findElement(locator);
		webElement.click();
		LOGGER.info("Clicked: "+locator);
		webElement.clear();
		LOGGER.info("Cleared: "+locator);
		webElement.sendKeys(data);
		LOGGER.info("Entered value "+data+" at "+locator);
		
	}
	public void waitUntilElementisDisplayed(By locator) throws Exception
	{
		
	}
	
	public boolean isElementDisplayed(By locator) throws Exception
	{
	
		int size=driver.findElements(locator).size();
		if(size==0) {
			LOGGER.info(locator+" Visibilty is: "+"false");
			return false;
		}else {
			LOGGER.info(locator+" Visibilty is: "+"true");
			return true;
		}
		
	}
	
	public void sendENTER(By locator) throws Exception
	{
		webElement=driver.findElement(locator);
		webElement.sendKeys(Keys.ENTER);
		LOGGER.info("Pressed ENTER in: "+locator);
	}
	
	public void selectFromDropDown(By locator,String value) throws Exception
	{
		webElement=driver.findElement(locator);
		Select categoryDropBox=new Select(webElement);
		categoryDropBox.selectByVisibleText(value);
		LOGGER.info("Selected Drop Menu: "+locator+" is "+value);
		
	}
	
	public String getText(By locator) throws Exception
	{
		webElement=driver.findElement(locator);
		String text= webElement.getText();
		LOGGER.info("value in: "+locator+" is "+text);
		return text;
				
	}
}
