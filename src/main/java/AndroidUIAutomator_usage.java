import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidUIAutomator_usage extends base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement>driver=capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		/*AndroidUIAutomator is one of the locator to identify elements 
		syntax is  (attribute("value"))
		*/
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//Validate clickable features in all options after clicking View option
		
		int n=driver.findElementsByAndroidUIAutomator("new UiSelector().enabled(true)").size();
		System.out.println("Clickable Options are "+n);
	}

}
