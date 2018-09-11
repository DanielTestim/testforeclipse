package myProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class runnableJarMain {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
		
	    chromeDC.setPlatform(Platform.VISTA);
	  
	    
	    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDC);
	    
		driver.get("http://yoniflenner.net/Xamples/pizza");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.quit();
		//Example code

	}

}
