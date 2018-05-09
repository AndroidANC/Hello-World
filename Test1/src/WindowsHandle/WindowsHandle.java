package WindowsHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowsHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		 driver = new FirefoxDriver();
			//driver.manage().window().maximize();
			driver.get("http://demo.automationtesting.in/Windows.html");
			System.out.println("Title of the main windows :" +driver.getTitle());
			driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[2]/div[3]/button")).click();
			Thread.sleep(5000);
			Set<String> windowsID = driver.getWindowHandles();
			System.out.println("Size of the windows is =>"+windowsID.size());
			Iterator<String> itr = windowsID.iterator();
			String mainWindow = itr.next();
			String Child_Windows1 = itr.next();
			String Child_Windows2 = itr.next();
			
			driver.switchTo().window(Child_Windows1);
			System.out.println("Title of the 1st child window is => "+driver.getTitle());
		    driver.close();
			Thread.sleep(3000);
			driver.switchTo().window(Child_Windows2);
			System.out.println("Titrle of the 2nd child window is = > "+driver.getTitle());
			driver.close();
			Thread.sleep(3000);
			driver.switchTo().window(mainWindow);
			System.out.println("Titrle of the main window is = > "+driver.getTitle());
			driver.close();
			
			

	}

}
