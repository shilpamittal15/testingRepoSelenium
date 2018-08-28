package utility;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class dropDownHandle 
{
	public static void ddlHandling(WebElement element)
	{
		Select year=new Select(element);
		List<WebElement> dropdown=year.getOptions();
		
		int size=dropdown.size();
		
		System.out.println(size);
		
		for(int i=0; i<size; i++)
		{
			String data=dropdown.get(i).getText();
			System.out.println(data);
		}
	}
}
