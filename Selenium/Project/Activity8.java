package Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Activity8 {
    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(options);

        try {
            // a & b. Open browser and navigate to backend
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://alchemy.hguy.co/jobs/wp-admin");

            // c. Enter username
            driver.findElement(By.id("user_login"))
                  .sendKeys("admin");   

            // d. Enter password
            driver.findElement(By.id("user_pass"))
                  .sendKeys("admin");   

            // e. lick Login
            driver.findElement(By.id("wp-submit")).click();

            // f. Verify login
            boolean loggedIn = driver.getTitle().contains("Dashboard");

            if (loggedIn) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }

        } finally {
            // g. Close browser
            driver.quit();
        }
    }
}
