package webApplication;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Action {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://www.flipkart.com/";
		driver.navigate().to(s);
		driver.manage().window().maximize();
		WebElement web = driver.findElement(By.xpath("//a[@title='Login']"));
		Actions a = new Actions(driver);
		a.moveToElement(web).build().perform();
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		s = "https://www.naukri.com/nlogin/login";
		driver.navigate().to(s);
		Thread.sleep(5000);
		
		WebElement id = driver.findElement(By.id("usernameField"));
		id.sendKeys("Karna");
		a.doubleClick(id).build().perform();
		a.contextClick(id).build().perform();
		
		Robot r = new Robot();
		for(int i=0; i<2; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		s = "https://demo.guru99.com/test/drag_drop.html";
		driver.navigate().to(s);
		driver.manage().window().maximize();
		WebElement drag;
		WebElement drop;
		drag = driver.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
		drop = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
		a.dragAndDrop(drag, drop).build().perform();
		//a.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
		drag = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
		drop = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
		a.dragAndDrop(drag, drop).build().perform();
		drag = driver.findElement(By.xpath("(//a[@class='button button-orange'])[6]"));
		drop = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
		a.dragAndDrop(drag, drop).build().perform();
		drag = driver.findElement(By.xpath("(//a[@class='button button-orange'])[4]"));
		drop = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
		a.dragAndDrop(drag, drop).build().perform();
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get(s);
		int j;
		for(int i=1; i<5; i++) {
			if(i==1) j=5;
			else if(i==2) j=2;
			else if(i==3) j=6;
			else j=4;
			drag = driver.findElement(By.xpath("(//a[@class='button button-orange'])["+j+"]"));
			drop = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
			a.dragAndDrop(drag, drop).build().perform();
		}
		
		TakesScreenshot img = (TakesScreenshot) driver;
		File f = img.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\Karna\\eclipse-workspace\\Selenium\\target\\Image.png");
		FileUtils.copyFile(f, d);
		
		driver.quit();
	}
}
