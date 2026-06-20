package tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class testBaseClass {
	static Properties p;
	public static WebDriver driver;
	@BeforeClass
	void setUp() throws IOException {
		p=new Properties();
		 FileReader fil = new FileReader("C:\\Users\\HP\\Desktop\\myWorkspace\\seleniumPracticeWithFramework\\src\\test\\resources\\config.properties");
		p.load(fil);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("URL"));
		
	}
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	
	 public String captureScreen(String tname) throws IOException {

	        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

	        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	        String targetFilePath = System.getProperty("user.dir")
	                + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	        
	     //   String targetFilePath1 = "C://Users//HP//Desktop//myWorkspace//frameWorkDesigning//screenshots";

	        File targetFile = new File(targetFilePath);
	        sourceFile.renameTo(targetFile);

	        return targetFilePath;
	    }
	
	
	
	

}
