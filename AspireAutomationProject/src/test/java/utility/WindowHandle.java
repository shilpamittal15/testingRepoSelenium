package utility;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandle 
{
	
	public static void HandleMultipleWindow(WebDriver driver, int WindowIndex)
	{
		String ParentWindow=driver.getWindowHandle();
		System.out.println(ParentWindow);
		 
		Set<String> allWindow=driver.getWindowHandles();
		ArrayList<String> AllWindowInList=new ArrayList<String>(allWindow);
		 
		int sizeOfAllWindow=AllWindowInList.size();
		System.out.println(sizeOfAllWindow);
		 
		String titleofPage=driver.switchTo().window(AllWindowInList.get(WindowIndex)).getTitle();
		 
		System.out.println(titleofPage);
	}
}
