package Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6 {
    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // a. Open site and navigate to Jobs page
            driver.get("https://alchemy.hguy.co/jobs/");
            driver.findElement(By.linkText("Jobs")).click();

            // b. Search for a job
            WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("search_keywords"))
            );
            searchBox.sendKeys("Developer");

            // Click Search button
            driver.findElement(By.cssSelector("input[value='Search Jobs']")).click();

            // Wait for job listings
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("ul.job_listings li"))
            );

            // c. Click first job listed
            driver.findElement(By.cssSelector("ul.job_listings li a")).click();

            // d. Click Apply button
            WebElement applyButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".application_button, .application_details a"))
            );
            applyButton.click();

            // Get application email
            WebElement email = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".application_details a"))
            );

            System.out.println("Apply using email:");
            System.out.println(email.getText());

        } finally {
            // e. Close browser
            driver.quit();
        }
    }
}
