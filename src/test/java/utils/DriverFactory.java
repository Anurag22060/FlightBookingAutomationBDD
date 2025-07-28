package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initializeDriver() {
        if (driver == null) {
            // Setup ChromeDriver automatically using WebDriverManager
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // Configure browser window and waits
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
