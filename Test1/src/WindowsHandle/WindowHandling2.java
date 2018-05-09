package WindowsHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandling2 {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
	    driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		System.out.println("Title of the main windows :" +driver.getTitle());
		
	 WebElement element = 	driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/div[1]/a/button"));  // click button
	 element.click();
	
	 Thread.sleep(5000);
	 
	 switchToWindows(2);
	  
	 System.out.println("Title of the child windows :" +driver.getTitle());
	 Thread.sleep(5000);
	 
	 switchToWindows(1);
	 
	 System.out.println("Title of the windows :" +driver.getTitle());
	 
	 driver.quit();
	  
	}
	
	public static void switchToWindows(int index)  // method to call in our framework
	{
		String windowsId = null;
		Set<String> windowsIds =  driver.getWindowHandles();
		
		Iterator<String> itr = windowsIds.iterator();
		
		for(int i=1; i <=index ; i++)
		{
			windowsId =	itr.next();	
		}
		driver.switchTo().window(windowsId);
		
	}

}
