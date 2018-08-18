import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import static org.junit.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;


public class loginPage extends BaseClass

{
	
	public WebDriver driver;
	
	@FindBy(how = How.NAME, using = "firstname")
	public WebElement nameField;
	
	@FindBy(how = How.NAME, using = "lastname")
	public WebElement lastNameField;
	
	@FindBy(how = How.NAME, using = "reg_email__")
	public WebElement emailField;
	
	@FindBy(how = How.XPATH, using = "//*[@id='u_0_y']")
	public WebElement passwordField;
	
	@FindBy(how = How.XPATH, using = "//*[@id='u_0_9']")
	public WebElement genderSelectionCheckbox;
	
	@FindBy(how = How.NAME, using = "websubmit")
	public WebElement createAccountButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='u_0_u']")
	public WebElement reEnterEmail;
	
	@FindBy(how = How.XPATH, using = "//*[@id='facebook']/body/div[3]/div[2]/div/div/div/div[1]")
	public WebElement birthDateConfirmation;
	
	@FindBy(how = How.XPATH, using = "//*[@id='facebook']/body/div[3]/div[2]/div/div/div/div[3]/button")
	public WebElement submitBirthDate;
	
	@FindBy(how = How.XPATH, using = "//*[@id='reg_error_inner']")
	public WebElement ErrorMassage;
	

	
	
	
	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	
	public void inputName(String name)
	{
		try
		{
			nameField.sendKeys(name);
			test.log(LogStatus.PASS, "Set name successfuly");
		}
		catch (Exception e)
		{
			System.out.println("Name was not entered"   + e.getMessage());
			fail("Name was not entered");
			test.log(LogStatus.FAIL, "Failed to set name! : " + e.getMessage() + test.addScreenCapture("IMAGE PATH"));
		}
	}

	

	
	public void inputLastName(String lastName)
	{
		try
		{
			lastNameField.sendKeys(lastName);
			test.log(LogStatus.PASS, "Set last name successfuly");
		}
		catch (Exception e)
		{
			System.out.println("LastName was not entered"   + e.getMessage());
			fail("LastName was not entered");
			test.log(LogStatus.FAIL, "Failed to set last name! : " + e.getMessage() + test.addScreenCapture("IMAGE PATH"));
		}
	}
	
	
		
	
	public void inputEmail(String email)
	{
		try
		{
			emailField.sendKeys(email);
			test.log(LogStatus.PASS, "Set email successfuly");
		}
		catch (Exception e)
		{
			System.out.println("Email was not entered!"   + e.getMessage());
			fail("Email was not entered");
			test.log(LogStatus.FAIL, "Failed to set email! : " + e.getMessage() + test.addScreenCapture("IMAGE PATH"));
		}
	}
	
	
	public void insertData(String name, String lastname) throws ParserConfigurationException, SAXException, IOException
	{
		inputName(name);
		inputLastName(lastname);
		
	}
	
	
	public void validateReEnterEmailTextBoxVisible()
	{
		try
		{
		reEnterEmail.isDisplayed();
		test.log(LogStatus.PASS, "Re enter email text box is visible");
		}
		
		catch (Exception e)
		{
			System.out.println("Email was not Re-entered!"   + e.getMessage());
			fail("Re enter email tex box is not visible");
			test.log(LogStatus.FAIL, "Failed to Reset email! : " + e.getMessage() + test.addScreenCapture("IMAGE PATH"));
		}
	}
	
	
	
	
	
	public void ReinputEmail(String email)
	{
		try
		{
			reEnterEmail.sendKeys(email);
			test.log(LogStatus.PASS, "Set email successfuly");
		}
		catch (Exception e)
		{
			System.out.println("Email was not entered!"   + e.getMessage());
			fail("Email was not entered");
			test.log(LogStatus.FAIL, "Failed to set email! : " + e.getMessage() + test.addScreenCapture("IMAGE PATH"));
		}
	}
	
	
	
	
	
	public void enterPassword(String password) 
	{
		try 
		{
			
			passwordField.sendKeys(password);
		test.log(LogStatus.PASS, "Password set successfuly");
		}
		catch (Exception e)
		{
			System.out.println("Password was not set!"   + e.getMessage());
			fail("Password was not set!");
			test.log(LogStatus.FAIL, "Failed to set password! : " + e.getMessage() + test.addScreenCapture("IMAGE PATH"));
		}
	}

	
	
	
	public void closeDatePopup() throws InterruptedException 
	{
		
		if(birthDateConfirmation.isDisplayed())
		{
			Thread.sleep(2000);
			submitBirthDate.click();
		}
	}
	
	
	
	
	public void selectMaleCheckBox()
	{
		try{
			Thread.sleep(3000);
			genderSelectionCheckbox.click();
		test.log(LogStatus.PASS, "Set gender - male successfuly");
		}
		catch (Exception e)
		{
			System.out.println("Gender is not selected" + e.getMessage());
		fail("Gender selection checkbox was not clicked"   + e.getMessage());
		test.log(LogStatus.FAIL, "Failed to set gender! : " + e.getMessage() + test.addScreenCapture("IMAGE PATH"));
		}
	}
	
	
		
	
	
	public void clickCreateAccount()
	{
		try
		{
		createAccountButton.click();
		test.log(LogStatus.PASS, "Accout submited!");
		}
		catch (Exception e)
		{
			System.out.println("create acount button was not clicked");
			fail("create acount button was not clicked"  + e.getMessage());
			test.log(LogStatus.FAIL, "Failed to submit account! : " + e.getMessage() + test.addScreenCapture("IMAGE PATH"));
		}
	}
	
	  
	
	
	public void validateErrorMassageOnLoginPage()
	{
		try
		{
		if(ErrorMassage.isDisplayed() == true)
		{
			System.out.println("Test passed!");
			test.log(LogStatus.PASS, "Set gender - male successfuly");
		}
		else
		{
			System.out.println("Error massage was not shown");
		}
		}

		catch(Exception e)
		{
			System.out.println("Test Faild!" + e.getMessage());
		fail("Error massage was not shown"   + e.getMessage());
		test.log(LogStatus.FAIL, "Failed to set gender! : " + e.getMessage() + test.addScreenCapture("IMAGE PATH"));
		}
		
	}
	
}
