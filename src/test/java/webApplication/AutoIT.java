package webApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIT {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://www.naukri.com/registration/createAccount?othersrcp=22636";
		driver.navigate().to(s);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(), 'Upload')]")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Karna\\Documents\\autoit.exe");
		
	}
}
