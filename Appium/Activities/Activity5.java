package Project;

import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        URL serverURL = new URI("http://127.0.0.1:4723/wd/hub").toURL();
        driver = new AndroidDriver(serverURL, options);

        // Open the URL once for all tests
        driver.get("https://training-support.net/webelements");

        // Scroll to Login Form card and click it
        driver.findElement(By.xpath("//android.view.View[@text='Login Form']")).click();
    }

    @Test(priority = 1)
    public void loginWithCorrectCredentials() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submit = driver.findElement(By.xpath("//button[text()='Log in']"));

        username.clear();
        username.sendKeys("admin");
        password.clear();
        password.sendKeys("password");
        submit.click();

        WebElement message = driver.findElement(By.id("action-confirmation"));
        String msgText = message.getText();
        System.out.println("Success message: " + msgText);

        Assert.assertTrue(msgText.contains("Welcome Back, admin"),
                "Success message not displayed as expected");
    }

    @Test(priority = 2)
    public void loginWithIncorrectCredentials() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submit = driver.findElement(By.xpath("//button[text()='Log in']"));

        username.clear();
        username.sendKeys("admin");
        password.clear();
        password.sendKeys("wrongpassword");
        submit.click();

        WebElement message = driver.findElement(By.id("action-confirmation"));
        String msgText = message.getText();
        System.out.println("Failure message: " + msgText);

        Assert.assertTrue(msgText.contains("Invalid Credentials"),
                "Failure message not displayed as expected");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
