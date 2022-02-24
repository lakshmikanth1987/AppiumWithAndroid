import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ReadOTP {

	public static AndroidDriver<AndroidElement> driver;
	public static  String OTP;
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// To Login with OTP in Amazon India app 
		//Pass Mobile number for Login
		//Message Title of Amazon keeps changing
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		desiredCapabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		desiredCapabilities.setCapability("noReset", "true");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		Thread.sleep(15000);

		driver.findElement(By.xpath("//android.widget.Button[@text='Already a customer? Sign in']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@resource-id='ap_email_login']")).sendKeys("Pass Mobile Number");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Continue']")).click();
		Thread.sleep(6000);
		getOTP("57575022");
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.findElement(By.className("android.widget.EditText")).sendKeys(OTP);
		driver.findElement(By.xpath("//*[@text='Continue']")).click();
		
	}
	
	
	// To Read OTP 
	
	public static String getOTP(String MessageTitle) throws InterruptedException {

		driver.startActivity(new Activity("com.android.mms", "com.android.mms.ui.ConversationList"));

		Thread.sleep(15000);
		int l = driver.findElements(By.id("com.android.mms:id/from")).size();
		System.out.println("Number of elements :" + l);
		for (int i = 0; i < l; i++) {
			String txt = driver.findElements(By.id("com.android.mms:id/from")).get(i).getText();
			System.out.println("Text is :" + txt);

			if (txt.contains(MessageTitle)) {
				driver.findElements(By.id("com.android.mms:id/subject")).get(i).click();
				Thread.sleep(4000);
				int sz = driver.findElements(By.id("com.android.mms:id/msg_list_item")).size();
				driver.findElement(By.id("com.android.mms:id/view_origin")).click();
				String cnt = driver.findElements(By.id("com.android.mms:id/sms_card_text")).get(sz - 1).getText();
				System.out.println("Content of Msgs :" + cnt);
				OTP = cnt.substring(0, 6);
				System.out.println("OTP is " + OTP);
				break;
			}

		}
		driver.navigate().back();
		return OTP;
	}

}
