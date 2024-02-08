package webApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExec {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://www.naukri.com/registration/createAccount?othersrcp=22636";
		driver.navigate().to(s);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		WebElement Name = driver.findElement(By.id("name"));
		WebElement Email = driver.findElement(By.name("email"));
		WebElement Password = driver.findElement(By.xpath("//input[contains(@placeholder,'Create')]"));
		WebElement MobileNo = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		WebElement Status = driver.findElement(By.xpath("//div[@class='textWrap']"));
		WebElement Register = driver.findElement(By.xpath("//button[text()='Register now']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[4].scrollIntoView(true)", Name,Email,Password,MobileNo,Status);
		js.executeScript("arguments[4].click()", Name,Email,Password,MobileNo,Status);
		
		driver.findElement(By.xpath("//button[contains(text(), 'Upload')]")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Karna\\Documents\\autoit.exe");
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView(false)", Name,Email,Password,MobileNo,Status);
		js.executeScript("arguments[0].setAttribute('value','Karna')", Name,Email,Password,MobileNo,Status);
		js.executeScript("arguments[1].setAttribute('value','Karna@gmail.com')", Name,Email,Password,MobileNo,Status);
		js.executeScript("arguments[2].setAttribute('value','Karna001')", Name,Email,Password,MobileNo,Status);
		js.executeScript("arguments[3].setAttribute('value','0000000000')", Name,Email,Password,MobileNo,Status);
		
		for(int i=0;i<4;i++) {
			Object o = js.executeScript("return arguments["+i+"].getAttribute('value')", Name,Email,Password,MobileNo,Status);
			System.out.println(o);
		}
		
		js.executeScript("arguments[0].scrollIntoView(true)", Register);
		js.executeScript("arguments[0].setAttribute('style','background:Yellow;color:red')", Register);
		js.executeScript("arguments[0].click()", Register);
	}
}
