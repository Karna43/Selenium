package webApplication;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://demoqa.com/alerts";
		driver.navigate().to(s);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		
//		Wait w = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).
//				pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
//		w.until(ExpectedConditions.alertIsPresent());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.findElement(By.xpath("(//button[text()='Click me'])[2]")).click();
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			driver.close();
			driver.findElement(By.xpath("(//button[text()='Click me'])[5]")).click();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert not found");
		} catch(NoSuchSessionException e) {
			System.out.println("Session not found");
		} catch(NoSuchElementException e) {
			System.out.println("Element not found Exception");
		} catch(StaleElementReferenceException e) {
			System.out.println("Element is already used/modified");
		} 
	}
}
