package com.omrbranch.day10;
import java.awt.desktop.QuitEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Enter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseClass {
	WebDriver driver;
	Select select;
	JavascriptExecutor executor;
	Actions actions;
	
	public void createCellAndSetData(String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\Users\\mathi\\eclipse-workspace-Selenium\\FrameWorkClass-Mathiyazhagan\\Excel sheet\\Test Data Mathi.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	public void updateCellData(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {
		File file = new File("C:\\Users\\mathi\\eclipse-workspace-Selenium\\FrameWorkClass-Mathiyazhagan\\Excel sheet\\Test Data Mathi.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
		String res = null;

		File file = new File("C:\\Users\\mathi\\eclipse-workspace-Selenium\\FrameWorkClass-Mathiyazhagan\\Excel sheet\\Test Data Mathi.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (round == numericCellValue) {
					res = String.valueOf(round);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}

		default:
			break;
		}
		return res;

	}


//Q1,Q2,Q3,Q4
	public void browserLaunch(String browserType) {

		switch (browserType) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}

//Q5
	public void enterApplnUrl(String url) {
		driver.get(url);

	}

//Q6
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

//Q7
	public void elementSendKeys(WebElement element, String data) {
		visibilityOfElement(element);

		if (elementIsDisplayed(element) && elementIsEnabled(element)) {

			element.sendKeys(data);
		}
	}

//Q8
	public void elementClick(WebElement element) {
		visibilityOfElement(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.click();
		}
	}
//Q9
	public Alert clickAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;

	}

//Q10
	public Alert cancelAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return alert;

	}

//Q11
	public String elementGetText(WebElement element) {
		visibilityOfElement(element);
		String text = null;

		if (elementIsDisplayed(element)) {
			text = element.getText();
		}
		return text;
	}

//Q12 A
	// value is Fixed
	public String elementGetDomProperty(WebElement element) {
		visibilityOfElement(element);
		String domProperty = null;

		if (elementIsDisplayed(element)) {
			domProperty = element.getDomProperty("value");
		}
		return domProperty;
	}

//Q12 B
	// value is NOT fixed
	public String elementGetDomProperty(WebElement element, String propertyName) {
		visibilityOfElement(element);
		String domProperty = null;

		if (elementIsDisplayed(element)) {
			domProperty = element.getDomProperty(propertyName);
		}
		return domProperty;
	}

//Q13
	public void closeWindow() {
		driver.close();
	}

//Q14
	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}

//Q15
	public String getApplnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

//Q16
	public void elementSelectOptionByText(WebElement element, String text) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByVisibleText(text);
	}

//Q17
	public void elementSelectOptionByValue(WebElement element, String text) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByValue(text);
	}

//Q18
	public void elementSelectOptionByIndex(WebElement element, int index) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByIndex(index);
	}

//Q19
	public void elementSendKeysJs(WebElement element, String data) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

//Q20
	public void elementClickJs(WebElement element) {
		executor = (JavascriptExecutor) driver;
		visibilityOfElement(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			executor.executeScript("arguments[0].click()",element);
		}
	}

//Q21
	public void switchToChildWindow() {
		String windowHandle = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String eachWindow : windowHandles) {
			if (!windowHandle.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
			}

		}
	}

//Q22
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

