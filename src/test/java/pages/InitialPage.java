package pages;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InitialPage {
WebDriver driver;

By cmlogin=By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/header/div/div[2]/div/a[1]");
By account=By.xpath("//*[@id=\"customer_register_link\"]");
By fstname=By.id("RegisterForm-FirstName");
By lstname=By.id("RegisterForm-LastName");
By mail=By.id("RegisterForm-email");
By pwd=By.id("RegisterForm-password");
By createbtn=By.xpath("//*[@id=\"RegisterForm\"]/p/input");
By loginemail=By.id("CustomerEmail");
By loginpsd=By.id("CustomerPassword");
By loginbtn=By.xpath("//*[@id=\"customer_login\"]/div/input");
By allproducts=By.xpath("//*[@id=\"SiteNav\"]/li[1]");
By bestsellers=By.xpath("//*[@id=\"SiteNav\"]/li[2]");
By serums=By.xpath("//*[@id=\"SiteNav\"]/li[3]");
By moisturizer=By.xpath("//*[@id=\"SiteNav\"]/li[4]");
By body=By.xpath("//*[@id=\"SiteNav\"]/li[5]");
By kits=By.xpath("//*[@id=\"SiteNav\"]/li[6]");
By aboutus=By.xpath("//*[@id=\"SiteNav\"]/li[7]");
By faq=By.xpath("//*[@id=\"shopify-section-footer\"]/footer/div[1]/div/div/div/ul/li[2]");
By search=By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/header/div/div[2]/div/button[1]");
By searchproduct=By.xpath("//*[@id=\"SearchDrawer\"]/div/div/form/div/input[1]");
By productlink=By.xpath("//*[@id=\"MainContent\"]/ul/li[1]/div/a");
By productlinkaddcart=By.xpath("//*[@id=\"product_form_6783541084328\"]/div/div[2]/div/div[9]/button[1]");
By cartclose=By.xpath("/html/body/div[14]/div[1]/div[1]/div/div/span");
By serumadd=By.xpath("//*[@id=\"product_form_7132578513064\"]/div[3]/div/div/button");
By serumcartclose=By.xpath("/html/body/div[13]/div[1]/div[1]/div/div/span");
By cartopen=By.xpath("//*[@id=\"shopify-section-header\"]/div[2]/header/div/div[2]/div/a[2]");
By checkout=By.xpath("/html/body/div[13]/div[1]/div[3]/div[1]/div/form/div/div[1]/div/button");
By phonenumber1=By.name("email");
By phonenumber2=By.id("TextField5");
By Stateselect=By.xpath("//*[@id=\"Select1\"]");

public InitialPage(WebDriver driver)
{
	this.driver=driver;
}

public void Titleverification() {
	String title=driver.getTitle();
	if(title.equalsIgnoreCase("The Formularx : Effective, Affordable Luxury Skincare – THE FORMULARX"))
	{
		System.out.println("Got Title as Expected");
	}
	else 
	{
		System.out.println("Title was wrongly displayed");
	}

	
}

public void Screenshot() throws IOException {
	File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(screenshot, new File("D://Formularx.png"));
}


public void Commonlogin() {
	driver.findElement(cmlogin).click();;
}

public void Createaccount() {
	driver.findElement(account).click();
}

public void Setvalues(String firstname,String lastname,String email,String password) {
	driver.findElement(fstname).sendKeys(firstname);
	driver.findElement(lstname).sendKeys(lastname);
	driver.findElement(mail).sendKeys(email);
	driver.findElement(pwd).sendKeys(password);
}

public void register() {
	driver.findElement(createbtn).click();
	
}



public void Loginsetvalues(String loginmail,String loginpwd) {
	driver.findElement(loginemail).clear();
	driver.findElement(loginemail).sendKeys(loginmail);
	driver.findElement(loginpsd).clear();
	driver.findElement(loginpsd).sendKeys(loginpwd);
	//driver.findElement(loginbtn).click();
}

public void Loginvalues(String loginmail,String loginpwd) {
	driver.findElement(loginemail).sendKeys(loginmail);
	driver.findElement(loginpsd).sendKeys(loginpwd);
}

public void Loginbtn() {
	driver.findElement(loginbtn).click();
}

public void Menuclick() {
	driver.findElement(allproducts).click();
    driver.findElement(bestsellers).click();
	driver.findElement(serums).click();
	driver.findElement(moisturizer).click();
	driver.findElement(body).click();
	driver.findElement(kits).click();
	driver.findElement(aboutus).click();
}

public void Scrolldown() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", driver.findElement(faq));
	driver.findElement(faq).click();
}

public void refresh() {
	driver.navigate().refresh();
}

public void Searchbutton() {
	driver.findElement(search).click();
}

public void Searchproduct(String productname) {
	driver.findElement(searchproduct).sendKeys(productname,Keys.ENTER);
}

public void ProductAdd() {
	driver.findElement(productlink).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,550)");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfElementLocated(productlinkaddcart));
	driver.findElement(productlinkaddcart).click();
	
}

public void Closecart() {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfElementLocated(cartclose));
	driver.findElement(cartclose).click();
}

public void AddSerum() {
	driver.findElement(serums).click();
	driver.findElement(serumadd).click();
}

public void Serumcartclose() {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfElementLocated(serumcartclose));
	driver.findElement(serumcartclose).click();
}

public void Cartopen() {
	driver.findElement(cartopen).click();
}

public void Checkout() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,550)");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfElementLocated(checkout));
	driver.findElement(checkout).click();
}

public void Deliverydetails(String number) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfElementLocated(phonenumber1));
	WebElement Fstnumber=driver.findElement(phonenumber1);
	Fstnumber.sendKeys(number);
	WebElement Scndnumber=driver.findElement(phonenumber2);
	Actions act =new Actions(driver);
	act.keyDown(Fstnumber,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
	act.keyDown(Fstnumber,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
	act.keyDown(Scndnumber,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
	
	act.build().perform();
}

public void StateSelection() {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfElementLocated(Stateselect));
	  WebElement state=driver.findElement(Stateselect);
	  Select ob1 =new Select(state);
	  ob1.selectByValue("KL");
	 List<WebElement>li1=ob1.getOptions();
	 System.out.println("Number of States: " + li1.size());
}

}
