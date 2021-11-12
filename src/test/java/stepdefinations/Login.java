package stepdefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.Myaccountpage;
import resources.base;

public class Login extends base {

	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	Myaccountpage myaccountpage;

	@Given("^open application$")
	public void open_application() throws IOException {
		driver = intializeDriver();
	}

	@And("^I navigated to Login page$")
	public void I_navigated_to_Login_page() {
		driver.get(prop.getProperty("url"));
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginButton().click();
	}

	@When("^I enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void i_enter_username_as_something_and_password_as_something(String email, String password) {
		loginPage = new LoginPage(driver);
		loginPage.emailidfield().sendKeys(email);
		loginPage.passwordfield().sendKeys(password);
	}

	@And("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		loginPage.loginicon().click();
	}

	@Then("^User should able to see Successfull status *")
	public void User_should_able_to_see_Successfull_status() {
		myaccountpage = new Myaccountpage(driver);
		Assert.assertTrue(myaccountpage.accountOption().isDisplayed());
	}

	@After
	public void closure() {
		driver.close();
	}

}
