package Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7 {
    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // a & b. Open browser and navigate to site
            driver.get("https://alchemy.hguy.co/jobs/");

            // c. Click "Post a Job"
            driver.findElement(By.linkText("Post a Job")).click();

            // d. Fill job details
            driver.findElement(By.id("job_title")).sendKeys("Automation Test Engineer");

            driver.findElement(By.id("job_location")).sendKeys("Hyderabad");

            driver.findElement(By.id("job_description"))
                  .sendKeys("Looking for an Automation Test Engineer with Selenium experience.");

            driver.findElement(By.id("application"))
                  .sendKeys("jobs@alchemy.hguy.co");

            driver.findElement(By.id("company_name"))
                  .sendKeys("Alchemy Testing Services");

            // Click Preview
            driver.findElement(By.name("submit_job")).click();

            // e. Click Submit Listing
            WebElement submitListing = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.id("job_preview_submit_button"))
            );
            submitListing.click();

            // f. Verify job listing by going to Jobs page
            driver.findElement(By.linkText("Jobs")).click();

            boolean jobPosted = driver.getPageSource()
                                      .contains("Automation Test Engineer");

            if (jobPosted) {
                System.out.println("Job listing posted successfully");
            } else {
                System.out.println("Job listing not found");
            }

        } finally {
            // g. Close browser
            driver.quit();
        }
    }
}
