package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2  {
    
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.chrome");
        caps.setAppActivity("com.google.android.apps.chrome.Main");
//        caps.noReset();

        // Set the Appium server URL
        URL serverURL = new URI("http://localhost:4723").toURL();

        driver = new AndroidDriver(serverURL, caps);

        driver.get("https://training-support.net");
    }

   
    @Test
    public void chromeTest() {
        // Find heading on the page
        String pageHeading = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text='Training Support']")).getText();

        // Print to console
        System.out.println("Heading: " + pageHeading);

        // Find and click the About Us link
        driver.findElement(AppiumBy.accessibilityId("About Us")).click();

        // Find heading of new page and print to console
        String aboutPageHeading = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text='About Us']")).getText();
        System.out.println(aboutPageHeading);
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}


