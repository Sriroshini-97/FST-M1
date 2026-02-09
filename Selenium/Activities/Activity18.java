import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {
    public static void main(String[] args) {
   
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/alerts");
     
        System.out.println("Page title: " + driver.getTitle());

        driver.findElement(By.id("simple")).click();
        Alert alertobj = driver.switchTo().alert();

        String alertText = alertobj.getText();
        System.out.println("Text in alert: " + alertText);

        alertobj.accept();
        
        System.out.println(driver.findElement(By.id("result")).getText());

        driver.quit();
    }
}