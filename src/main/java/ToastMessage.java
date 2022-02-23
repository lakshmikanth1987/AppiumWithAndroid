import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ToastMessage {

	public static void main(String[] args) throws MalformedURLException {
		// To Verify Toast Message 
		
		File appDir = new File("app");
		File app = new File(appDir, "General-Store.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//To validate Toast Msg "Please enter your name"
		
		String ErrorMsg=driver.findElement(By.xpath("//android.widget.Toast[1]")).getText().trim();
		
		System.out.println("Error Message : "+ErrorMsg);

	}

}
