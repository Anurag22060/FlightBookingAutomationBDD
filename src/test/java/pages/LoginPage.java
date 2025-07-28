package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
        // Wait for username field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        // Read CAPTCHA value dynamically
        String captchaText = driver.findElement(By.id("code")).getText();  // ID may differ; check once
        driver.findElement(By.id("captcha")).clear();
        driver.findElement(By.id("captcha")).sendKeys(captchaText);

        // Click on Validate
        driver.findElement(By.id("captchaBtn")).click();

        // Handle alert if CAPTCHA is wrong
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert says: " + alert.getText());
            alert.accept(); // close the alert
            throw new RuntimeException("CAPTCHA failed. Login aborted.");
        } catch (TimeoutException e) {
            // No alert appeared — continue
        }

        // Continue to Login
        driver.findElement(By.id("login-submit")).click();
    }
}
