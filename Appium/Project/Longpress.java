package Project;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Longpress {
     	 private final static PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
     public static void doLongPress(AndroidDriver driver, WebElement element, Duration duration) {
    	    int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
    	    int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

    	    Sequence longPress = new Sequence(finger, 1);
    	    longPress.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
    	    longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    	    longPress.addAction(new Pause(finger, duration));
    	    longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    	    driver.perform(Collections.singletonList(longPress));
    	}
     //add tap method		
     	
     public static void tap(AndroidDriver driver, WebElement element) {
		    int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
		    int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

		    Sequence tap = new Sequence(finger, 1);
		    tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
		    tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		    tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    driver.perform(Collections.singletonList(tap));
 	}

		// TODO Auto-generated method stub
		
	}
