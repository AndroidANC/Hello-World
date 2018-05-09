package WindowsHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class windowHandling3 {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		 driver = new FirefoxDriver();
			//driver.manage().window().maximize();
			driver.get("http://demo.automationtesting.in/Windows.html");
			System.out.println("Title of the main windows :" +driver.getTitle());
			WebElement element = driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[1]/ul/li[2]/a"));
		element.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/div[2]/button")).click(); // click on "open new seperate windows"
		Set<String> windowsID = driver.getWindowHandles();
		Iterator<String> itr = windowsID.iterator();
		String MainWindow = itr.next();
		String ChildWindow = itr.next();
		driver.switchTo().window(ChildWindow);
	   System.out.println("Child window title is => " +driver.getTitle());
	   Thread.sleep(3000);
	   driver.switchTo().window(MainWindow);
	   System.out.println("Title of the main windows is => "+driver.getTitle());
	   driver.close();
		

	}

}
