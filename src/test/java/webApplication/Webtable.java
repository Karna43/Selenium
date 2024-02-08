package webApplication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String s = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
		driver.navigate().to(s);
		driver.manage().window().maximize();
		
		List<WebElement> tables = driver.findElements(By.tagName("table"));
		for(int i=0;i<tables.size();i++) {
			WebElement table = tables.get(i);
			WebElement tbody = table.findElement(By.tagName("tbody"));
			List<WebElement> trows = tbody.findElements(By.tagName("tr"));
			for(int j=0;j<trows.size();j++) {
				WebElement trow = trows.get(j);
				List<WebElement> tdata = trow.findElements(By.tagName("td"));
				for(int k=0;k<tdata.size();k++) {
					WebElement data = tdata.get(k);
					String str = data.getText();
					System.out.printf("%-18s",str);
				}
				System.out.println();
			}System.out.println();
		}
		for(int i=0;i<tables.size();i++) {
			WebElement table = tables.get(i);
			WebElement tbody = table.findElement(By.tagName("tbody"));
			List<WebElement> trows = tbody.findElements(By.tagName("tr"));
			for(int j=0;j<trows.size();j++) {
				WebElement trow = trows.get(j);
				List<WebElement> tdata = trow.findElements(By.tagName("td"));
				for(int k=0;k<tdata.size();k++) {
					WebElement data = tdata.get(k);
					String str = data.getText();
					if(str.equals("Google")) {
						System.out.println("\nCountry of Google: "+tdata.get(2).getText());
					}
					if(str.equals("UAE")) {
						for(WebElement l : tdata) {
							System.out.print(l.getText()+"  ");
						}}}}}}}