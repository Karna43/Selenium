package webApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptionsCapabilities {
	public static void main(String[] args) throws Exception  {
	
	WebDriverManager.edgedriver().setup();
	EdgeOptions options = new EdgeOptions();
	options.addArguments("disable-notifications", "window-size=720,1080",
						 "disable-infobars", "ignore-certificate-errors");
//	options.addArguments("--headless","disable-popups", "incognito");
	DesiredCapabilities capabilities = new DesiredCapabilities();
//	capabilities.setCapability(EdgeOptions.CAPABILITY, options);
	options.merge(capabilities);
	capabilities.setBrowserName("Microsoft Edge");
	capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Windows 10");
	WebDriver driver= new EdgeDriver(options);
	driver.get("https://www.cacert.org/");
	
	System.out.println(options.getBrowserName());
	System.out.println(capabilities.getBrowserName());
	System.out.println(capabilities.getPlatformName());
	}
}