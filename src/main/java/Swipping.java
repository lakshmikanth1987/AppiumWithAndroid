import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class Swipping extends base {

	public static void main(String[] args) throws MalformedURLException {
		
		// Use of AndroidUIAutomator to find element instead of Xpath 
		
		
		
		AndroidDriver<AndroidElement>driver=capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		driver.findElement(By.xpath("//*[@content-desc='9']")).click();
		
		WebElement src=driver.findElement(By.xpath("//*[@content-desc='15']"));
		WebElement dst=driver.findElement(By.xpath("//*[@content-desc='45']"));
		
		//Using Touch actions Swipping options
		
		/*Mandatory Packages to be imported Manually 
		
		import static io.appium.java_client.touch.offset.ElementOption.element;
		import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
		import static java.time.Duration.ofSeconds;
		*/
		
		TouchAction t=new TouchAction(driver);
		
		t.longPress(longPressOptions().withElement(element(src)).withDuration(ofSeconds(2))).moveTo(element(dst)).release().perform();
		
		

	}

}
