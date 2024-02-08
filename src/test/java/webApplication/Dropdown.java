package webApplication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://chercher.tech/practice/practice-dropdowns-selenium-webdriver";
		driver.navigate().to(s);
		driver.manage().window().maximize();
		
		WebElement w = driver.findElement(By.xpath("(//select[@class='col-lg-3'])[1]"));
		Select option = new Select(w);
		option.selectByIndex(0);
		option.selectByValue("Yahoo");
		option.selectByVisibleText("Bing");
		
		List<WebElement> options1 = option.getOptions();
		for(WebElement i : options1) {
			System.out.println(i.getText());
		}
		System.out.println();
		
		WebElement w1 = driver.findElement(By.xpath("(//select[@class='col-lg-3'])[3]"));
		option = new Select(w1);
		System.out.println("Mutiple Selection dropdown: "+option.isMultiple()+"\n");
		List<WebElement> options2 = option.getOptions();
		for(int i=0;i<options2.size();i++) {
			option.selectByIndex(i);
		}
		for(WebElement i : option.getAllSelectedOptions()) {
			System.out.println(i.getText());
		}
		System.out.println("\n"+option.getFirstSelectedOption().getText());
		option.deselectAll();
		try {
			System.out.println("\n"+option.getFirstSelectedOption().getText());
		}
		catch(Exception e){
			System.out.println("\nNo Elements found");
		}
		driver.quit();
	}
}
