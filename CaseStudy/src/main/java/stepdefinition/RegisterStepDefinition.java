package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class RegisterStepDefinition {
	static WebDriver driver;
	
	@Given("Navigate to Home Page")
	public void navigatetohomepage(){
		System.setProperty("webdriver.chrome.driver", "C:\\Archita\\Driver\\chromedriver75_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}


	@When("user clicks on signup")
	public void userClicksOnSignup() throws Throwable {
		driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();
	}
	
	@When("user enters username as \"([^\"]*)\"")
	public void userEntersUsernameAs(String arg1)  {
		driver.findElement(By.name("userName")).sendKeys(arg1);
		
	}

	@When("^user enters fname as \"([^\"]*)\"$")
	public void userEntersFnameAs(String arg1)  {
		driver.findElement(By.name("firstName")).sendKeys(arg1);
	
	}

	@When("^user enters lname as \"([^\"]*)\"$")
	public void userEntersLnameAs(String arg1) {
		driver.findElement(By.name("lastName")).sendKeys(arg1);
		
	}

	@When("^user enters password as \"([^\"]*)\"$")
	public void userEntersPasswordAs(String arg1) throws Throwable {
		driver.findElement(By.name("password")).sendKeys(arg1);
	}

	@And("^user enters confirmpassword as \"([^\"]*)\"$")
	public void userEntersConfirmpasswordAs(String arg1) throws Throwable {
		driver.findElement(By.name("confirmPassword")).sendKeys(arg1);
	}

	@And("^user enters gender as \"([^\"]*)\"$")
	public void userEntersGenderAs(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("female")) {
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		}
		else
		{
			driver.findElement(By.xpath("//input[@value='Male']")).click();
		}
	}

	@And("^user enters E-mail as \"([^\"]*)\"$")
	public void userEntersEMailAs(String arg1) throws Throwable {
		driver.findElement(By.name("emailAddress")).sendKeys(arg1);
	}

	@And("^user enters Mobile Number as \"([^\"]*)\"$")
	public void userEntersMobileNumberAs(String arg1) throws Throwable {
		driver.findElement(By.name("mobileNumber")).sendKeys(arg1);
	}

	@And("^user enters DOB as \"([^\"]*)\"$")
	public void userEntersDOBAs(String arg1) throws Throwable {
		driver.findElement(By.name("dob")).sendKeys(arg1);
	}

	@And("^user enters Address as \"([^\"]*)\"$")
	public void userEntersAddressAs(String arg1) throws Throwable {
		driver.findElement(By.name("address")).sendKeys(arg1);
	}

	@And("^user selects security question as \"([^\"]*)\"$")
	public void userSelectsSecurityQuestionAs(String arg1) throws Throwable {
		Select question=new Select(driver.findElement(By.name("securityQuestion")));
		question.selectByVisibleText(arg1);
	}

	@And("^enter answer as \"([^\"]*)\"$")
	public void enterAnswerAs(String arg1) throws Throwable {
		driver.findElement(By.name("answer")).sendKeys(arg1);
	}

	@Then("^user is registered successfully$")
	public void userIsRegisteredSuccessfully() throws Throwable {
		driver.findElement(By.name("Submit")).click();
	}


	@And("^verify he is registered successfully$")
	public void verifyHeIsRegisteredSuccessfully() throws Throwable {
		String message=driver.findElement(By.xpath("//fieldset/div[8]")).getText();
		Assert.assertEquals(message, "User Registered Successfully!!! Please login");
	}


	@When("^user enters as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userEntersAsAnd(String arg1, String arg2) throws Throwable {
		driver.findElement(By.name("userName")).sendKeys(arg1);
		driver.findElement(By.name("password")).sendKeys(arg2);
	}


	@Then("^user logged in successfully$")
	public void userLoggedInSuccessfully() throws Throwable {
		driver.findElement(By.name("Login")).click();
	}


	@When("^user searches below products in search box as \"([^\"]*)\"$")
	public void userSearchesBelowProductsInSearchBoxAs(String arg1) throws Throwable {
		driver.findElement(By.name("products")).sendKeys(arg1);
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		driver.findElement((By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a"))).click();
	}


	@Then("^product should be added in the cart is available$")
	public void productShouldBeAddedInTheCartIsAvailable() throws Throwable {
		//WebElement addedProductsInCart = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/a/b"));
		//int numberOfelements = Integer.parseInt(addedProductsInCart.getText());
		//Assert.assertEquals(addedProductsInCart, numberOfelements);
		
	}


	@When("^user open cart$")
	public void userOpenCart() throws Throwable {
		driver.findElement((By.xpath("//a[@href='displayCart.htm']"))).click();
		
	}


	@And("^clicks on checkout button$")
	public void clicksOnCheckoutButton() throws Throwable {
		driver.findElement((By.xpath("//a[@href='checkout.htm']"))).click();
		
	}
	@And("^fills the address and clicks on payment$")
	public void fillsTheAddressAndClicksOnPayment() throws Throwable {
		driver.findElement(By.name("ShippingAdd")).sendKeys("Mumbai");
		driver.findElement((By.xpath("//input[@value='Proceed to Pay']"))).click();
	}


	@Then("^payment should be successful$")
	public void paymentShouldBeSuccessful() throws Throwable {
		String msg=driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[1]/h2")).getText();
		
		Assert.assertEquals(msg, "Welcome to Payment Gateway -");
	
	}


	@Given("^login page$")
	public void loginPage() throws Throwable {
		
	}


	
	
}
