package webApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exceptions {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://chercher.tech/practice/frames";
		driver.navigate().to(s);
		driver.manage().window().maximize();
	}
}
