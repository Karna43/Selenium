package webApplication;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class WindowHandling {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://www.flipkart.com/";
		driver.navigate().to(s);
		driver.manage().window().maximize();
		
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[contains(@title,'Search')]")).sendKeys("Redmi", Keys.ENTER);
		for(int i=1;i<5;i++) {
			driver.findElement(By.xpath("(//div[@class='_4rR01T'])["+i+"]")).click();
			driver.switchTo().window(parent);
			Thread.sleep(2000);
		}
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get(s);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[contains(@title,'Search')]")).sendKeys("Realme", Keys.ENTER);
		parent = driver.getWindowHandle();
		for(int i=1;i<=5;i++) {
			driver.findElement(By.xpath("(//div[@class='_4rR01T'])["+i+"]")).click();
		}
		Set<String> set = driver.getWindowHandles();
		List<String> li = new ArrayList<>(set);
		System.out.println(li);
		System.out.println(parent);
		driver.switchTo().window(parent);
		for(int i=1;i<5;i++) {
			driver.switchTo().window(li.get(i));
			Thread.sleep(2000);
		}
		for(String i : li) {
			driver.switchTo().window(i);
			Thread.sleep(2000);
		}
		driver.quit();
	}
}
