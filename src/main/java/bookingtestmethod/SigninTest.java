package bookingtestmethod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import bookingHomePage.Homepage;
import bookingHomePage.Signinpage;

/**
 * This class is used to load the driver and to test the test cases
 * 
 * @author
 * @param 
 *
 */
public class SigninTest extends BaseClass {

	Homepage home = new Homepage(driver);
	Signinpage page = new Signinpage(driver);

	/**
	 * This is a method to test a scenario of the booking.com
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
//	@DataProvider(name = "signindata")
	//public Object[][] testdata() { 

	//	return new Object[][] { { "aishwaryarana@gmail.com", "ranarana" } };
	

	@Test
	public void bookingDemo() throws FileNotFoundException, IOException  {

		driver.get(getProperty("prod"));
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	//	Thread.sleep(2000);
		
		
		
		}

	

			/*
		 * click(home.signin); setValue(page.id,"aishwaryarana@gmail.com");
		 * click(page.continueEmail); setValue(page.passsword,"Ravindra1@");
		 * click(page.login); click(home.type);
		 */
        
        
		
		//Assert.assertEquals(page.invalidMail.isDisplayed(), true);
	
		
		//screenShot();
	}// method
// Class