//Q23
	public void switchToFrameByIdOrName(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

//Q24
	public void switchToFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

//Q25
	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

//Q26
	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

//Q27
	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

//Q28
	public WebElement findLocatorByXpath(String xpathExp) {
		WebElement element = driver.findElement(By.xpath(xpathExp));
		return element;
	}

//Q29
	public List<String> getAllOptionsByText(WebElement element) {
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		List<String> allOptionsText = new ArrayList<>();

		for (WebElement webElement : options) {
			String text = webElement.getText();
			allOptionsText.add(text);

		}
		return allOptionsText;
	}
	
//Q30
	public List<String> getAllOptionsByValue(WebElement element) {
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		List<String> allOptionsText = new ArrayList<>();

		for (WebElement webElement : options) {
			String value = webElement.getDomAttribute("value");
			allOptionsText.add(value);

		}
		return allOptionsText;
	}
	
//Q31
	public WebElement elementFirstSelectedOption(WebElement element) {
		select= new Select(element);
		WebElement option = select.getFirstSelectedOption();
		String text = option.getText();
		return option;
	}
	
//Q32
	
	private boolean isMultiple(WebElement element) {
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
	
	
//Q33 A
	public void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

//Q33 B
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

//Q34
	public void visibilityOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

//Q36
	public boolean elementIsDisplayed(WebElement element) {

		visibilityOfElement(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

//Q37
	public boolean elementIsEnabled(WebElement element) {
		visibilityOfElement(element);
		boolean enabled = element.isEnabled();
		return enabled;
	}

//Q38
	public boolean elementIsSelected(WebElement element) {
		visibilityOfElement(element);
		boolean selected = element.isSelected();
		return selected;
	}

//Q39
	public void elementDeSelectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);

	}

//Q40
	public void elementDeSelectOptionByText(WebElement element, String text) {
		select = new Select(element);
		select.deselectByVisibleText(text);
	}

//Q41
	public void elementDeSelectAllOption(WebElement element, String text) {
		select = new Select(element);
		select.deselectAll();
	}

//Q42
	public void elementDeSelectOptionByValue(WebElement element, String text) {
		select = new Select(element);
		select.deselectByValue(text);
	}

//Q43
	public void elementClear(WebElement element) {
		visibilityOfElement(element);
		element.clear();
	}

//Q44 
	public void screenshot(String fileName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(
				"C:\\Users\\mathi\\eclipse-workspace-Selenium\\FrameWork\\Excel\\omrgracery.xlsx" + fileName + ".png"));
	}

//Q45
	public void screenshot(WebElement element, String fileName) throws IOException {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(
				"C:\\Users\\mathi\\eclipse-workspace-Selenium\\FrameWork\\Excel\\omrgracery.xlsx" + fileName + ".png"));
	}

//Q46	
	public void mouseOverActions(WebElement destination) {
		actions = new Actions(driver);
		actions.moveToElement(destination).perform();

	}

//Q47
	public void dragAndDrop(WebElement source, WebElement destination) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, destination).perform();

	}

//Q48
	public void rightClick(WebElement destination) {
		actions = new Actions(driver);
		actions.contextClick(destination).perform();

	}

//Q49
	public void doubleClick(WebElement destination) {
		actions = new Actions(driver);
		actions.doubleClick(destination).perform();

	}
	
//Q50
	public void insert(WebElement element, String data) {
		visibilityOfElement(element);

		if (elementIsDisplayed(element) && elementIsEnabled(element)) {

		element.sendKeys(data,Keys.ENTER);
		}
	}
	
//Q51
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	
	public void navigateRefresh(String url) {
		driver.navigate().refresh();
	}
	
	public void navigateBack(String url) {
		driver.navigate().back();
	}
	
	public void navigateForward(String url) {
		driver.navigate().forward();
	}
	

//Q52
	public void scroll(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public List<WebElement> findLocatorsById(String attributeValue) {
		List<WebElement> elements = driver.findElements(By.id(attributeValue));
		return elements;
	}

	//Q54
	public List<WebElement> findLocatorsByName(String attributeValue) {
		List<WebElement> elements = driver.findElements(By.name(attributeValue));
		return elements;
	}

	//Q55
	public List<WebElement> findLocatorsByClassName(String attributeValue) {
		List<WebElement> elements  = driver.findElements(By.className(attributeValue));
		return elements;
	}

	//Q56
	public List<WebElement> findLocatorsByXpath(String xpathExp) {
		List<WebElement> elements = driver.findElements(By.xpath(xpathExp));
		return elements;
	}

	public Alert clickAlert1() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;

	}
	

	

}
