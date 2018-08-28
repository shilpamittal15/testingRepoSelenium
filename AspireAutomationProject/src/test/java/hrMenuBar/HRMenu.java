package hrMenuBar;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMenu 
{
	
	WebDriver driver;
	
	@FindBy(xpath="(//ul[@class='sidebar-menu']/li[4])[a]")////ul[@class='sidebar-menu']/li[4]/a
	public static WebElement hr;
	
	@FindBy(xpath="//ul/li[4]/ul/li")
	public static List<WebElement> Hr_Data;
	
	//@FindBy(xpath="//ul[@class='sidebar-menu']/li")
	
	public HRMenu(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void hrFunctionality() throws Exception
	{
		System.out.println("Testing HR module");		
		hr.click();
		
		int sizeOfElements=Hr_Data.size();
		System.out.println("Elements in the HR List::"+sizeOfElements);
		for(int i=0; i<sizeOfElements;i++)
		{
			String HRListElements=Hr_Data.get(i).getText();
			System.out.println("Data in HR list ::"+HRListElements);
		}
		
		Hr_Data.get(4).click();
			
	}
}
