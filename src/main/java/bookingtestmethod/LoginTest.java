package bookingtestmethod;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import bookingHomePage.Homepage;
import bookingHomePage.Signinpage;
import utils.ExcelUtils;

/**
 * This class is used to load the driver and to test the test cases
 * 
 * @author
 *
 */
public class LoginTest extends BaseClass {

	Homepage home = new Homepage(driver);
	Signinpage page = new Signinpage(driver);

	/**
	 * This is a method to test a scenario of the booking.com
	 * 
	 */
	/*
	 *  @DataProvider(name = "testdata") 
	 *  public Object[][] readData() throws Exception {
	 * 
	 *  Object[][] testData = ExcelUtils.getDataFromExcel(getProperty("excel"),"login",m.getName()); // Arguments are file name, sheet name
	 *   return testData;  }
	 */
	
	   @DataProvider(name = "testdata") 
	   public Object[][] readData(Method m) throws Exception {
	  
	   Object[][] testData = ExcelUtils.getDataFromExcel(getProperty("excel"),"data",m.getName()); // Arguments are file name, sheet name
	   
	        return testData;  
	   }
	 
	
	   @Test(dataProvider="testdata",priority=2) 
	   public void facebook(HashMap<String,String> data) throws FileNotFoundException, IOException  {
		   
	   Logger = report.createTest("facebook create account");
	  
	   driver.get(getProperty("fb"));
	   
	   Logger.info("navigated to website"+ driver.getTitle());
	   
	   click(home.createAccount);
	   
	   waitForElement(home.firstname);
	   
	   setValue(home.firstname,data.get("first"));
	   
	   setValue(home.lastname,data.get("last"));
	   
	   setValue(home.email,data.get("email"));
	   
	   setValue(home.password,data.get("password"));
	   
	   }
	 
	@Test(dataProvider="testdata",priority=1)
	public void booking(HashMap<String,String> data) throws FileNotFoundException, IOException, InterruptedException {
		
		Logger = report.createTest("Booking website checkin date");

		driver.get(getProperty("prod"));
		
		Logger.info("navigated to website"+ driver.getTitle());
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		click(home.date);
		click(home.getCheckin(data.get("date")));
		
		
		
		
		
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * click(home.searchCity); waitForElement(home.searchCity);
		 * setValue(home.searchCity,data.get("Hyderabad")); Thread.sleep(2000);
		 */
			/*
			 * Thread.sleep(2000); waitForElement(home.searchCity);
			 * moveAndClick(home.cityName,home.cityName); Thread.sleep(2000);
			 * click(home.checkin); Thread.sleep(2000);
			 * moveAndClick(home.datein,home.datein);
			 * moveAndClick(home.dateout,home.dateout); Thread.sleep(2000);
			 * click(home.adultIcon); moveAndClick(home.clickbutton,home.clickbutton);
			 * Thread.sleep(2000); moveAndClick(home.rooms,home.rooms); click(home.search);
			 * Thread.sleep(3000);
			 */
		//  printElementsText(home.hotelNames);
		//  moveAndClick(home.availability,home.availability);
		 // switchToChildWindowCloseParent();
	
	}

	

	}


		
	
		
		
		

		
		
		
		
		
		
	//	page.id.sendKeys("aishwary@gmail.com");
	//	//click(page.continueEmail);
//		page.passsword.sendKeys("ranarana");
	//	click(page.password);
		
	

	




