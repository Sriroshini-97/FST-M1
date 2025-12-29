package Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Activity9 {
    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(options);

        try {
            // a. Open browser & b. Navigate to backend
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://alchemy.hguy.co/jobs/wp-admin");

            // Login
            driver.findElement(By.id("user_login")).sendKeys("admin");   // valid username
            driver.findElement(By.id("user_pass")).sendKeys("admin");    // valid password
            driver.findElement(By.id("wp-submit")).click();

            // c. Click "Job Listings" from left menu
            driver.findElement(By.linkText("Job Listings")).click();

            // d. Click "Add New"
            driver.findElement(By.linkText("Add New")).click();

            // e. Fill job details
            String jobTitle = "Senior Automation Tester";

            driver.findElement(By.id("title")).sendKeys(jobTitle);
            driver.findElement(By.id("content"))
                  .sendKeys("This job listing is created using Selenium backend automation.");

            // f. Click Publish
            driver.findElement(By.id("publish")).click();

            // g. Verify job listing created
            boolean isPublished = driver.getPageSource().contains("Post published")
                                  || driver.getPageSource().contains("Post updated");

            if (isPublished) {
                System.out.println("Job listing created successfully");
            } else {
                System.out.println("Job listing creation failed");
            }

        } finally {
            // h. Close browser
            driver.quit();
        }
    }
}
