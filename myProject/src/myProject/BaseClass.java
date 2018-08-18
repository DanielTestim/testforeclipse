import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;



public class BaseClass 

{
    public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;


	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
	{
	File fXmlFile = new File("C:/SeleniumDrivers/xmlForAutomation.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile); 
	doc.getDocumentElement().normalize();
	return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}
	
	
	

	
}
