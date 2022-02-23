import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	
	public static AndroidDriver<AndroidElement>capabilities(String device) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver;
		
		//To download Apk file to Device/Emulator 
		
		File appDir=new File("app");
		File app=new File(appDir,"ApiDemos-debug.apk");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		if(device.equals("emulator")) {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator Name");
		}else if(device.equals("real")) {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		return driver;
		
	}

}
