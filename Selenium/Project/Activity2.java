package Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Activity2 {
    public static void main(String[] args) {

        // Firefox options
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        // Launch Firefox
        WebDriver driver = new FirefoxDriver(options);

        try {
            // Implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Navigate to the website
            driver.get("https://alchemy.hguy.co/jobs/");

            // Get the heading text
            String actualHeading = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
            String expectedHeading = "Welcome to Alchemy Jobs";

            // Verify heading
            if (actualHeading.equals(expectedHeading)) {
                System.out.println("Heading matched successfully");
            } else {
                System.out.println("Heading did not match");
                System.out.println("Actual Heading: " + actualHeading);
            }

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
