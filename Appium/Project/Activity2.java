package Project;

import java.net.URI;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.TouchAction;

public class Activity2 {

    public static void main(String[] args) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.example.todolist");
        options.setAppActivity("com.example.todolist.MainActivity");

        URL serverURL = new URI("http://127.0.0.1:4723/wd/hub").toURL();
        AndroidDriver driver = new AndroidDriver(serverURL, options);

        try {
            
            WebElement firstTask = driver.findElement(
                    By.id("com.example.todolist:id/taskTitle"));

            TouchAction<?> action = new TouchAction<>(driver);
            action.longPress(
                    LongPressOptions.longPressOptions()
                            .withElement(ElementOption.element(firstTask))
                            .withDuration(java.time.Duration.ofSeconds(2)))
                  .release()
                  .perform();
            driver.findElement(By.id("com.example.todolist:id/deadlineButton")).click();

            LocalDate today = LocalDate.now();
            LocalDate nextSaturday = today.with(
                    java.time.temporal.TemporalAdjusters.next(DayOfWeek.SATURDAY));

            String day = String.valueOf(nextSaturday.getDayOfMonth());

            // 5️⃣ Select day in DatePicker
            driver.findElement(By.xpath(
                    "//android.view.View[@text='" + day + "']")).click();

            driver.findElement(By.id("android:id/button1")).click(); // OK

            driver.findElement(By.id("com.example.todolist:id/saveButton")).click();

            String deadlineText = driver.findElement(
                    By.id("com.example.todolist:id/deadlineText")).getText();

            Assert.assertTrue(deadlineText.contains("Sat"),
                    "Deadline was not set correctly");

            System.out.println("✅ Deadline successfully set to next Saturday");

        } finally {
            driver.quit();
        }
    }
}

