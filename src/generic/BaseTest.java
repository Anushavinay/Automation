package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Result.class)
abstract public class BaseTest implements IAutoConst {
	public WebDriver driver;
	String url =Utility.getPropertyValue(CONFIG_PATH, "URL");
	String duration = Utility.getPropertyValue(CONFIG_PATH, "ITO");
	public long duration1 = Long.parseLong(duration);
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);	
	}
	
	@BeforeMethod
	public void openApp() {
	 driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(duration1, TimeUnit.SECONDS);
	 driver.get(url);
		
	}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}

}
