package utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class HandlingAlerts 
{
	WebDriver driver;
	
	public boolean PopupHandling()
	{
		boolean presentFlag = false;
		
		try
		{
			Alert popup=driver.switchTo().alert();
			
			presentFlag = true;
			
			String alerttext=popup.getText();
			System.out.println("Alert text is :" + alerttext);
			popup.accept();
		}
		catch(Exception e)
		{
			System.out.println("No popup found");
			
		}
		
		return presentFlag;	
		
		
	}
}
