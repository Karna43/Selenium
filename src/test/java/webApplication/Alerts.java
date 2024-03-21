package webApplication;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Alerts {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://demo.automationtesting.in/Alerts.html";
		driver.navigate().to(s);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
		driver.findElement(By.xpath("(//button[contains(text(),'click')])[1]")).click();
		Alert a = driver.switchTo().alert();
		Thread.sleep(2000);
		a.accept();
		
		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		driver.findElement(By.xpath("(//button[contains(text(),'click')])[2]")).click();
		Thread.sleep(2000);
		a.dismiss();
		
		driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
		driver.findElement(By.xpath("(//button[contains(text(),'click')])[3]")).click();
		String str = a.getText();
		System.out.println(str);
		Thread.sleep(2000);
		a.accept();
		
//		for(int i=1;i<4;i++) {
//			driver.findElement(By.xpath("(//a[@class='analystic'])["+i+"]")).click();
//			driver.findElement(By.xpath("(//button[contains(text(),'click')])["+i+"]")).click();
//			Thread.sleep(2000);
//			driver.switchTo().alert().accept();
//		}
		
		driver.quit();
	}
}
