package Project;

import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;

import Activities.ActionsBase;
import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class App_Project {
	// Driver Declaration
	AndroidDriver driver;
	// TestNG Explicit Wait
	WebDriverWait wait;

	// Set up method
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp("C:/Users/SelvapathyKalaimanna/Downloads/ts-todo.apk");
		options.noReset();

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
	}

	// Test method
	@Test
	public void todo_Task1() {
		// Perform the activity1 with priority high
		driver.findElement(AppiumBy.accessibilityId("Predicted app: To-Do List")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/fab_new_task")));
		driver.findElement(AppiumBy.id("fab_new_task")).click();
		//given input task name
		//driver.findElement(AppiumBy.id("et_new_task_name")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/et_new_task_name")));
		driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_name")).sendKeys("Activity1");
		driver.findElement(AppiumBy.id("tv_new_task_priority")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"High\")")).click();
		driver.findElement(AppiumBy.id("bt_new_task_ok")).click();
		// Perform the activity2 with priority medium
		driver.findElement(AppiumBy.id("fab_new_task")).click();
		//given input task name
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/et_new_task_name")));
		driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_name")).click();
		driver.findElement(AppiumBy.id("et_new_task_name")).sendKeys("Activity2");
		driver.findElement(AppiumBy.id("tv_new_task_priority")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Medium\")")).click();
		driver.findElement(AppiumBy.id("bt_new_task_ok")).click();
		// Perform the activity3 with priority low
		driver.findElement(AppiumBy.id("fab_new_task")).click();
		//given input task name
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/et_new_task_name")));
		driver.findElement(AppiumBy.id("et_new_task_name")).click();
		driver.findElement(AppiumBy.id("et_new_task_name")).sendKeys("Activity3");
		driver.findElement(AppiumBy.id("tv_new_task_priority")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Low\")")).click();
		driver.findElement(AppiumBy.id("bt_new_task_ok")).click();	
	
		// Find the result
		String result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity1\"]"))).getText();
			Assert.assertEquals(result1, "Activity1");
		String result2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity2\"]"))).getText();
			Assert.assertEquals(result2, "Activity2");
		String result3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity3\"]"))).getText();
			Assert.assertEquals(result3, "Activity3");
		
		//long press to edit the task invoke long press method
			WebElement task1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity1\"]"));
			Longpress.doLongPress(driver, task1, Duration.ofMillis(2000));
			//edit the task name
			
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]")));
			driver.findElement(AppiumBy.id("com.app.todolist:id/et_edit_task_name")).clear();
			driver.findElement(AppiumBy.id("com.app.todolist:id/et_edit_task_name")).sendKeys("Activity1_edited");
		
			
		//String result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity1\"]")).getText();
		//String result2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity2\"]")).getText();
		//String result3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\" and @text=\"Activity3\"]")).getText();

		// Assertion
		
		//Assert.assertEquals(result2, "Activity2");
		//Assert.assertEquals(result3, "Activity3");
	
		
	}

	// Tear down method
	@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}
}