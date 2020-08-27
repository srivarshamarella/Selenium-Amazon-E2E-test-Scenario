
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class POM_Reusable_Functions {

	WebDriver driver;
	// Sign in button in home page
	By signin;
	// Username field
	By userName;
	// continue button after entering username
	By continue_Button;
    //Password field
	By password ;
	//Click on Submit login button
	By login;
	//search box in home page
	By SearchBox;
	//Enter the search button
	By searchBox_submitButton;
	//Enter the keyword
	String keyword;
	//search the keyword linktext
	By Keyword_linktext;
	//Click add to cart button beside item
	By add_to_cart_button;
	//Click on checkout order button
	By checkout_order_button;
	//Click on sign out button in the account dropdown box
	By signout;

	public POM_Reusable_Functions(WebDriver driver, Properties load_configuration_details) {

		this.driver = driver;
		// Sign in button in home page
		this.signin = By.xpath(load_configuration_details.getProperty("sign_in_button"));
		// Username field
		this.userName = By.xpath(load_configuration_details.getProperty("username_xpath"));
		// continue button after entering username
		this.continue_Button = By.id(load_configuration_details.getProperty("continue_Button"));
	    //Password field
		this.password = By.name(load_configuration_details.getProperty("password_name"));
		//Click on Submit login button
		this.login = By.id(load_configuration_details.getProperty("login"));
		//search box in home page
		this.SearchBox = By.cssSelector(load_configuration_details.getProperty("SearchBox"));
		//Enter the search button
		this.searchBox_submitButton = By.className(load_configuration_details.getProperty("searchBox_submitButton"));
		//Enter the keyword
		this.keyword=load_configuration_details.getProperty("keyword");
		//search the keyword linktext
		this.Keyword_linktext = By
				.linkText(load_configuration_details.getProperty("Keyword_linktext"));
		//Click add to cart button beside item
		this.add_to_cart_button = By.xpath(load_configuration_details.getProperty("add_to_cart_button"));
		//Click on checkout order button
		this.checkout_order_button = By.id(load_configuration_details.getProperty("checkout_order_button"));
		//Click on sign out button in the account dropdown box
		this.signout = By.xpath(load_configuration_details.getProperty("signout"));
	}

	public void clickSignin() {

		this.driver.findElement(signin).click();

	}
	// Set user name in textbox

	public void setUserName(String strUserName) {

		this.driver.findElement(userName).sendKeys(strUserName);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		this.driver.findElement(password).sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		this.driver.findElement(login).click();

	}

	// Get the title of Login Page

	public String getLoginTitle() {

		return this.driver.getTitle();

	}
	// Get the title of Login Page

	public void getContinueButton() {
		this.driver.findElement(continue_Button).click();
	}

	public void implicit_wait(int time_seconds) {
		this.driver.manage().timeouts().implicitlyWait(time_seconds, TimeUnit.SECONDS);
	}

	public void find_SearchBox_KeywordSearch() {

		this.driver.findElement(SearchBox).sendKeys(keyword);
		this.driver.findElement(searchBox_submitButton).click();
	}

	public void Click_the_product_from_Results() {
		this.driver.findElement(Keyword_linktext).click();
	}

	public void Add_to_Cart() {
		this.driver.findElement(add_to_cart_button).click();
	}

	public void Checkout() {
		this.driver.findElement(checkout_order_button).click();
	}

	public void navigate_back() {

		this.driver.navigate().back();
	}

	public void sign_out() throws InterruptedException {

		this.implicit_wait(20);
		this.driver.findElement(signout).click();
		Thread.sleep(500);
		
	}
	
	public void verify_page_tile(String verifyTitle) {
		// TODO Auto-generated method stub
		String loginPageTitle = this.getLoginTitle();
		Assert.assertTrue(loginPageTitle.toLowerCase().contains(verifyTitle));
	}
	public void close_driver(){
		this.driver.close();
	}

}