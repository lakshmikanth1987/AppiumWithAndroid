import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class scrollingInAndroid extends base {

	public static void main(String[] args) throws MalformedURLException {
		//Scroll to Element in Android only and we need to use AndroidUIAutomator to find the element
		
		AndroidDriver<AndroidElement>driver=capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"TextClock\"));").click();
		
		// Below way also works for Scroll 
		
       // driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"TextClock\"));")).click();
	}

}
