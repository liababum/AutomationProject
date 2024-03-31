package test;

import java.io.IOException;

import org.testng.annotations.Test;

import basepkg.Baseclass;
import pages.InitialPage;
import utilities.ExcelUtil;


public class InitialPagetest  extends Baseclass{

	
	@Test
	public void cmlogintest() throws IOException  {
		InitialPage intpg=new InitialPage(driver);
		intpg.refresh();
		intpg.Titleverification();
		intpg.Screenshot();
		intpg.Commonlogin();
		intpg.refresh();
		intpg.Createaccount();
		intpg.refresh();
		intpg.Setvalues("ABC", "DEF", "abc@gmail.com", "Luminar5/");
		intpg.register();
		driver.navigate().to(baseurl);
	    intpg.refresh();
		intpg.Commonlogin();
		intpg.refresh();
		try {
		String xl="D:/Book1.xlsx";
		String Sheet="Sheet1";
		int rowCount=ExcelUtil.getRowCount(xl, Sheet);
		for(int i=1;i<=rowCount;i++) {
			String Username=ExcelUtil.getCellvalue(xl, Sheet, i,0);
			System.out.println("username------------"+Username);
		    String Pwd=ExcelUtil.getCellvalue(xl, Sheet, i,1);
		    System.out.println("Password----"+Pwd);
		    intpg.Loginsetvalues(Username, Pwd);
		    intpg.Loginbtn();
		    intpg.refresh();
		}
		}
		catch(Exception e) {
			intpg.Loginvalues("abc@gmail.com", "Luminar5/");
		    intpg.Loginbtn();
		    intpg.refresh();
		}
		
		driver.navigate().to(baseurl);
		intpg.refresh();
		intpg.Menuclick();
		intpg.Scrolldown();
		driver.navigate().to(baseurl);
		intpg.refresh();
		intpg.Searchbutton();
		intpg.Searchproduct("Barrier Relief");
		intpg.ProductAdd();
		intpg.Closecart();
		driver.navigate().to(baseurl);
		intpg.refresh();
		intpg.AddSerum();
		intpg.Serumcartclose();
		driver.navigate().to(baseurl);
		intpg.refresh();
		intpg.Cartopen();
		intpg.Checkout();
		intpg.Deliverydetails("7024897878");
		intpg.StateSelection();
		
	
	}
}
