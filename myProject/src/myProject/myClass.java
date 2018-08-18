package myProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class myClass
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\seleniumfiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://yoniflenner.net/Xamples/pizza");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
