package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksImplement {

	
@Before
	public  static WebDriver  driverInitialize() {

		WebDriverManager.chromedriver().setup();

		WebDriver	driver = new ChromeDriver();

		driver.manage().window().maximize();
		return driver;
		

	}

}
