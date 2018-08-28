package login;

import org.eclipse.jetty.util.security.Password;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login 
{
	WebDriver driver;
	

	@FindBy(xpath=".//*[@id='UserName']")
	public static WebElement Username;
	
	@FindBy(id="Password")
	public static WebElement password;
	
	@FindBy(xpath="//div[2]/button[contains(text(),'Login')]")
	public static WebElement Submit;
	
	@FindBy(id="close")
	public static WebElement popUpClose;
	
	@FindBy(xpath="//header/nav/div/ul/li[7]/a/span")
	public static WebElement UserLogOut1;
	
	@FindBy(xpath="//ul/li[7]/ul/li[1]/p")
	public static WebElement UserLogOutText;
	
	@FindBy(linkText="Log Out")
	public static WebElement UserLogOut2;
	
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void userLogin(String uName, String Pass) throws Exception
	{
		Username.sendKeys(uName);
		password.sendKeys(Pass);
		Submit.click();		
		
		 Thread.sleep(3000);
		    if(Pass!=Pass)
		    {
		    	password.sendKeys("test");
		    	Submit.click();
		    } 
		    
		    try
		    {
		    	Alert popup=driver.switchTo().alert();
		    	popup.accept();
		    	System.out.println("pop_up appeared and handled :"+ popup.getText());
		    }
		    catch (Exception e) 
		    {
		    	System.out.println("popup does not appear");
			}
		    
		    try
		    {		    
		    	if(popUpClose.isDisplayed())
		    	{
		    		popUpClose.click();
		    		System.out.println("Element is Present");
		    	}
		    	else 
		    	{
		    		System.out.println("Element is Not Present");
		    	}
		    }
		    catch(Exception e)
		    {
		    	System.out.println("No popup appear");
		    }
		    
		   System.out.println(driver.getTitle());
		    
		//	Submit.click();
		   Thread.sleep(3000);
		   popUpClose.click();
		}
	
		public void Userlogout() throws Exception
		{
			Thread.sleep(3000);
			UserLogOut1.click();
			System.out.println(UserLogOutText.getText());
			UserLogOut2.click();
		}
		
	}

