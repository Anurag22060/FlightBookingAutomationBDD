package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;

import pages.FlightSearchPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class FlightSearchSteps {

    WebDriver driver;
    FlightSearchPage searchPage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        driver = DriverFactory.initializeDriver();
        loginPage = new LoginPage(driver);
        searchPage = new FlightSearchPage(driver);
    }

    @Given("I launch the flight booking application")
    public void launchApp() {
        driver.get(ConfigReader.get("baseUrl"));
    }

    @And("I login with username {string} and password {string}")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @When("I search for flight number {string}")
    public void searchFlight(String flightNo) {
        searchPage.searchByNumber(flightNo);
    }

    @Then("I should see result containing {string}")
    public void verifyResult(String flightNo) {
        Assert.assertTrue(searchPage.verifyResult(flightNo));
    }
}
