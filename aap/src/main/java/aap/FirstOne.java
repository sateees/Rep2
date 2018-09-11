package aap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;



public class FirstOne {

	public static void main(String[] args) throws MalformedURLException, Exception {
		// TODO Auto-generated method stub
		
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723");
		
		Thread.sleep(20000);
	
		//AppiumDriver<WebElement> driver;
		WebDriver driver;

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("device", "Android");
		cap.setCapability("platformName", "Android");

		cap.setCapability("deviceName", "emulator-5554");

		cap.setCapability("appPackage", "com.android.calculator2"); // my case com.gorillalogic.monkeytalk.demo1
		cap.setCapability("appActivity", "com.android.calculator2.Calculator"); // my case RootActivity

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		//driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Thread.sleep(5000);

		
		List<WebElement> elmnts = driver.findElements(By.xpath("//*"));
		
		for(WebElement elm:elmnts) {
			System.out.println("element text is: "+elm.getText());
		}
		
		driver.findElement(By.id("digit_6")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//android.widget.Button[@content-desc='multiply']")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("digit_2")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("eq")).click();
		Thread.sleep(3000);

		String str = driver.findElement(By.xpath("//android.widget.TextView")).getText();
		System.out.println("value is correct");
		if (Integer.parseInt(str) == 12)
			System.out.println("value is correct");
		else
			System.out.println("value is not correct");

	}

}
