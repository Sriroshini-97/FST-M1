package Project;

import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {

    public static void main(String[] args) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"), options);

        try {
           
            driver.get("https://training-support.net/webelements");

            driver.findElement(By.xpath(
                "//android.view.View[@text='To-Do List']")).click();

            WebElement inputField = driver.findElement(By.id("todo-input"));

            inputField.sendKeys("Add tasks to list");
            driver.findElement(By.id("todo-add")).click();

            inputField.sendKeys("Get number of tasks");
            driver.findElement(By.id("todo-add")).click();

            inputField.sendKeys("Clear the list");
            driver.findElement(By.id("todo-add")).click();

            List<WebElement> tasks =
                    driver.findElements(By.xpath("//ul[@id='todo-list']/li"));

            
            for (WebElement task : tasks) {
                task.click();
            }

            Assert.assertEquals(tasks.size(), 5,
                    "Task count does not match expected value");

            System.out.println("Tasks added, struck out, and verified successfully");

        } finally {
            driver.quit();
        }
    }
}
