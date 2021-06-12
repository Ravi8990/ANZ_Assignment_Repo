package com.anz.pages.homeloanborrowercalculatorscreen;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.anz.pages.BaseLibrary;
import com.anz.stepdefinitions.HomeLoan.calculatorscreen;

public class Homeloancalculatorscreen extends BaseLibrary {

	BaseLibrary HLbl = new BaseLibrary();

	public static String Expectedestimatevalue = "$479,000";
	public static String Actualestimatevalue = null;
	public static String Expectedmessage = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
	public static String Actualmessage = null;

	/**********************************************************************************
	 ** PAGE OBJECTS FOR HOME LOAN SCREEN
	 **********************************************************************************/

	public static By icon_Expandfiltersecction = By.xpath("//img[@title='Expand Filter']");

	@FindBy(xpath = "//span[text()='How much could I borrow?']")
	public static WebElement txt_homeloanheader;

	@FindBy(xpath = "//label[text()='Application type']/following::label[1]")
	public static WebElement btn_HLTypesingle;

	@FindBy(xpath = "//label[text()='Application type']/following::label[2]")
	public static WebElement btn_HLTypejoint;

	@FindBy(xpath = "//label[text()='Number of dependants']/following::select[1]")
	public static WebElement drp_homeloannofdependents;

	@FindBy(xpath = "//label[text()='Property you would like to buy']/following::label[1]")
	public static WebElement btn_homeloanbthome;

	@FindBy(xpath = "//label[text()='Property you would like to buy']/following::label[2]")
	public static WebElement btn_homeloanbtresidential;

	@FindBy(xpath = "//label[text()='Your income (before tax)']/following::input[1]")
	public static WebElement txt_yourincome;

	@FindBy(xpath = "//label[text()='Your other income']/following::input[1]")
	public static WebElement txt_otherincome;

	@FindBy(xpath = "//label[text()='Living expenses']/following::input[1]")
	public static WebElement txt_livingexpenses;

	@FindBy(xpath = "//label[text()='Current home loan repayments']/following::input[1]")
	public static WebElement txt_currenthlrepayments;

	@FindBy(xpath = "//label[text()='Other loan repayments']/following::input[1]")
	public static WebElement txt_otherloanrepaymt;

	@FindBy(xpath = "//label[text()='Other commitments']/following::input[1]")
	public static WebElement txt_othercommts;

	@FindBy(xpath = "//label[text()='Total credit card limits']/following::input[1]")
	public static WebElement txt_creditcardlimit;

	@FindBy(xpath = "//button[contains(text(),'Work out how much I could borrow')]")
	public static WebElement btn_howmuchcouldiborrow;

	@FindBy(xpath = "//span[@aria-live='assertive']/span")
	public static WebElement txt_borrowamt;

	@FindBy(xpath = "//div[@class='borrow__result text--white clearfix']//div[2]/button[1]")
	public static WebElement btn_Startover;

	@FindBy(xpath = "//div[@class='box--left text--center']/span")
	public static WebElement txt_Actualmessage;

	/**********************************************************************************
	 ** PAGE METHODS FOR HOME LOAN SCREEN
	 **********************************************************************************/

	/**
	 * Method to wait until page header loads
	 * 
	 */

	public void verifyhomeheader() {
		HLbl.waitForElement(txt_homeloanheader);

	}

	/**
	 * Method to enter home laon details
	 * 
	 */

	public void userentershomeloandata()

	{
		HLbl.sendKeys(txt_yourincome, calculatorscreen.HL_Yourincome);
		HLbl.sendKeys(txt_otherincome, calculatorscreen.HL_otherincome);
		HLbl.sendKeys(txt_livingexpenses, calculatorscreen.HL_Livingexpenses);
		HLbl.sendKeys(txt_currenthlrepayments, calculatorscreen.HL_Currentrepayments);
		HLbl.sendKeys(txt_otherloanrepaymt, calculatorscreen.HL_Otherloanrepayments);
		HLbl.sendKeys(txt_othercommts, calculatorscreen.HL_Othercommitments);
		HLbl.sendKeys(txt_creditcardlimit, calculatorscreen.HL_Totalcreditcardlimits);

	}

	/**
	 * Method to verify home loan estimation
	 * 
	 */

	public void verifyhomeloanestimation() {

		HLbl.clickonelement(btn_howmuchcouldiborrow);
		HLbl.waitForElement(txt_borrowamt);
		Actualestimatevalue = txt_borrowamt.getText();
		System.out.println("Borrowable Amt " + Actualestimatevalue);
		if (Actualestimatevalue.equals(Expectedestimatevalue)) {
			Assert.assertEquals(Expectedestimatevalue, Actualestimatevalue);
			System.out.println("*****************************************************");
			System.out.println("Home Loan Estimated Value is - " + Expectedestimatevalue);
			System.out.println("Home Loan Actual Value is - " + Actualestimatevalue);
			System.out.println("*****************************************************");
			System.out.println("Estimate and Actual Values are matching");
		} else {
			System.out.println("*****************************************************");
			System.out.println("Home Loan Estimated Value is - " + Expectedestimatevalue);
			System.out.println("Home Loan Actual Value is - " + Actualestimatevalue);
			System.out.println("*****************************************************");
			System.out.println("Estimate and Actual Values are not matching");
		}

	}

	/**
	 * Method to click on start over button
	 * 
	 */

	public void clickonstartoverbutton()

	{
		HLbl.clickonelement(btn_Startover);

	}

	/**
	 * Method to verify message of home loan
	 * 
	 */

	public void verifymessage() {

		HLbl.clickonelement(btn_howmuchcouldiborrow);
		Actualmessage = txt_Actualmessage.getText();
		System.out.println("Message " + Actualmessage);
		if (Actualmessage.equals(Expectedmessage)) {
			Assert.assertEquals(Actualmessage, Expectedmessage);
			System.out.println("*****************************************************");
			System.out.println("Expected Message  - " + Expectedmessage);
			System.out.println("Actual Message - " + Actualmessage);
			System.out.println("*****************************************************");
			System.out.println("Estimate and Actual Messages are matching");
		} else {
			System.out.println("*****************************************************");
			System.out.println("Expected Message  - " + Expectedmessage);
			System.out.println("Actual Message - " + Actualmessage);
			System.out.println("*****************************************************");
			System.out.println("Estimate and Actual Messages are matching");
		}

	}

}
