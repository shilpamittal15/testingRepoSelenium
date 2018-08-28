package execution;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import homePage.HomePage;
import hrMenuBar.HRMenu;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import login.Login;
import timeSheetPkg.TimeSheetPage;


public class Execute 
{
	WebDriver driver;
	 
	Login log;
	
	
	//Login log;
	HomePage home;
	TimeSheetPage ts;
	HRMenu hrMenu;
	
	//ExtentReports Extent;
	//ExtentTest test;
	
	@BeforeSuite
	public void BeforeSuite()
	
	{
		//Extent=new ExtentReports("//Users//shilpa//Documents//workspace//AspireAutomationProject//test-output//sampleReport.html",true);
		//Extent.loadConfig(new File(""));
	}
	
	@BeforeMethod
	public void BeforeMethod(Method method)
	{
		//test=Extent.startTest((this.getClass().getSimpleName() + " :: "+ method.getName()), method.getName());
		//test.assignAuthor("Shilpa");
		//test.assignCategory("Smoke TestCases");
	}
	
	@BeforeTest
	public void setUp()
	{
		ChromeDriverManager.getInstance().setup();
		driver=new ChromeDriver();
		driver.get("http://aspire.infogain.com/");
		driver.manage().window().maximize();
		//test=Extent.startTest((this.getClass().getSimpleName() + " :: "+ method))
	}
	
	@Test(priority=1)
	public void loginUser() throws Exception
	{
		log=new Login(driver);
		log.userLogin("shilpa", "Prateek@1234");
	//	test.log(LogStatus.PASS, "UserLogin successfully");
	}
	
	@Test(priority=2)
	public void homePageFunctionality() throws Exception
	{
		home=new HomePage(driver);
		home.TopbarMenu();
	}
	
	/*@Test(priority=3)
	public void TimeSheetFunctionality() throws Exception
	{
		ts=new TimeSheetPage(driver);
		ts.TimesheetManage();
	}*/
	
	@Test(priority=4)
	public void HomePgaeMenuBar() throws Exception
	{
		Thread.sleep(3000);
		home.homeMenuBar();
	}
	
	@Test(priority=5)
	public void Hr() throws Exception
	{
		hrMenu=new HRMenu(driver);
		hrMenu.hrFunctionality();
	}
	
	@AfterTest
	public void tearDown() throws Exception
	{
		//log.Userlogout();
		Thread.sleep(3000);
		//driver.close();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		//Extent.endTest(test);
	}
	
	@AfterSuite
	public void aftersuit()
	{
		//Extent.flush();
		//Extent.close();
	}

}
