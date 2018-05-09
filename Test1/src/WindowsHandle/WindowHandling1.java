package WindowsHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandling1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		System.out.println("Title of the main windows :" +driver.getTitle());
		
	 WebElement element = 	driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/div[1]/a/button"));
	 element.click();
	 System.out.println("Clicking on the element");
	 
	 Thread.sleep(5000);
	 
	Set<String> windowsIds =  driver.getWindowHandles();
	
	Iterator<String> itr = windowsIds.iterator();
	String mainWindows = itr.next();
	String childWindows = itr.next();
	driver.switchTo().window(childWindows);   // swit hing to child windows
	 
	 System.out.println("Title of the child windows :" +driver.getTitle());
	 
	 driver.switchTo().window(mainWindows);
	 System.out.println("Title of the child windows :" +driver.getTitle());
	 
	 driver.quit();
	 
	 
	}

}
