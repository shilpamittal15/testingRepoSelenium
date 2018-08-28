package sideMenuBar;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenuBar 
{
	WebDriver driver;
	
	@FindBy(xpath="//ul[@class='sidebar-menu']/li/a")
	public static List<WebElement> homeListItems;
	
	
	public SideMenuBar(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void homeMenuBar() throws Exception
	{
		int sizeofList=homeListItems.size();
		
		System.out.println(sizeofList);
		
		for(int i=0; i<sizeofList; i++)
		{
			String listData=homeListItems.get(i).getText();
			System.out.println(listData);
		}
		
		Thread.sleep(3000);
	}
}
