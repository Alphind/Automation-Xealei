/** Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;  

public class BaseClass {

	// Driver initialized in class level
	protected Scenario s;
	// public ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static WebDriver driver;

	/**
	 * To launch the browser that to be automated.
	 * @throws Exception - if the browser value is invalid.
	 */
	public void browserType() throws Exception {
		if (getConfigureProperty("Browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver(getChromeOptions());

		} else if (getConfigureProperty("Browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(getEdgeOptions());

		} else if (getConfigureProperty("Browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(getFirefoxOptions());
		}else {
			throw new Exception("Browser Value is not valid in config.properties file.");
		}
	}

	
	private ChromeOptions getChromeOptions() {
		ChromeOptions chromeOption = new ChromeOptions();
		if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {
			chromeOption.addArguments("--headless", "--window-size=1920,1080");
		}else {
			System.out.println("Running in UI mode.");
		} 
		if(getConfigureProperty("StartMaximized").equalsIgnoreCase("Yes")) {
			chromeOption .addArguments("start-maximized");
		}else {
			System.out.println("Browser not maximized.");
		}
		return chromeOption;
	}
	
	private EdgeOptions getEdgeOptions() {
		EdgeOptions edgeOption = new EdgeOptions();
		if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {
			edgeOption.addArguments("--headless", "--window-size=1920,1080");
		}else {
			System.out.println("Running in UI mode.");
		}
		if(getConfigureProperty("StartMaximized").equalsIgnoreCase("Yes")) {
			edgeOption.addArguments("start-maximized");
		}else {
			System.out.println("Browser not maximized.");
		}
		return edgeOption;
	}
	
	private FirefoxOptions getFirefoxOptions() {
		FirefoxOptions fireFoxOption = new FirefoxOptions();
		if (getConfigureProperty("HeadlessLaunch").equalsIgnoreCase("Yes")) {
			fireFoxOption.addArguments("--headless", "--window-size=1920,1080");
		}else {
			System.out.println("Running in UI mode.");
		}
		if(getConfigureProperty("StartMaximized").equalsIgnoreCase("Yes")) {
			fireFoxOption.addArguments("start-maximized");
		}else {
			System.out.println("Browser not maximized.");
		}
		return fireFoxOption;
	}
	
	// 8. Send the Data's using SENDKEYS

	public void sendKeys(WebElement element, String datasToSend) {
		element.sendKeys(datasToSend);
	}

	// 9. To get the text/data's

	public String getAttribute(WebElement element, String value) {
		String text = element.getAttribute(value);
		return text;
	}

	// 10. To set the timeout for findElement and findElements

	public void implicitWaitBySeconds(long seconds) {
		// dr.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	// 11. Explicit wait - WebDriverWait for alertIsPresent

	public void waitForAlertIsPresent(long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// 12. Explicit wait - WebDriverWait for elementToBeClickable

	public void waitForElementToBeClickable(WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// 13. Screenshot

	public String takesScreenshot(String Name) throws Exception {

		// TakesScreenshot screen = (TakesScreenshot) dr.get();
		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		File destination = new File(".//ExtentReports//Screenshots//" + Name + ".png");
		FileUtils.copyFile(source, destination);
		FileInputStream fis = new FileInputStream(destination);
		byte[] bytes = new byte[(int) destination.length()];
		fis.read(bytes);
		String base64 = new String((bytes));
		fis.close();
		return "data:image/png;base64" + base64;
	}

	// 15. Click

	public void click(WebElement element) {
		element.click();
	}

	public void clickEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
		;
	}

	public void deleteUsingSendKeys(WebElement element) {
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
	}

	// 16. Close

	public void close() {
		// dr.get().close();
		driver.close();
	}

	// 17. Quit

	public void quit() {
		// dr.get().quit();
		driver.quit();
	}

	// 18. readData from Excel

	public String readExcel(String fileName, String sheetName, int rowNum, int cellNum) throws IOException {

		String res = null;
		File file = new File(".//Excel//" + fileName + ".xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);

		CellType cellType = cell.getCellType();

		switch (cellType) {

		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MMM/dd/yy");
				res = dateFormat.format(date);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal b = BigDecimal.valueOf(numericCellValue);
				res = b.toString();
			}
			break;
		default:
			break;
		}
		workbook.close();
		return res;

	}

	// 19. Configuration Property File

	public String getConfigureProperty(String key) {

		try {
			FileInputStream stream = new FileInputStream(".//Configuration Property file//Config.properties");
			Properties properties = new Properties();
			properties.load(stream);
			return properties.get(key).toString();
		}catch(IOException e) {
			e.printStackTrace();
			return "";
		}

	}

	// 20. selectByValue - Select dropDown based on value

	public void selectByValue(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	// 21. selectByIndex - Select dropDown based on Index

	public void selectByIndex(WebElement element, int num) {

		Select select = new Select(element);
		select.selectByIndex(num);
	}

	// 22. selectByVisibleText - Select dropDown based on Text

	public void selectByVisibleText(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// 23. deSelectByVisibleText

	public void deselectByVisibleText(WebElement element, String text) {

		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 24. deSelectByValue

	public void deselectByValue(WebElement element, String value) {

		Select select = new Select(element);
		select.deselectByValue(value);
	}

	// 25. deSelectByIndex

	public void deselectByIndex(WebElement element, int num) {

		Select select = new Select(element);
		select.deselectByIndex(num);
	}

	// 26. explicitWait for element is Clickable

	public void elementIsClickable(WebElement element, long seconds) {

		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// 27. explicitWait for textToBePresentInElement

	public void waitFortextToBePresentInElement(WebElement element, String text, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	// 28. explicitWait for visibilityOfElement

	public void visibilityOfElement(WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// 29. ByCSSSelector

	public WebElement cssSelector(String css) {

		// WebElement element = dr.get().findElement(By.cssSelector(css));
		WebElement element = driver.findElement(By.cssSelector(css));
		return element;
	}

	// 30. findElement --- > ByTagName

	public WebElement findElementByTagName(String tagName) {

		// WebElement element = dr.get().findElement(By.tagName(tagName));
		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}
// 31. findElement --- > xpath
	
	public WebElement findElementByXpath(String xpath) {

		// WebElement elements = dr.get().findElement(By.xpath(xpath));
		WebElement elements = driver.findElement(By.xpath(xpath));
		return elements;
	}
	
	// 31. listOfWebElement --- > ByTagName

	public List<WebElement> findElementsByXpath(String xpath) {

		// List<WebElement> elements = dr.get().findElements(By.xpath(xpath));
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements;
	}

	// 32. String click

	public void selectDropDown(String elementxpath) {
		// click(dr.get().findElement(By.xpath(elementxpath)));
		click(driver.findElement(By.xpath(elementxpath)));
	}

	// 33. Current Date and Time Generator
	public String dateAndTime() {
		DateTimeFormatter Dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String a = "-" + Dtf.format(now);
		return a;
	}

	// 34. Write Data to Excel

	public String writeExcel(String fileName, String sheetname, int cellnum, String newdatacell) throws IOException {

		File file = new File(".//Excel//" + fileName + ".xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		int lastRowNum = sheet.getLastRowNum();
		Row row = sheet.createRow(lastRowNum + 1);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(newdatacell);
		FileOutputStream stream1 = new FileOutputStream(file);
		workbook.write(stream1);
		workbook.close();
		return newdatacell;
	}

	public String writeExcelForSingleRow(String fileName, String sheetname, int rowNum, int cellNum, String newdatacell)
			throws IOException {

		File file = new File(".//Excel//" + fileName + ".xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(newdatacell);
		FileOutputStream stream1 = new FileOutputStream(file);
		workbook.write(stream1);
		workbook.close();
		return newdatacell;
	}

	public String writeExcelLastRow(String fileName, String sheetname, int cellnum, String newdatacell)
			throws IOException {

		File file = new File(".//Excel//" + fileName + ".xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		int lastRowNum = sheet.getLastRowNum();
		Row row = sheet.getRow(lastRowNum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(newdatacell);
		FileOutputStream stream1 = new FileOutputStream(file);
		workbook.write(stream1);
		workbook.close();
		return newdatacell;
	}

	// 35.getText

	public String getText(WebElement updatedSuiteName) {

		String text = updatedSuiteName.getText();
		return text;
	}

	// 36. Robot key ---> KeyPress

	public void keyPress(int keyCode) throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(keyCode);
	}

	// 37. Robot key ---> keyRelease

	public void keyRelease(int keyCode) throws AWTException {

		Robot robot = new Robot();
		robot.keyRelease(keyCode);
	}

	// 38. sendKeysWithEnter

	public void sendKeyWithEnter(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);

	}

	// 39. Submit

	public void submit(WebElement element) {
		element.submit();
	}

	// 40. Explicit wait - WebDriverWait for VisiblityOfElement

	public void waitForVisiblityOfElement(WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// 41. getText - String

	public String getTextString(String elementxpath) {
		// String text = getText(dr.get().findElement(By.xpath(elementxpath)));
		String text = getText(driver.findElement(By.xpath(elementxpath)));
		return text;
	}

	// 42. Wait for Loading

	public void waitForPageLoad() {

//		WebElement loading = dr.get().findElement(By.xpath("//div[contains(text(),'Loading')]"));
//		WebDriverWait wait = new WebDriverWait(dr.get(), Duration.ofMinutes(3));
		WebElement loading = driver.findElement(By.xpath("//div[contains(text(),'Loading')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.invisibilityOf(loading));

	}

	// 43. Thread-Sleep

	public void sleep(long millis) {

		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	// 44. Robot class for upload photo

	public void uploadImage(String imagePath) {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	
	public void cleanRecordFromDB(boolean CleanRecord, String collectionName, String key, String value) {

		if (CleanRecord == true) {

//			// ************* MongoDB deployment's connection string *************
			String uri = "mongodb+srv://adminXealei:hNntCLqUSkTxbJel@xealei-qa.1of90.mongodb.net"
					+ "/xealeiqa?retryWrites=true&w=majority";

			MongoClient mongoClient = MongoClients.create(uri);

//			// ************* Create one Collection *************
			MongoDatabase db = mongoClient.getDatabase("xealeiqa");

//			//************* To delete particular document *************
			db.getCollection(collectionName).findOneAndDelete(Filters.eq(key, value));
			System.out.println("Document deleted successfully..!");

		}
	}

//		// 40. Explicit wait - WebDriverWait for inVisiblityOfElement

	public void waitForInVisiblityOfElement(WebElement element, long seconds) {
		// WebDriverWait wait = new WebDriverWait(dr.get(),
		// Duration.ofSeconds(seconds));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

//     //  41. Clear Text

	public void clearText(WebElement element) {
		element.clear();
	}
	
//	     //  43. Environment set up

	public void env() throws Exception {

		if (getConfigureProperty("Environment").equalsIgnoreCase("QA")) {
			// dr.get().get(readExcel("Test Datas", "Environments",1,1));
			driver.get(readExcel("Test Datas", "Environments", 1, 1));
		} else if (getConfigureProperty("Environment").equalsIgnoreCase("PREPROD")) {
			// dr.get().get(readExcel("Test Datas", "Environments",2,1));
			driver.get(readExcel("Test Datas", "Environments", 2, 1));
		} else if (getConfigureProperty("Environment").equalsIgnoreCase("PROD")) {
			// dr.get().get(readExcel("Test Datas", "Environments",3,1));
			driver.get(readExcel("Test Datas", "Environments", 3, 1));
		}else {
			throw new Exception("Environment Value is not valid in config.properties file.");
		}
	}

//	     //  44. get Current URL

	public String getCurrentUrl() {

		// String currentUrl = dr.get().getCurrentUrl();
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

//		// 45. Scroll Down - (JavaScript Executor)

	public void scrollDownToAnElement(WebElement element) {

		// JavascriptExecutor executor = (JavascriptExecutor)dr.get();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView()", element);
	}

//		// 46. Scroll Bottom of the page - (JavaScript Executor)

	public void scrollDownToBottomOfThePage() {

		// JavascriptExecutor executor = (JavascriptExecutor)dr.get();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void TabUsingSendKeys(WebElement element) {

		element.sendKeys(Keys.ENTER);
	}

//      //48. Click Using - JavaScript Executor

	public void jsExecutorClick(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

//      //49. Full Page Load - getPageLoad

	public void waitForFullPageElementLoad() {

		driver.manage().timeouts().getPageLoadTimeout();
	}

}
