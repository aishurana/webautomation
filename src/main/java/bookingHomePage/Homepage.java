package bookingHomePage;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This class will store all the locators and methods in sign in page
 *
 */
 public class Homepage {

	public WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	   * This POM is to find the Web Elements for home page (Page object model) is a
	 * Design pattern
	 */
	
	
	@FindBy(xpath="//input[@id='ss']")
	public WebElement searchCity;
	
	@FindBy(xpath="(//span[contains(text(),'Hyderabad')])/..")
	public WebElement cityName;
	
	@FindBy(xpath="(//div[contains(text(),'Check-in')])[1]/..")
	public WebElement checkin;
	
	@FindBy(xpath="(//div[@class='bui-calendar__wrapper'])[2]//tbody/tr[1]//td//span[text()='1']")
	public WebElement datein;
	
	@FindBy(xpath="(//div[@class='bui-calendar__wrapper'])[2]//tbody/tr[2]//td//span[text()='12']")
	public WebElement dateout;
	
	@FindBy(xpath="//span[contains(text(),'2 adults')]")
	public WebElement adultIcon;
		
	@FindBy(xpath="(//span[contains(text(),'+')])[2]/..")
	public WebElement clickbutton;
	
	@FindBy(xpath="(//span[contains(text(),'+')])[4]/..")
	public WebElement rooms;
	
	@FindBy(xpath="(//span[contains(text(),'Search')])[1]/..")
	public WebElement search;
	
	@FindBy(xpath="(//span[contains(text(),'See availability')])[1]/..")
	public WebElement availability;
	
	@FindBy(xpath="//div[@data-testid='title']")
	public List<WebElement> hotelNames;
	
	@FindBy(xpath="//a[text()='Create New Account']")
	public WebElement createAccount;
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @FindBy(xpath = "(//span[contains(text(),'Sign in')])[1]/..") public
	 * WebElement signin;
	 * 
	 * @FindBy(xpath = "//div[@class='bui-header__main']") public WebElement
	 * Account;
	 */
	/*
	 * @FindBy(xpath="(//span[contains(text(),'Type your destination')])[1]/..")
	 * public WebElement searchCity;
	 * 
	 * @FindBy(xpath="(//span[contains(text(),'Hyderabad')])[1]") public WebElement
	 * cityName;
	 */
	
	
	
}

