package main.java.com.pagefactoy;

import org.openqa.selenium.By;

import main.java.com.reusbales.BasicWebOperations;

public class Resultpage {
	
	BasicWebOperations webOpertions=new BasicWebOperations();
	
	
	private By totalSearchResults=By.xpath("//*[@id=\"s-result-count\"]");
	
	
	
	
	
	public String totalSearchResults() throws Exception
	{
		String totalResults= webOpertions.getText(totalSearchResults);
		totalResults=totalResults.split(" ")[2];
		return totalResults;
	}
	
	
	public String getItemDetails(int row) throws Exception
	{
		row=row-1;
		final By selectSearchRow=By.xpath("//*[@id=\"result_"+row+"\"]/div/div/div/div[2]/div[1]");
		return webOpertions.getText(selectSearchRow);
	}
	
	public String getInternalItemDesc(int row) throws Exception
	{
		row=row-1;
		String internalDesc=webOpertions.getText(By.xpath("//*[@id='result_"+row+"']//div[@class='a-column a-span7']"));
		return internalDesc;
	}
}
