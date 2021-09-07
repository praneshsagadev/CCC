package stepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import hooks.HooksImplement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class StepImplementation {

	WebDriver driver;

	@Given("^I load the \"(.+)\"$")
	public void loadTheUrl(String url) {
 driver =	HooksImplement.driverInitialize();
		driver.get(url);
	}

	@Then("^I enter username and password into the respective field$")

	public void enterUsernameAndPassword(DataTable dataTable) throws InterruptedException {
		List<List<String>> data = dataTable.asLists();

		for (int i = 1; i < data.size(); i++) {
			for (int j = 0; j < data.get(i).size(); j++) {

				String value = data.get(i).get(j);

				if (j == 0) {

					WebElement user = driver.findElement(By.id("txtUsername"));

					user.clear();
					user.sendKeys(value);
				}

				if (j == 1) {
					WebElement pass = driver.findElement(By.id("txtPassword"));

					pass.clear();
					pass.sendKeys(value);

				}
			}

		}

		Thread.sleep(3000);
	}

	@Then("^I click element1 \"(.+)\"$")
	public void clickButton1(String element) {

		driver.findElement(By.xpath(element)).click();
	}

	@Then("^I click element2 \"(.+)\"$")
	public void clickButton2(String element) {
		driver.findElement(By.xpath(element)).click();
	}

	@Then("^I enter \"(.+)\" into element \"(.+)\"$")
	public void enterName(String text, String element) {
		WebElement input = driver.findElement(By.id(element));

		// input.clear();
		input.click();
		input.sendKeys(text);
	}

	@And("^I click element3 \"(.+)\"$")
	public void clickButton3(String element) {
		driver.findElement(By.xpath(element)).click();
		
	}
	@AfterStep
	public void tearDown(Scenario s) {
		
	s.attach(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png","image");
	}

}
