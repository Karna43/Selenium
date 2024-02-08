package webApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Frames {
	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://chercher.tech/practice/frames";
		driver.navigate().to(s);
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame1");
		WebElement w1 = driver.findElement(By.xpath("//input[@type='text']"));
		w1.click();
		w1.sendKeys("Karuna");
		Thread.sleep(2000);
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		Thread.sleep(2000);
		
		driver.switchTo().parentFrame();
		WebElement w2 = driver.findElement(By.xpath("//input[@type='text']"));
		w2.click();
		w2.sendKeys("karan");
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		WebElement w3 = driver.findElement(By.xpath("//h1[@class='breadcrumb-item']"));
		System.out.println(w3.getText());
		
		driver.switchTo().frame("frame2");
		System.out.println(driver.findElement(By.id("animals")).getText());
		
		Thread.sleep(2000);
		driver.quit();
	}

}
