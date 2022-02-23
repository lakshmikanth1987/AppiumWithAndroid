import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwitchingToWebView {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// ******************************** This Class helps to switch to WebView from Native App*******************************

		// To download Apk file to Device/Emulator

		File appDir = new File("app");
		File app = new File(appDir, "General-Store.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("TestUser");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Visit to the website to complete purchase']")).click();
		
		Thread.sleep(10000);
		Set<String> winName=driver.getContextHandles();
		for(String contextName:winName) {
			System.out.println("Name of Context is :"+contextName);
		}
		
		//To switch from Native app to web view using Context Name
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		Thread.sleep(10000);
		driver.findElement(By.name("q")).sendKeys("Lakshmikanth Katarki");
		
		//Switching back to Native App from WebView 
		
		driver.context("NATIVE_APP");
		
		
	}

}
