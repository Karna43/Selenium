package webApplication;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Browser2 {
	public static void main(String[] args) throws Exception {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karna\\eclipse-workspace\\Selenium\\target\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://www.myntra.com/";
		
		driver.get(s);
		driver.manage().window().maximize();
		driver.manage().window().minimize(); Thread.sleep(2000);
		driver.manage().window().maximize();
		
		
		driver.navigate().to(s);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.close();
		driver.quit();
	}
}
