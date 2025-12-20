package Selenium_Project;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Activity1 {
    public static void main(String[] args) {
    	FirefoxOptions options = new FirefoxOptions();
    	options.setAcceptInsecureCerts(true);

    	WebDriver driver = new FirefoxDriver(options);        
        try {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Open the page
        driver.get("https://alchemy.hguy.co/jobs/");
        String actualtitle= driver.getTitle();
        String expectedtitle = "Alchemy Jobs – Job Board Application";
        if (actualtitle.equals(expectedtitle)) {
            System.out.println("Title matched successfully");
        } else {
            System.out.println("Title did not match ");
            System.out.println("Actual Title: " + actualtitle);
        }
        }
        finally {
        	driver.close();
        }
    }
}