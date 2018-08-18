import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;

public class finalExam extends BaseClass
{

	private static loginPage LoginPage;

	@BeforeClass
	public static void beforeSuite() throws ParserConfigurationException, SAXException, IOException 
	{
		System.setProperty(getData("driverType"), getData("webdriver"));
		driver = new ChromeDriver();
		driver.get(getData("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(getData("seconds")), TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		extent = new ExtentReports(getData("reportPath"), true);
		LoginPage = PageFactory.initElements(driver, loginPage.class);

				
	}
	
	
	
	@Test
	public void test1() throws ParserConfigurationException, SAXException, IOException, InterruptedException
	{
		test = extent.startTest("Final exam!", "This is my final exam report"); 
		
		LoginPage.insertData(getData("Name"), getData("lastName"));
		
		
		LoginPage.inputName(getData("Name"));
		LoginPage.inputLastName(getData("lastName"));
		LoginPage.inputEmail(getData("email"));
		LoginPage.validateReEnterEmailTextBoxVisible();
		LoginPage.ReinputEmail(getData("email"));
		LoginPage.enterPassword(getData("password"));
		LoginPage.selectMaleCheckBox();
		LoginPage.clickCreateAccount();
		LoginPage.closeDatePopup();
		LoginPage.validateErrorMassageOnLoginPage();
	}
	
	
	
	
	@AfterClass 
	public static void afterSuite() 
	{
		extent.flush();
		extent.close();
		driver.quit();
	}
	
	
}
