package Selenium_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Activity4 {
    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(options);

        try {
            // Wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Open website
            driver.get("https://alchemy.hguy.co/jobs/");

            // Get all h2 headings
            List<WebElement> headings = driver.findElements(By.tagName("h2"));

            // Get second heading (index starts from 0)
            String actualHeading = headings.get(0).getText();
            String expectedHeading = "Quia quis non";

            // Verify
            if (actualHeading.equals(expectedHeading)) {
                System.out.println("Second heading matched successfully");
            } else {
                System.out.println("Second heading did not match");
                System.out.println("Actual Heading: " + actualHeading);
            }

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
