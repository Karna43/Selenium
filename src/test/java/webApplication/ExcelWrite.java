package webApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ExcelWrite {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Karna\\Pictures\\Screenshots\\WriteData.xlsx");
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		String s = "https://www.flipkart.com/";
		driver.get(s);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys("Redmi Mobile",Keys.RETURN);
		List<WebElement> name = driver.findElements(By.xpath("//div[contains(@class,'rR01T')]"));
		List<WebElement> price = driver.findElements(By.xpath("//div[contains(@class,'WHN1')]"));	
		
		try {
			FileOutputStream f = new FileOutputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Flipkart");
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell = row.createCell(0);
			cell.setCellValue("Mobile Name");
			cell = row.createCell(1);
			cell.setCellValue("Price");
			for(int i=0;i<name.size();i++) {
				row = sheet.createRow(i+1);
				for(int j=0;j<2;j++) {
					cell = row.createCell(j);
					if(j==0) {
						cell.setCellValue(name.get(i).getText());
					}
					else {
						cell.setCellValue(price.get(i).getText());
					}
				}
			}
			workbook.write(f);
			workbook.close();
			f.close();
			System.out.println("Data updated in Excel");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
