package main.java.com.reusbales;



import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverStartUp {
	
	public static WebDriver driver;
	public static BasicWebOperations webOpertions=new BasicWebOperations();
	
	static ResourceBundle configProperties=ResourceBundle.getBundle("main.resources.config");
	
	@BeforeClass
	public static void iniliatizeDriver() throws Exception
	
	{
		
		if(configProperties.getString("browser").equalsIgnoreCase("CHROME")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			ChromeOptions chromeOptions=new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		if(configProperties.getString("browser").equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		    driver=new FirefoxDriver();
		    driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	}
	

}
