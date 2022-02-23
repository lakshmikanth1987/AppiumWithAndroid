import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasicTasks extends base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement>driver=capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// To perform send Text by selecting checkbox
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		//To enter Text in Pop up message and click Ok in pop up
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Lakshmikanth");
		driver.findElement(By.id("android:id/button1")).click();
		
	}

}
