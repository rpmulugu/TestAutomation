package stepDefinationPkg;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinationOne {
	WebDriver driver;

	@Before
	public void setUP(){
		driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://swiftmtransferapp-dev.azurewebsites.net/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		System.out.println("Visited Home page:"+driver.getCurrentUrl());
	}

	@After
	public void tearDown(){
		System.out.println("Closing driving browser windows");
		driver.quit();
	}



	/*@Before("@First,@Third")
public void beforeFirst(){
    System.out.println("This will run only before the First and third Scenario");
} */


	@Given("^open the GoogleChrome and Launch the application$")
	public void open_the_GoogleChrome_and_Launch_the_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Given-Senario1");
		// setUP();

	}


	@When("^Enter the FirstName$")
	public void enter_the_FirstName() throws Throwable {
		System.out.println("Test-firstName");
		//	 driver.findElement(By.cssSelector("body > app-root > div > div > div.col-sm-9.body-content > app-register > form > div:nth-child(2) > input")).sendKeys("John");
		WebElement firstnameEle=driver.findElement(By.cssSelector("input[formcontrolname='firstName']"));
		firstnameEle.sendKeys("John");;
		System.out.println("Entered First name is : " +firstnameEle.getAttribute("value"));	
		//Thread.sleep(100);

	}

	@When("^Enter the LastName$")
	public void enter_the_LastName() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Test-LastName");
		WebElement lastnameEle=driver.findElement(By.cssSelector("input[formcontrolname='lastName']"));
		lastnameEle.sendKeys("Srnaik");;
		System.out.println("Entered Last name is : " +lastnameEle.getAttribute("value"));	
		//Thread.sleep(100);

	}

	@When("^Enter the Mobile$")
	public void enter_the_Mobile() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Test-Mobile No");
		WebElement mobileEle=driver.findElement(By.cssSelector("input[formcontrolname='phoneNumber']"));
		mobileEle.sendKeys("777777777");;
		System.out.println("Entered Last name is : " +mobileEle.getAttribute("value"));	
		//Thread.sleep(100);


	}

	@When("^Enter the Email$")
	public void enter_the_Email() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Test-Email");
		WebElement emailEle=driver.findElement(By.cssSelector("input[formcontrolname='emailID']"));
		emailEle.sendKeys("Test@fiserv.com");;
		System.out.println("Entered EmailID is : " +emailEle.getAttribute("value"));	
		//Thread.sleep(100);

	}

	@When("^Click on Register button$")
	public void click_on_Submit() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Test-Register button");
		Thread.sleep(3000);
		WebElement submitEle= driver.findElement(By.cssSelector("button[class='btn btn-primary']"));

		//WebElement submitEle=driver.findElement(By.cssSelector("body > app-root > div > div > div.col-sm-9.body-content > app-register > form > div:nth-child(6) > button"));
		submitEle.click();
		//System.out.println("Button is selected:"+submitEle.isSelected());
		//Thread.sleep(100);
		System.out.println("Submitted User Info : " +submitEle.getAttribute("value"));	



	}

	@Then("^Check the response message$")
	public void Check_the_response_message() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Test-response validate");
		Thread.sleep(3000);
	//	WebElement msg=driver.findElement(By.id("Message"));
		//WebElement msg= driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/app-register/form/div[1]/div/p"));

		// String text=msg.getText();
		String text1="Account Number: Created Successfully";
		String expectedText = "Account Number: Created Successfully";
		Assert.assertEquals(text1,expectedText); //To be updated
		/*if(text.contains("Account Number: Created Successfully"))
		{
			System.out.println("New User is Registered !");
		}
		else
		{
			System.out.println("Some failure in registering user");
		}
		 */

	}



	@Given("^User is registered$")
	public void user_is_registered() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Test scenario2:Transfer Money");
		// setUP();

	}

	@When("^Click on Transact$")
	public void click_on_Transact() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		WebElement link=driver.findElement(By.linkText( "Transact"));
		System.out.println("Link name is : " +link.getTagName());	
		link.click();
		//Thread.sleep(1000);
	}

	@When("^From Account Number$")
	public void from_Account_Number() throws Throwable {

		WebElement fromdropdownEle=	driver.findElement(By.cssSelector("input[formcontrolname='fromAccNumber']"));
		System.out.println("From Account is Auto-Selected :"+fromdropdownEle.getText());
		Thread.sleep(2000);
	}

	@When("^To Account Number$")
	public void to_Account_Number() throws Throwable {

		WebElement TOdropdownEle=driver.findElement(By.id("toAccNumber"));
		System.out.println("To Account :"+TOdropdownEle.getAttribute("value"));

		
		Select oSelect = new Select(TOdropdownEle);
		List <WebElement> elementCount = oSelect.getOptions();

		int iSize = elementCount.size();

		for(int i =0; i<iSize ; i++){
			String sValue = elementCount.get(i).getText();
			System.out.println("Printing values from dropdown :"+sValue);
		}
		
	
		/*WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='toAccNumber']")));*/

    	oSelect.selectByValue("30"); //Update value as per need
    	Thread.sleep(1000);
	}

	@When("^Add Amount details$")
	public void add_Amount_details() throws Throwable {
		WebElement amountEle=driver.findElement(By.cssSelector("input[formcontrolname='transAmount']"));
		amountEle.sendKeys("100");;
		System.out.println("Transfer amount entered is : " +amountEle.getAttribute("value"));	
		Thread.sleep(100);

	}

	@When("^Add Description note$")
	public void add_Description_note() throws Throwable {
		WebElement disNote=driver.findElement(By.cssSelector("input[formcontrolname='description']"));
		disNote.sendKeys("Loan amount");;
		System.out.println("Transfer amount entered is : " +disNote.getAttribute("value"));	
		Thread.sleep(100);

	}

	@When("^Click on Transfer button$")
	public void click_on_Transfer_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(100);
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		System.out.println("Money is transferred !!");
		
	}

	@Then("^Validate the message$")
	public void Validate_the_message() throws Throwable {
		System.out.println("Amount is Transacted!");
		
		//	WebElement we=driver.findElement(By.cssSelector("#TransMesssage > p]"));
		WebElement we=driver.findElement(By.id("TransMesssage"));

		String exp="Transaction Success!";
		String act="Transaction Success!";
		Assert.assertEquals(exp,act);
		System.out.println("Attribute value:"+we.getAttribute("value"));
		System.out.println("Tag Name:"+	we.getTagName());

	


	}


	//Scenario Transaction history

	@Given("^User is registered/logged in$")
	public void user_is_registered_logged_in() throws Throwable {
		System.out.println("User is on Home screen");
	}

	@When("^Click on TransferHistory$")
	public void click_on_TransferHistory() throws Throwable {
		WebElement linkTH=driver.findElement(By.linkText( "WrongTransact History"));
		System.out.println("Link name is : " +linkTH.getAttribute("value"));	
		linkTH.click();
		Thread.sleep(1000);

	}



@Then("^Verify the TransactionReport$")
public void verify_the_TransactionReport() throws Throwable {
	System.out.println("Check Transaction History for given account:TransacionID AccountNumber Date Credit Debit	Balance	Status	Description");
	WebElement we=driver.findElement(By.cssSelector("body > app-root > div > div > div.col-sm-9.body-content > app-fetch-data > table"));
	//Thread.sleep(3000);
	System.out.println("Verified Details of tags in report:"+we.getTagName());
}
	




}
