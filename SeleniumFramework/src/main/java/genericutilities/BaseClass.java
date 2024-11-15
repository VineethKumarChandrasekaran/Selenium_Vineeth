package genericutilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass {
	public  WebDriver driver;
	public static WebDriver sdriver;
	public static ExtentReports extReport;
	public static ExtentTest test;
	public FileUtility fileutility = new FileUtility();
	public ExcelUtility excelutility = new ExcelUtility();
	public JavaUtility javautility = new JavaUtility();
	public WebDriverUtility webdriverutility = new WebDriverUtility();
	public WelcomePage welcomepage;
	public LoginPage loginpage;
	public HomePage homepage;

	@BeforeSuite
	public void reportConfiguration() {
    ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/ExtentRepot_"+javautility.getSystemTime()+".html");
    extReport = new ExtentReports();
    extReport.attachReporter(spark);
	}
	
	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName ) throws IOException {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		sdriver = driver;
		webdriverutility.maximizeWindow(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(fileutility.properties("url"));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		welcomepage = new WelcomePage(driver);
		welcomepage.getLoginLink().click();
		loginpage = new LoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileutility.properties("email"));
		loginpage.getPasswordTextField().sendKeys(fileutility.properties("password"));
		loginpage.getLoginButton().click();
	}
	
	@AfterMethod
	public void logout() {
		homepage = new HomePage(driver);
		homepage.getLogoutButton().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}
}
