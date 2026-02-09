package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void SetUp() throws MalformedURLException, URISyntaxException {
		// Set the app file
		File appFile = new File("src/test/resources/Calculator.apk");
		// Desired Capabilities
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setPlatformName("android");
		caps.setAutomationName("uiAutomator2");
		caps.setApp(appFile.getAbsolutePath());
		caps.noReset();
		
		// Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		 // Initialize the IOS driver
		driver = new AndroidDriver(serverURL, caps);
	}
	
	public void testMethod()
	{
		driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_8")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
        
        // Assertion
        Assert.assertEquals(result, "40");
	}
	@AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
}
}
