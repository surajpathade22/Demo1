package TheKiranAcademy.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import TheKiranAcademy.pages.Dashboardpage;
import TheKiranAcademy.pages.LoginPage1;

public class LoginTests {
	WebDriver driver = null;
	Dashboardpage dp = null;
	LoginPage1 lp = null;
	
@Test(priority=0)
public void test01() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
	driver.get("file:///C:/Users/Dell/Downloads/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	
     lp = new LoginPage1(driver);
	
	//lp.LoginToApplication("kiran@gmail.com","123456");
	dp=lp.getdashboard();

	Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
}
@Test (priority=1)
public void test02() {
  
	Assert.assertTrue(dp.verifyCourses());
}

}
