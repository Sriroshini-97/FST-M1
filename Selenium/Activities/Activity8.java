import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {

	public static void main(String[] args) {
		
        WebDriver driver = new ChromeDriver();
       
        Actions actions = new Actions(driver);  //actions class

        driver.get("https://training-support.net/webelements/mouse-events");
      
        System.out.println("Page title: " + driver.getTitle());

        WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
        WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
        WebElement srcButton = driver.findElement(By.xpath("//h1[text()='src']"));
        WebElement targetButton = driver.findElement(By.xpath("//h1[text()='target']"));

        actions.click(cargoLock)
               .moveToElement(cargoToml)
               .pause(5000)
               .click(cargoToml)
               .build()
               .perform();
     
        String actionMessage = driver.findElement(By.id("result")).getText();
        System.out.println(actionMessage);

        actions.doubleClick(srcButton).pause(3000).pause(5000)
        .contextClick(targetButton).pause(3000).build().perform();
      
        actions.click(driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"))).pause(5000).build().perform();
  
        actionMessage = driver.findElement(By.id("result")).getText();
        System.out.println(actionMessage);
        driver.quit();
    }


	}


