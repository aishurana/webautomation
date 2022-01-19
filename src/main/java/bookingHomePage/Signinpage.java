package bookingHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This class will store all the locators and methods in sign in page
 *
 */

public class Signinpage {

	public WebDriver driver;

	public Signinpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This POM is to find the Web Elements for sign in page / Page object model is a
	 * Design pattern
	 */

	@FindBy(name = "username")
	public WebElement id;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement continueEmail;
	
	//@FindBy(name="new_password")
 //    public WebElement firstPassword;

//	 @FindBy(name="confirmed_password")
//	 public WebElement secondPassword;

//	 @FindBy(xpath="//button[@type='submit']")
//	 public WebElement submit;

	@FindBy(id = "password")
	public WebElement passsword;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement login;
	
	
//	@FindBy(name="new_password")
	// public WebElement firstPassword;

	// @FindBy(name="confirmed_password")
	// public WebElement secondPassword;

	// @FindBy(xpath="//button[@type='submit']")
	// public WebElement submit;

}
