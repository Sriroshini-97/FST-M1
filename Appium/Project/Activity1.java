package Project;

import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	public static void main(String[] args) throws Exception {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.example.todolist");
        options.setAppActivity("com.example.todolist.MainActivity");
        AndroidDriver driver;
        URL serverURL = new URI("http://127.0.0.1:4723/wd/hub").toURL();
        driver = new AndroidDriver(serverURL, options);
       

        try {
          
            driver.findElement(By.id("com.example.todolist:id/addTaskButton")).click();
            driver.findElement(By.id("com.example.todolist:id/taskName"))
                    .sendKeys("Complete Activity 1");

            driver.findElement(By.id("com.example.todolist:id/prioritySpinner")).click();
            driver.findElement(By.xpath("//android.widget.TextView[@text='High']")).click();

            driver.findElement(By.id("com.example.todolist:id/saveButton")).click();

            // Task 2 
            driver.findElement(By.id("com.example.todolist:id/addTaskButton")).click();
            driver.findElement(By.id("com.example.todolist:id/taskName"))
                    .sendKeys("Complete Activity 2");

            driver.findElement(By.id("com.example.todolist:id/prioritySpinner")).click();
            driver.findElement(By.xpath("//android.widget.TextView[@text='Medium']")).click();

            driver.findElement(By.id("com.example.todolist:id/saveButton")).click();

            //Task 3 
            driver.findElement(By.id("com.example.todolist:id/addTaskButton")).click();
            driver.findElement(By.id("com.example.todolist:id/taskName"))
                    .sendKeys("Complete Activity 3");

            driver.findElement(By.id("com.example.todolist:id/prioritySpinner")).click();
            driver.findElement(By.xpath("//android.widget.TextView[@text='Low']")).click();

            driver.findElement(By.id("com.example.todolist:id/saveButton")).click();

            List<WebElement> tasks =
                    driver.findElements(By.id("com.example.todolist:id/taskTitle"));

            Assert.assertEquals(tasks.size(), 3, "All three tasks were not added");

            System.out.println("Three tasks added successfully");

        } finally {
            driver.quit();
        }
    }
}


