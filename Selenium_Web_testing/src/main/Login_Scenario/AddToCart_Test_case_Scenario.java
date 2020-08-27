package Login_Scenario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart_Test_case_Scenario {

	WebDriver driver;
	POM_Reusable_Functions objLogin;
	Properties load_configuration_details;

	@BeforeTest
	private void connect_driver() throws IOException {
		load_configuration_details = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\application.properties");
		load_configuration_details.load(file);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(load_configuration_details.getProperty("Url"));

	}

	@Test(priority = 0)
	private void test_connect_to_Login() throws InterruptedException {
		// Create Login Page object
		objLogin = new POM_Reusable_Functions(driver,load_configuration_details);
		// Verify login page title
		objLogin.verify_page_tile(load_configuration_details.getProperty("verify_title"));
		// login to application
		objLogin.clickSignin();
		objLogin.implicit_wait(50);
		// Fill user name
		objLogin.setUserName(load_configuration_details.getProperty("UserName"));
		// Click continue button
		objLogin.getContinueButton();
		objLogin.implicit_wait(50);
		// Fill password
		objLogin.setPassword(load_configuration_details.getProperty("password"));
		// Click Login button
		objLogin.clickLogin();
		objLogin.implicit_wait(50);
		// Wait to enter the OTP verification
		// to find the search bar and enter the keyword
		objLogin.find_SearchBox_KeywordSearch();
		// Wait for the results to appear
		objLogin.implicit_wait(20);
		objLogin.Click_the_product_from_Results();
		objLogin.Add_to_Cart();
		objLogin.implicit_wait(20);
		objLogin.Checkout();
		objLogin.implicit_wait(20);
		objLogin.navigate_back();
		objLogin.implicit_wait(20);
		objLogin.sign_out();
		objLogin.close_driver();
		
		}
//	@AfterTest
//	private void wrap_up() {
//		
//	}
}
