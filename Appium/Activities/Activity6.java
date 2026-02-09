package Project;


import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {

    public static void main(String[] args) throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        URL serverURL = new URI("http://127.0.0.1:4723/wd/hub").toURL();
        AndroidDriver driver = new AndroidDriver(serverURL, options);

        try {
           
            driver.get("https://training-support.net/webelements");

            driver.findElement(By.xpath("//android.view.View[@text='Popups']")).click();
            driver.findElement(By.id("signInButton")).click();

            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));

            username.clear();
            username.sendKeys("admin");
            password.clear();
            password.sendKeys("password");

            driver.findElement(By.xpath("//button[text()='Log in']")).click();

            WebElement message = driver.findElement(By.id("action-confirmation"));
            String msgText = message.getText();
            System.out.println("Login message: " + msgText);

            Assert.assertTrue(msgText.contains("Welcome Back, admin"),
                    "Login success message not found!");

            System.out.println("Popup login test passed");

        } finally {
            driver.quit();
        }
    }
}
