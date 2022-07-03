package DataProvider.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class DPTest {
	WebDriver driver=null;
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("file:///C:/Users/Dell/Downloads/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		  
	}
  @Test(dataProvider = "logindata")
  public void loginTest(String uname, String pass, String errMsg, String errpass) {
	  
	  if(driver.getTitle().equals("JavaByKiran | Dashboard"))
	  driver.findElement(By.linkText("LOGOUT")).click();
	  driver.findElement(By.id("email")).clear();
	  driver.findElement(By.id("email")).sendKeys(uname);
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("password")).sendKeys(pass);
	  driver.findElement(By.xpath("//button")).click();
	
	  if(driver.getTitle().equals("JavaByKiran | Dashboard"))
		  Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	  else {
		  WebElement emailerr = driver.findElement(By.id("email_error"));
		  Assert.assertEquals(emailerr.getText(), errMsg);
		  WebElement passerr = driver.findElement(By.id("password_error"));
		  Assert.assertEquals(passerr.getText(), errpass);
	  }
  }

  @DataProvider
  public Object[][] logindata() {
    return new Object[][] {
      new Object[] { "", "","Please enter email.","Please enter password." },
      new Object[] { "Suraj@gmaul.com", "976359", "Please enter email as kiran@gmail.com","Please enter password 123456"},
      new Object[] {"kiran@gmail.com", "123456","","" },
      new Object[] {"kiran@gmail.com","43568","","Please enter password 123456"},
    };
  }
}
