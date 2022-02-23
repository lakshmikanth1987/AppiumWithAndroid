import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class DragAndDrop extends base {

	public static void main(String[] args) throws MalformedURLException {
		
		
		AndroidDriver<AndroidElement>driver=capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		WebElement src=driver.findElements(By.className("android.view.View")).get(0);
		WebElement dst=driver.findElementsByClassName("android.view.View").get(1);
		
		TouchAction t=new TouchAction(driver);
		
		t.longPress(longPressOptions().withElement(element(src))).moveTo(element(dst)).release().perform();
		
		// verify Dropped text displayed after Drag and Drop 
		System.out.println(driver.findElement(By.xpath("//*[@text='Dropped!']")).isDisplayed());
	}

}
