package homePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage 
{
WebDriver driver;
	
	@FindBy(id="menu1")
	public static List<WebElement> theme;
	
	@FindBy(xpath="//ul/li[2]/a[@title='Food Menu']") //div/ul/li[2]/a[@title='Food Menu'] //a[@class='logo']/img
	public static WebElement FoodMenu;
	
	@FindBy(xpath=".//*[@id='WeekFoodMenu-modal']/div/div/div[1]/button")
	public static WebElement CloseFoodMenu;
	
	@FindBy(xpath="//header/nav/div/ul/li[3]/a/i")
	public static WebElement TimeZone;
	
	@FindBy(xpath="(.//*[@id='clock_widget']/embed)[1]")
	public static WebElement IndiaTimeZone;
	
	@FindBy(xpath=".//*[@id='timezoneclock-modal']/div/div/div[2]/div/div[1]/div/div[2]/div/div/a")
	public static WebElement TimeInCountry;
	
	@FindBy(xpath="//ul/li[6]/a/strong[contains(text(),'Timesheet')]")
	public static WebElement timesheet;
	
    @FindBy(linkText="Go to Timesheet")
	public static WebElement GoToTimesheet;	
	
	@FindBy(xpath="//ul/li[5]/ul[@class='dropdown-menu']/li")
	public static List<WebElement> GoToTimesheetList;
	
	@FindBy(xpath="//ul[@class='sidebar-menu']/li/a")
	public static List<WebElement> homeListItems;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void TopbarMenu() throws Exception
	{
		
		//FoodMenu.click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		//CloseFoodMenu.click();
		
		Thread.sleep(3000);
	}
	
	public void homeMenuBar()
	{
		int sizeofList=homeListItems.size();
		
		System.out.println("Size of menu bar element is :"+sizeofList);
		
		for(int i=0; i<sizeofList; i++)
		{
			String listData=homeListItems.get(i).getText();
			System.out.println("Elements present in the list are :"+listData);
		}
	}
}
