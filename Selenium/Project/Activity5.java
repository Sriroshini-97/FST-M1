package Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Activity5 {
    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(options);

        try {
            // Wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Open website
            driver.get("https://alchemy.hguy.co/jobs/");

            // Find and click "Jobs" menu
            driver.findElement(By.linkText("Jobs")).click();

            // Read page title
            String actualTitle = driver.getTitle();
            String expectedTitle = "Jobs – Alchemy Jobs";

            System.out.println("Page Title: " + actualTitle);

            // Verify correct page
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Successfully navigated to Jobs page");
            } else {
                System.out.println("Navigation failed");
            }

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
