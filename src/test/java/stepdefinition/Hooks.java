package stepdefinition;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;

public class Hooks {
public static WebDriver driver=new ChromeDriver();
public Logger logger;
@BeforeAll
public  static void driverSetup() {
	//logger= LogManager.getLogger(this.getClass());

	driver.get("https://www.makemytrip.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
@AfterAll
public static void teardown() {
	driver.quit();
}
@AfterStep
public void screenshot() throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		// Get the current time-stamp
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = dateFormat.format(new Date(0));
		// Create a unique filename using the time-stamp
		String target = System.getProperty("user.dir") + "/ScreenShot1cucumber/";
		String filename = target + "screenshot_" + timestamp + ".png";
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(filename);
		FileUtils.copyFile(src, trg);
	}
//@AfterStep
//public void addScreenshot(Scenario scenario) {
//    
//	// this is for cucumber junit report
//   // if(scenario.isFailed()) {
//    	
//    	TakesScreenshot ts=(TakesScreenshot) driver;
//    	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
//    	((Object) scenario).attach(screenshot, "image/png",scenario.getGherkinName());
//    	            
//    }
}
