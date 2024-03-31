package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Baseclass {
public WebDriver driver;
public String baseurl="https://theformularx.com/";

@BeforeTest
public void setup() {
	ChromeOptions options =new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	
}

@BeforeMethod
public void url() {
	driver.get(baseurl);
	driver.navigate().refresh();
}
}
