package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClassMain {
	static WebDriver driver;
	static TakesScreenshot ts;
	static Actions a;
	static File f;
	static JavascriptExecutor js;
	static RequestSpecification specification;
	static Response response2;

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void getBrowser(String url) {
		driver.get(url);
	}

	public static WebElement findId(String valueid) {
		WebElement findElement = driver.findElement(By.id(valueid));
		return findElement;
	}

	public static WebElement findName(String namevalue) {
		WebElement findElement = driver.findElement(By.name(namevalue));
		return findElement;
	}

	public static WebElement findxpath(String xpathvalue) {
		WebElement findElement = driver.findElement(By.xpath(xpathvalue));
		return findElement;
	}

	public static void sendtext(WebElement findElement, String textvalue) {
		findElement.sendKeys(textvalue);
	}

	public static void buttonClick(WebElement findElement) {
		findElement.click();
	}

	public static String textgetting(WebElement findElement) {
		String text = findElement.getText();
		System.out.println(text);
		return text;
	}

	public static String gettingAttribute(WebElement findElement, String name) {
		String attribute = findElement.getAttribute(name);
		System.out.println(attribute);
		return attribute;
	}

	public static void actionsMovetoElement(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}

	public static void actionsDragandDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	public static void actionsRightClick(WebElement target) {
		Actions a = new Actions(driver);
		a.contextClick(target).perform();
	}

	public static void actionsDoubleClick(WebElement target) {
		Actions a = new Actions(driver);
		a.doubleClick(target).perform();
	}

	public static void selectOptions(WebElement findElement, int index) {
		Select s = new Select(findElement);
		s.selectByIndex(index);
	}

	public static void selectOptions2(WebElement findElement, String value) {
		Select s = new Select(findElement);
		s.selectByValue(value);
	}

	public static void selectOptions3(WebElement findElement, String value) {
		Select s = new Select(findElement);
		s.selectByVisibleText(value);
	}

	public static void simpleAlert() {
		Alert simple = driver.switchTo().alert();
		simple.accept();
	}

	public static void confirmAlertAccept() {
		Alert confirm = driver.switchTo().alert();
		confirm.accept();
	}

	public static void confirmAlertDismiss() {
		Alert alertdismiss = driver.switchTo().alert();
		alertdismiss.dismiss();

	}

	public void promtAlert(WebElement findElement, String value) {

		Alert promtalert = driver.switchTo().alert();
		findElement.sendKeys(value);
		promtalert.accept();

	}

	public static File screenShot(String name) throws IOException {
		ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		f = new File("D:\\Files\\ss\\" + name + ".jpeg");
		FileUtils.copyFile(source, f);
		return source;

	}

	public static void keyBoardActionsDown() {
		a.keyDown(Keys.DOWN);
		a.keyUp(Keys.DOWN);
		a.perform();
	}

	public static void keyBoardActionsUp() {
		a.keyDown(Keys.UP);
		a.keyUp(Keys.UP);
		a.perform();
	}

	public static void keyBoardActionsTab() {
		a.keyDown(Keys.TAB);
		a.keyUp(Keys.TAB);
		a.perform();
	}

	public static void KeyBoardActionCopy() {
		a.keyDown(Keys.CONTROL);
		a.sendKeys("c");
		a.keyUp(Keys.CONTROL);
	}

	public static void keyBoardActionAll() {
		a.keyDown(Keys.CONTROL);
		a.sendKeys("a");
		a.keyUp(Keys.CONTROL);
	}

	public static void keyBoardActionsShift(String value, WebElement findElement) {
		a.keyDown(Keys.SHIFT);
		findElement.sendKeys(value);
		a.keyUp(Keys.SHIFT);
	}

	public static void keyBoardActionsPaste() {
		a.keyDown(Keys.CONTROL);
		a.sendKeys("v");
		a.keyUp(Keys.CONTROL);
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void framesId(String id) {
		driver.switchTo().frame(id);
	}

	public static void framesName(String name) {
		driver.switchTo().frame(name);
	}

	public static String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public static void windowHandles(String windowHandle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String aa : windowHandles) {
			if (!aa.equals(windowHandle)) {
				driver.switchTo().window(aa);

			}

		}

	}

	public static void switchingWindow(String nameOrHandle) {
		driver.switchTo().window(nameOrHandle);
	}

	public static void multiWindow(int index, String nameOrHandle) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li = new LinkedList<String>();
		li.addAll(windowHandles);
		li.get(index);
		driver.switchTo().window(nameOrHandle);
	}

	public static void findRows(String tagName) {
		List<WebElement> row = driver.findElements(By.tagName(tagName));
		int size = row.size();
		System.out.println(size);

	}

	public static void findTableDatas(String tagName) {
		List<WebElement> tabledata = driver.findElements(By.tagName(tagName));
		int size = tabledata.size();
		System.out.println(size);
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void javaScriptExecutorpixeldown(int number) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,number)");
	}

	public static void javaScriptExecutorpixelup(int number) {
		js.executeScript("window.scrollBy(0,-number)");
	}

	public static void javaScriptup(WebElement findElement) {
		js.executeScript("arguments[0].scrollIntoView(false)", findElement);
	}

	public static void javaScriptDown(WebElement findElement) {
		js.executeScript("arguments[0].scrollIntoView(true)", findElement);
	}

	public static void javaScriptvalue(String name, WebElement findElement) {
		js.executeScript("arguments[0].setAttribute('value',+'" + name + "')", findElement);
	}

	public static void javaScriptHighlight(String colour, String bcolour, WebElement findElement) {
		js.executeScript("arguments[0].setAttribute('style','background: " + colour + "; border: " + bcolour + "')",
				findElement);
	}

	public static void textClear(WebElement findElement) {
		findElement.clear();
	}

	public static void getExcelValue(String name, String name1, int arg, int arg0) throws IOException {
		File f = new File("D:\\Files\\" + name + ".xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(name1);
		Row row = sheet.getRow(arg);
		Cell cell = row.getCell(arg0);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			String value = cell.getStringCellValue();
			System.out.println(value);
			break;

		default:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date cellValue = cell.getDateCellValue();
				SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
				String format = sf.format(cellValue);
				System.out.println(format);
			} else {
				double value2 = cell.getNumericCellValue();
				long l = (long) value2;
				System.out.println(l);

			}

			break;
		}

		String cellValue = cell.getStringCellValue();
		System.out.println(cellValue);

	}

	public static void getMultipleExcellValue(String name, String name1) throws IOException {
		File f = new File("D:\\Files\\tnpsc\\" + name + ".xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(name1);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);

				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
					break;

				default:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
						String format = sf.format(dateCellValue);
						System.out.println(format);
					} else {
						double value = cell.getNumericCellValue();
						long l = (long) value;
						System.out.println(l);
					}
					break;
				}

			}
		}

	}

	public static void createExcelvalue(String name, String sname, int arg0, int arg1, String findName)
			throws IOException {
		File f = new File("D:\\Files\\" + name + ".xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet(sname);
		Row row = sheet.createRow(arg0);
		Cell cell = row.createCell(arg1);
		cell.setCellValue(findName);
		FileOutputStream out = new FileOutputStream(f);
		book.write(out);

	}

	public static void requestObject(String base) {
		RestAssured.baseURI = base;
		specification = RestAssured.given();
	}

	public static RequestSpecification addHeader(String headerNmae, String headerValur) {
		specification = RestAssured.given();
		RequestSpecification header = specification.header(headerNmae, headerValur);
		return header;
	}

	public static RequestSpecification addQuaryParameter(String parameterName, String parameterValue) {
		RequestSpecification queryParam = specification.queryParam(parameterName, parameterValue);
		return queryParam;
	}

	public static RequestSpecification addpathParameter(String pathName, String pathValue) {
		RequestSpecification pathParam = specification.pathParam(pathName, pathValue);
		return pathParam;

	}

	public static Response responseObject(String requestType, String response) {
		switch (requestType) {
		case "GET":
			response2 = specification.request(Method.GET, response);
			break;
		case "PUT":
			response2 = specification.request(Method.PUT, response);
			break;
		case "POST":
			response2 = specification.request(Method.POST, response);
			break;
		default:
			response2 = specification.request(Method.DELETE, response);
			break;
		}
		return response2;
	}

	public static void printresponseBody() {
		String asPrettyString = response2.getBody().asPrettyString();
		System.out.println(asPrettyString);

	}

	public static int getStatusCode() {
		int statusCode = response2.getStatusCode();
		return statusCode;

	}

	public static void addBody(Object body) {
		specification = specification.body(body);

	}

	public static Response reqType(String req, String response) {
		switch (req) {
		case "GET":
			response2 = specification.log().all().get(response);
			break;
		case "PUT":
			response2 = specification.log().all().put(response);
			break;
		case "POST":
			response2 = specification.log().all().post(response);
			break;
		default:
			response2 = specification.log().all().delete(response);
			break;
		}
		return response2;

	}

	public void addHeadervalue(String Key, String Value) {
		specification = RestAssured.given().header(Key, Value);

	}

	public void queryParam(String Key, String Value) {
		specification = specification.queryParam(Key, Value);

	}

	public void pathParam(String Key, String Value) {
		specification = specification.pathParam(Key, Value);

	}

	public void addBody(String body) {
		specification = specification.body(body);

	}

	

	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}
/**
 * 
 * @param username
 * @param password
 */
	public void basicAuth(String username, String password) {
		specification.auth().preemptive().basic(username, password);
	}

	public void addHeaders() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header("", "");
		Header h2 = new Header("", "");
		Header h3 = new Header("", "");
		header.add(h1);
		header.add(h2);
		header.add(h3);
		Headers headers = new Headers(header);
		RestAssured.given().headers(headers);

	}

}
