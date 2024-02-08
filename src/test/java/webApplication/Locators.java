package webApplication;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Locators {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://www.naukri.com/nlogin/login";
		
		driver.navigate().to(s);;
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement id1 = driver.findElement(By.id("usernameField"));
		id1.sendKeys("Karna");
		WebElement id2 = driver.findElement(By.id("passwordField"));
		id2.sendKeys("karna");
		
		String attribute1 = id1.getAttribute("id");
		String attribute2 = id2.getAttribute("placeholder");
		System.out.println("id1: "+attribute1+"\nid2: "+attribute2);
		
		WebElement link1 = driver.findElement(By.linkText("Forgot Password?"));
		link1.click();
		
		driver.navigate().back();
		
		List<WebElement> tags = driver.findElements(By.tagName("div"));
		for(WebElement i : tags) {
			String tag = i.getText();
			System.out.println(tag);
		}
		
		WebElement x1 = driver.findElement(By.xpath("//button[contains(text(),'OTP')]"));
		x1.click(); 
		
		WebElement x2 = driver.findElement(By.xpath("//input[@type='tel']"));
		x2.sendKeys("9090000"); 
		WebElement x3 = driver.findElement(By.xpath("//button[contains(text(),'Email')]"));
		x3.click();
		
		WebElement x4 = driver.findElement(By.xpath("//input[contains(@placeholder,'Username')]"));
		x4.sendKeys("Karna001"); 
		WebElement x5 = driver.findElement(By.xpath("//input[@type='password']"));
		x5.sendKeys("karna001"); 
		WebElement x6 = driver.findElement(By.xpath("//button[text()='Login']"));
		x6.click();
	}
}
