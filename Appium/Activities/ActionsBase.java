package activities;



import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class ActionsBase {
	private final static PointerInput finger=new PointerInput(Kind.TOUCH,"finger");
	
	public static void doSwipe(AppiumDriver driver,Point start,Point end,int duration) {
		Sequence swipe=new Sequence(finger,1);
				
	}

}
