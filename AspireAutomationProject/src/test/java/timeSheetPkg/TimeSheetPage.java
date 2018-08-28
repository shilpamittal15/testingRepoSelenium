package timeSheetPkg;

import java.awt.dnd.MouseDragGestureRecognizer;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.HandlingAlerts;
import utility.Utility;
import utility.WindowHandle;
import utility.dropDownHandle;

public class TimeSheetPage 
{
	
	WebDriver driver;
	
	Utility utilclass=new Utility();
	HandlingAlerts alerts=new HandlingAlerts();
	
	@FindBy(xpath="//ul/li[6]/a/strong[contains(text(),'Timesheet')]")
	public static WebElement HomeTimesheet;
	
	@FindBy(linkText="Go to Timesheet")
	public static WebElement GoToTimesheet;	
	
	@FindBy(xpath="//ul/li[5]/ul[@class='dropdown-menu']/li")
	public static List<WebElement> GoToTimesheetList;
	
	@FindBy(xpath=".//*[@id='aspnetForm']/div[3]/div/div/div[1]/span")////div/div[@class="container"]/div/div/span
	public static WebElement HanburgerIcon;
	
	@FindBy(xpath="div/div[@class='container']/div/div/span")////div/div[@class="container"]/div/div/span
	public static WebElement HanburgerIcon1;
	
	@FindBy(id="ctl00_contentplaceholder1_ddlYear")
	public static WebElement yearDDL;
	
	@FindBy(id="ctl00_contentplaceholder1_ddlMonth")
	public static WebElement MonthDDL;
	
	@FindBy(id="ctl00_contentplaceholder1_ddlWeek")
	public static WebElement weekDDL;
	
	@FindBy(id="ctl00_lstPending")
	public static WebElement houseHover;
	
	@FindBy(xpath=".//*[@id='ctl00_TSPending']/div/ul")
	public static WebElement mouseHoverText;
	
	@FindBy(id="ctl00_contentplaceholder1_lnk_MonthlyTimesheet")
	public static WebElement MTS;
	
	@FindBy(xpath="//div[@id='MTSPopUp']/div/div/div/button")
	public static WebElement MTSPopUpClose;
	
	@FindBy(xpath=".//*[@id='flexi-tbl']/tbody/tr")
	public static WebElement MTSPopUPText;
	
	@FindBy(xpath=".//*[@id='ctl00_contentplaceholder1_Repeat_ctl00_lblTask']")
	public static WebElement MTSPopUpText1;
	
	@FindBy(xpath="//a[contains(@href, '#collapseOne')]")
	public static WebElement TimesheetSummary;
	
	@FindBy(xpath=".//*[@id='ctl00_contentplaceholder1_UpdatePanel1']/div/div/div[1]/a")
	public static WebElement FillTimeSheet;
	
	@FindBy(id="ctl00_contentplaceholder1_btnAddRow")
	public static WebElement AddRow;
	
	@FindBy(id="ctl00_contentplaceholder1_grdTimesheetEntry_ctl03_chkselect")
	public static WebElement SelectRow;
	
	@FindBy(id="ctl00_contentplaceholder1_btnDeleteRow")
	public static WebElement DeleteRow;
	
	public TimeSheetPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void TimesheetManage() throws Exception
	{
		//HomeTimesheet.click();
		//Thread.sleep(3000);
		
		int sizeOfSheet=GoToTimesheetList.size();
		System.out.println("Items Present in Timesheet: "+sizeOfSheet);
		
		for(int i=0; i<=sizeOfSheet-1; i++)
		{
			String TimeSheet=GoToTimesheetList.get(i).getText();
			System.out.println(TimeSheet);
		}
		
		Thread.sleep(3000);
		
		HomeTimesheet.click();
		
		Thread.sleep(3000);
		
		GoToTimesheet.click();
		
		Thread.sleep(3000);
		
		WindowHandle.HandleMultipleWindow(driver, 1);
		
		HanburgerIcon.click();
		
		Thread.sleep(3000);
		
		//HanburgerIcon1.click();
		
		/*Select year=new Select(yearDDL);
		List<WebElement> dropdown=year.getOptions();
		
		int size=dropdown.size();
		
		System.out.println(size);
		
		for(int i=0; i<size; i++)
		{
			String data=dropdown.get(i).getText();
			System.out.println(data);
		}
		*/
		Thread.sleep(3000);
		//Handling mouse hover events
		Actions action=new Actions(driver);
		action.moveToElement(houseHover).perform();
		
		Thread.sleep(3000);
		
		System.out.println(mouseHoverText.getText());
		
		dropDownHandle.ddlHandling(yearDDL);
		dropDownHandle.ddlHandling(MonthDDL);
		dropDownHandle.ddlHandling(weekDDL);
		
		System.out.println("!!!!!User is moving to MTS!!!!!");
		
		MTS.click();
		
		Thread.sleep(3000);
		
		System.out.println(MTSPopUPText.getText());
		
		Thread.sleep(3000);
		
		System.out.println(MTSPopUpText1.getText());
		
		//MTSPopUpText1.click();
		
		MTSPopUpClose.click();
		
		//To click on the element, not able to click on the element directly
		
		utilclass.javascriptExecutorMethod(driver, TimesheetSummary);
		
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", TimesheetSummary);
		*/
	
		//utilclass.javascriptExecutorMethod(driver, FillTimeSheet);
		
		Thread.sleep(3000);
		
		AddRow.click();
		Thread.sleep(3000);
		SelectRow.click();
		
		DeleteRow.click();
		
		Thread.sleep(4000);
		
		alerts.PopupHandling();
		
				
	}
}

