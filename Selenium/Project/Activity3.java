
package Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Activity3 {
    public static void main(String[] args) {

        // Firefox options
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(options);

        try {
            // Wait setup
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Open the website
            driver.get("https://alchemy.hguy.co/jobs/");

            // Locate header image
            WebElement headerImage = driver.findElement(
                By.cssSelector("header img")
            );

            // Get image URL
            String imageUrl = headerImage.getAttribute("src");

            // Print URL
            System.out.println("Header Image URL:");
            System.out.println(imageUrl);

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
