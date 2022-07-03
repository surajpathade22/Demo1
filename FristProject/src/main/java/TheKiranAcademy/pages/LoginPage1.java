package TheKiranAcademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
   //page Object modal
	//WebElement and its methods
	
	WebDriver driver = null;
	
	@FindBy(id="email")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="//button")
	public WebElement loginbutton;
	
	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void LoginToApplication(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbutton.click();
	}
	
	public Dashboardpage getdashboard() {
		username.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		loginbutton.click();
		
		
		return  new Dashboardpage(driver);
	}
	
	}
	

