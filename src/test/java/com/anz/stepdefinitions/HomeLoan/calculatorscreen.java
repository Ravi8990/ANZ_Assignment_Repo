package com.anz.stepdefinitions.HomeLoan;

import org.openqa.selenium.WebDriver;
import com.anz.generic.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class calculatorscreen extends DriverFactory {

	WebDriver driver = DriverFactory.driver;
	

	public static String HL_ApplicationType = null;
	public static String HL_Dependents = null;
	public static String HL_Propertytolivein = null;
	public static String HL_Yourincome = null;
	public static String HL_otherincome = null;
	public static String HL_Livingexpenses = null;
	public static String HL_Currentrepayments = null;
	public static String HL_Otherloanrepayments = null;
	public static String HL_Othercommitments = null;
	public static String HL_Totalcreditcardlimits = null;

	@Given("Verify landing page of Home Loan Borrowing calculator screen")
	public void verify_landing_page_of_Home_Loan_Borrowing_calculator_screen() {

		HomeloancalculatorscreenPage.verifyhomeheader();

	}

	@When("User enter valid details {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_enter_valid_details(String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9, String string10) {
		HL_ApplicationType = string;
		HL_Dependents = string2;
		HL_Propertytolivein = string3;
		HL_Yourincome = string4;
		HL_otherincome = string5;
		HL_Livingexpenses = string6;
		HL_Currentrepayments = string7;
		HL_Otherloanrepayments = string8;
		HL_Othercommitments = string9;
		HL_Totalcreditcardlimits = string10;
		HomeloancalculatorscreenPage.userentershomeloandata();

	}

	@And("Click on Work out how much I could borrow button and Verif Home Loan Borrowing estimation")
	public void verif_Borrowing_estimate() {
		HomeloancalculatorscreenPage.verifyhomeloanestimation();
		System.out.println("******************************");
		System.out.println("Test 1 Passed successfully");
		System.out.println("******************************");
	}
	
	
	@When("User click on Startover button")
	public void user_click_on_Startover_button() {
		HomeloancalculatorscreenPage.clickonstartoverbutton();
		System.out.println("******************************");
		System.out.println("Test 2 Passed successfully");
		System.out.println("******************************");
	   
	}
	@Given("User should be on Home Loan Borrowing calculator screen")
	public void user_should_be_on_Home_Loan_Borrowing_calculator_screen() {
		HomeloancalculatorscreenPage.verifyhomeheader();
	  
	}

	@When("User enter valid Details {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_enter_valid_Details(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
		HL_ApplicationType = string;
		HL_Dependents = string2;
		HL_Propertytolivein = string3;
		HL_Yourincome = string4;
		HL_otherincome = string5;
		HL_Livingexpenses = string6;
		HL_Currentrepayments = string7;
		HL_Otherloanrepayments = string8;
		HL_Othercommitments = string9;
		HL_Totalcreditcardlimits = string10;
		HomeloancalculatorscreenPage.userentershomeloandata();
	}

	@Then("Verify the error Message")
	public void verify_the_error_Message() {
		HomeloancalculatorscreenPage.verifymessage();
		System.out.println("******************************");
		System.out.println("Test 3 Passed successfully");
		System.out.println("******************************");
	  
	}

}
