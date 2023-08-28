package org.alphind.xealei.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// Driver initialized in class level

	public static WebDriver driver;

	// 1. To set the browser

	public void browserType(String browser) {

		if (browser.equalsIgnoreCase("CHROME")) {
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("EDGE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}

	// 2. To launch the URL

	public void loadUrl(String Url) {
		driver.get(Url);
	}

	// 3. Maximize Window

	public void maximize() {
		driver.manage().window().maximize();
	}

	// 4. To find the element by using ID

	public WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	// 5. To find the element by using NAME

	public WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	// 6. To find the element by using CLASSNAME

	public WebElement findElementByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}

	// 7. To find the element by using XPATH

	public WebElement xpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	// 11. Explicit wait - WebDriverWait for alertIsPresent

	public void waitForAlertIsPresent(long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// 12. Explicit wait - WebDriverWait for elementToBeClickable

	public void waitForElementToBeClickable(WebElement element, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// 13. Screenshot

	public void takesScreenshot(String Name) throws Exception {

		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Xealei Automation\\Xealei\\target\\Screenshots\\" + Name + ".png");
		FileUtils.copyFile(source, destination);
	}

//	// 14. Screenshot for Report
//
//	public Scenario takesScreen(Scenario sc) {
//
//		TakesScreenshot screen = (TakesScreenshot) driver;
//		byte[] source = screen.getScreenshotAs(OutputType.BYTES);
//		sc.embed(source, "Every Scenario");
//		return sc;
//	}

	// 15. Click

	public void click(WebElement element) {
		element.click();
	}

	// 16. Close

	public void close() {
		driver.close();
	}

	// 17. Quit

	public void quit() {
		driver.quit();
	}

	// 18. readData from Excel

	public String readData(String pathName, String sheetName, int rowNum, int cellNum) throws IOException {

		String res = null;
		File file = new File("C:\\Xealei Automation\\Xealei\\src\\test\\resources\\Excel\\" + pathName + ".xlsx");
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

	public String getConfigureProperty(String key) throws Exception {

		FileInputStream stream = new FileInputStream(
				"C:\\Xealei Automation\\Xealei\\src\\test\\resources\\Configuration\\Config.properties");
		Properties properties = new Properties();
		properties.load(stream);
		return properties.get(key).toString();
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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// 27. explicitWait for textToBePresentInElement

	public void waitFortextToBePresentInElement(WebElement element, String text, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	// 28. explicitWait for visibilityOfElement

	public void visibilityOfElement(WebElement element, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// 29. ByCSSSelector

	public WebElement cssSelector(String css) {

		WebElement element = driver.findElement(By.cssSelector(css));
		return element;
	}

	// 30. findElement --- > ByTagName

	public WebElement findElementByTagName(String tagName) {

		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}

	// 31. listOfWebElement --- > ByTagName

	public List<WebElement> findElementsByXpath(String xpath) {

		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements;
	}

	// 32. String click

	public void clickXpath(String elementxpath) {
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

	public void writeData(String fileName, String sheetname, int rownum, int cellnum, String newdatacell)
			throws IOException {

		File file = new File("C:\\Xealei Automation\\Xealei\\src\\test\\resources\\Excel\\" + fileName + ".xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(newdatacell);
		FileOutputStream stream1 = new FileOutputStream(file);
		workbook.write(stream1);
		workbook.close();
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// 41. getText - String

	public void getTextString(String elementxpath) {
		getText(driver.findElement(By.xpath(elementxpath)));
	}

	// 42. Wait for Loading

	public void waitForPageLoad() {

			WebElement loading = driver.findElement(By.xpath("//div[contains(text(),'Loading')]"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

}
