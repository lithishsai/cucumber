package org.steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.transport.DockerHttpClient.Response;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.ResponseBody;

public class Base {
	static WebDriver driver;
	static Actions a;
	static Robot r;
	static RequestSpecification req;
	static io.restassured.response.Response response;

	public static void launchBrowser(String url)
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	}
	public static void addHeadedr(String key, String value) {
		req=RestAssured.given().header(key, value);

	}
	public static void pathParam(String key, String value) {
		req=req.pathParam(key, value);

	}
	
	public static void basicAuth(String uname, String pass) {
		req=req.auth().preemptive().basic(uname, pass);

	}
	public static void querryParam(String key, String value) {
		req=req.queryParam(key, value);

	}
	public static void resBody(String body) {
		req=req.body(body);

	}
	public static io.restassured.response.Response method(String type,String endpoint) {
switch(type) {
case "GET":
	response= req.get(endpoint);
	break;
case "POST":
	response= req.post(endpoint);
	break;
case "PUT":
	response= req.put(endpoint);
	break;
case "DELETE":
	response= req.delete(endpoint);
	break;
	default:
		break;
		
}
return response;
	}
	private int statuscode(Response response) {
int statusCode = response.getStatusCode();
return statusCode;
	}
	
	
private void bodyasString(Response response) {
	
}
	public static void Browser(String browserName)
	{

		if(browserName.equalsIgnoreCase("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
	
	}
	public static void close()
	{
		driver.close();
	}

	public static void quit()
	{
		driver.quit();
	}
	public static void launchUrl(String url)
	{
		driver.get(url);
	}
	public static void browserMaximize()
	{
		driver.manage().window().maximize();
	}
	public static void winSize(int a, int  b) {
    Dimension d= new Dimension (a,b);
    driver.manage().window().setSize(d);
	}
	public static void winPosition(int c, int  d) {
		Point p= new Point (c,d);
		driver.manage().window().setPosition(p);
	}
	public static String title()
	{
		String title = driver.getTitle();
		return title;
	}
	public static String getUrl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public static void sendText(WebElement element, String value)
	{
		element.sendKeys(value);
		
	}
	public static void buttonClick(WebElement button)
	{
		button.click();
		
	}
	
	public static String getText(WebElement element)
	{
		String text =element.getText();
        return text;		
	}
	public static String attribu(WebElement element, String name)
	{
		String att = element.getAttribute("name");
		return att;
	}
	public static void navi(String url) {
     driver.navigate().to(url);
	}
	
	public static void back() {
		
     driver.navigate().back();

	}
	public static void refresh() {
    driver.navigate().refresh();
	}
	public static void cook() {
		
    driver.manage().deleteAllCookies();
    
	}
	public static void moveElement(WebElement target)
	{
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}
	
	public static void dragAndDrop(WebElement source, WebElement target)
	{
		a.dragAndDrop(source, target).perform();
		
	}
	public static void contextClick(WebElement target)
	{
		a.moveToElement(target).perform();
	}

	public static void doubleClick(WebElement target)
	{
		a.moveToElement(target).perform();
	}
	public static void singleSelect(WebElement singleSelect, String select) {
        Select s=new Select(singleSelect);
        s.selectByValue(select);
	}
	public static void cut() throws AWTException 
	{
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_X);
	
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_X);
	
}
	public static void copy() throws AWTException 
	{
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_C);
	
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_C);
	
}
public static void paste() throws AWTException 
{
r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_V);

r.keyRelease(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_V);

}
public static void downarrow() throws AWTException 
{
r.keyPress(KeyEvent.VK_DOWN);
r.keyRelease(KeyEvent.VK_DOWN);

}
public static void enter() throws AWTException 
{
r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);

}
public static void screenShot(String str) throws IOException
{
	TakesScreenshot tk =(TakesScreenshot)driver;
	File screen = tk.getScreenshotAs(OutputType.FILE);
	
		File shot= new File("D:\\java"+str+".png");
	FileUtils.copyFile(screen, shot);
}

public static String getData(int rowIndex,int collIndex, String wName, String sName) throws IOException
{
	
	File f = new File("D:\\java"+wName+".xlsx");
	FileInputStream fis= new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fis);
	Sheet sh = wb.getSheet(sName);
	
	Row r = sh.getRow(rowIndex);
	
	Cell c= r.getCell(collIndex);
	System.out.println(c);
	String value = c.getStringCellValue();
	return value;
}
	



}
