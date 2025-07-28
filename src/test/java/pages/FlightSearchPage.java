package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSearchPage {

    WebDriver driver;

    @FindBy(id = "flightNumber")
    WebElement flightInput;

    @FindBy(id = "searchBtn")
    WebElement searchButton;

    public FlightSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize WebElements
    }

    public void searchByNumber(String number) {
        flightInput.clear();
        flightInput.sendKeys(number);
        searchButton.click();
    }

    public boolean verifyResult(String expectedText) {
        return driver.getPageSource().contains(expectedText);
    }
}
