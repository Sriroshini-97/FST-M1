
		import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


		public class Activity1 {
		  public static void main(String[] args) {
		   
		    WebDriver driver = new ChromeDriver();
		    
		    
		    driver.get("https://training-support.net");
		    System.out.println(driver.getTitle());
		    WebElement btnAboutUs=driver.findElement(By.linkText("About Us"));
		   btnAboutUs.click();
		   System.out.println(driver.getTitle());
		    driver.quit();
		  }
		

	}


