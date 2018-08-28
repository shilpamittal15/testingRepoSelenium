package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility 
{
	WebDriver driver;
	
	public void javascriptExecutorMethod(WebDriver driver, WebElement element)
	{
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
	}
}
