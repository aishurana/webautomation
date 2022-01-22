package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriverWait wait;

	public static ExtentReports report;

	public static ExtentTest Logger;

	public static ExtentSparkReporter sparkReporter;

	public static String filePath;

	@BeforeTest
	public void setup() {

		filePath = "Reports/statusReport.html";

		sparkReporter = new ExtentSparkReporter(filePath);

		report = new ExtentReports();

		report.attachReporter(sparkReporter);

	}

	static {

		// Which browser we are going to automate
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\eclipse-workspace\\webautomation\\src\\test\\resources\\drivers\\chromedriver.exe"); // Chrome

		ChromeOptions options = new ChromeOptions();

		options.addArguments("start-maximized");
		options.addArguments("--incognito");
		options.addArguments("disable-popup-blocking");
		options.addArguments("disable-notifications");

		driver = new ChromeDriver(options);
	}

	/*
	 * public void printWebElements() {
	 * 
	 * List<WebElement> ele
	 * =driver.findElements(By.xpath("//div[@data-testid='title']"));
	 * 
	 * WebElement a; for (int i=9; i<ele.size();i--){ a= ele.get(i);
	 * System.out.println(a.getText());
	 */

	// for(int i=0;i<ele.size() {

	public String getProperty(String key) throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		/**
		 * To read the file we have to give the path
		 */
		File f = new File("src/test/resources/application.properties");

		prop.load(new FileInputStream(f)); // load is to read the property file

		return prop.getProperty(key);
	}

	public void screenShot() throws IOException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");

		String date = dateFormat.format(new Date());

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(f, new File("./Screenshots/" + date + ".png"));

	}

	public void click(WebElement e) {

		e.click();
	}

	public void setValue(WebElement e, String value) {

		e.clear();
		e.sendKeys(value);
	}

	public void waitForElement(WebElement e) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public static void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}

	public static void defaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void selectElementByValue(WebElement day, String value) {

		Select select = new Select(day);
		select.selectByValue("value");
	}

	public static void selectElementByText(WebElement month, String text) {

		Select select = new Select(month);
		select.selectByVisibleText("text");
	}

	public static void selectElementByValue1(WebElement year, String value) {

		Select select = new Select(year);
		select.selectByValue("value");
	}

	public void addChilds(WebElement e, int count) {

		while (count > 0) {

			e.click();

			count--;

		}
	}

	public void printElementsText(List<WebElement> elements) {

		for (WebElement e : elements) {
			System.out.println(e.getText());
		}
	}

	public void dragAndDrop(WebElement drag, WebElement drop) {

		Actions action = new Actions(driver);

		action.dragAndDrop(drag, drop).perform();

	}

	public void moveAndClick(WebElement e1, WebElement e2) {

		Actions action = new Actions(driver);
		action.moveToElement(e1).click(e2).build().perform();
		action.doubleClick().perform();

	}

	public void switchToChildWindowCloseParent(String parent) {

		Set<String> windows = driver.getWindowHandles(); // to get all open window
		for (String window : windows) // to navigate to all windows
		{
			if (!window.equals(parent)) {

				driver.switchTo().window(window);
				driver.switchTo().window(parent);

				driver.close();
				driver.switchTo().window(window);

			}
		}

	}

	/**
	 * Already with the same name we have a method[screenshot] so we need a another
	 * method with same name[screenshot] So this concept is called Method over
	 * loading[Static Binding] means method name will be same but the arguments
	 * differ.
	 * 
	 * @param status
	 * @param name
	 * @throws IOException
	 */
	public void screenShot(String status, String name) throws IOException {

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		if (status.equalsIgnoreCase("FAILURE")) {
			FileUtils.copyFile(f, new File("./FailureScreenshots/" + name + ".png"));

		} else if (status.equalsIgnoreCase("SUCCESS")) {
			FileUtils.copyFile(f, new File("./SuccessScreenshots/" + name + ".png"));
		}
	}

	/**
	 * ITestResult is a interface if a method pass,fail,skip whatever the properties
	 * It will appear in this interface result[Every test result value will appear
	 * in this result]
	 * 
	 * @param result
	 * @throws IOException
	 */
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {
			screenShot("FAILURE", result.getName());

			Logger.fail(result.getName() + " is failed !!!");

		} else {
			screenShot("SUCCESS", result.getName());

			//Logger.pass(result.getName() + " is passed !!!");
			
			Logger.log(Status.PASS, result.getName()+ " is passed !!!");
		}

	}

	public void scrollToElement(WebElement e) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);

	}

	public static String[][] getExcelData(String filename, String sheet) throws IOException {

		FileInputStream fis = new FileInputStream(filename);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sh = wb.getSheet(sheet);

		int rows = sh.getLastRowNum();

		int cols = sh.getRow(0).getLastCellNum();

		String[][] data = new String[rows][cols];

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {

				Cell c = sh.getRow(i).getCell(j);

				DataFormatter dataformatter = new DataFormatter();

				String value = dataformatter.formatCellValue(c);

				data[i - 1][j] = value;
			}
		}

		return data;
	}

	@AfterTest
	public void aftertest() {
		System.out.println("im a after test");

		report.flush();

		driver.close();
	}

}
