package webApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

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
		
		Name.sendKeys("Karna");
		Email.sendKeys("Karna@gmail.com");
		Password.sendKeys("Karna001");
		MobileNo.sendKeys("0000000000");
		
		for(int i=0;i<4;i++) {
			Object o = js.executeScript("return arguments["+i+"].getAttribute('value')", Name,Email,Password,MobileNo,Status);
			System.out.println(o);
		}
		
		js.executeScript("arguments[0].scrollIntoView(true)", Register);
		Status.click();
		
		js.executeScript("arguments[0].setAttribute('style','background:orange;color:blue')", Register);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", Register);
	}

}
