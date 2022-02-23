import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class TouchActions extends base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement>driver=capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		/*Tap option  required 2 packages needs to be imported Manually 
		
		import static io.appium.java_client.touch.TapOptions.tapOptions;
		import static io.appium.java_client.touch.offset.ElementOption.element;
		
		*/
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
		
		TouchAction t=new TouchAction(driver);
		t.tap(tapOptions().withElement(element(ele))).perform();
		
		WebElement customerAdapter=driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']"));
		t.tap(tapOptions().withElement(element(customerAdapter))).perform();
		
		/*LongPress required 1 package needs to be imported Manually  and Seconds required by Java 
		
		import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
		import static java.time.Duration.ofSeconds;*/
		
		
		WebElement PeopleNames=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		t.longPress(longPressOptions().withElement(element(PeopleNames)).withDuration(ofSeconds(3))).release().perform();
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		
		

	}

}
