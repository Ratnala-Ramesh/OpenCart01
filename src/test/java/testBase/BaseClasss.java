package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClasss {
    public static WebDriver driver;
    public Logger logger;
    public Properties p;
    @BeforeClass(groups= {"sanity","master","regression"})
    @Parameters({"browser","os"})
    public void setup(String br,String os) throws IOException {
    	logger=LogManager.getLogger(this.getClass());
    	FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties");
    	p=new Properties();
    	p.load(file);
    	 if(p.getProperty("env").equalsIgnoreCase("Remote")) {
   		  String url="http://10.236.1.121:4444/wd/hub"; 
   		  DesiredCapabilities cap=new DesiredCapabilities();
   		  if(os.equalsIgnoreCase("windows")) {
   			  cap.setPlatform(Platform.WIN11);
   		  }
   		  else if(os.equalsIgnoreCase("edge")) {
   			  cap.setPlatform(Platform.MAC);
   		  }
   		  else {
   			  System.out.println("please enter a valid os name");
   		  }
   		  switch(br.toLowerCase()) {
   		  case "chrome":cap.setBrowserName("chrome");break;
   		  case "edge":cap.setBrowserName("MicrosoftEdge");break;
   		  default:System.out.println("please enter vaild browser name");
   		  }
   		  driver=new RemoteWebDriver(new URL(url),cap);//import from the java net package
   	  }  	
    	switch(br.toLowerCase()){
    	case "chrome": driver=new ChromeDriver(); break;
    	case "edge": driver=new EdgeDriver(); break;
    	default :System.out.println("please enter valid browser");
    	}
    	driver.get(p.getProperty("URL"));
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass(groups= {"sanity","master","regression"})
    public void teardown() {
    	driver.quit();
    }
    public String randomString(){
    	String genrateds=RandomStringUtils.randomAlphabetic(5);
		return genrateds;
    }
    public String randomnumeric() {
    	String generatedn=RandomStringUtils.randomNumeric(5);
    	return generatedn;
    }
    public String randomalphanumeric() {
    	String ran=randomString()+"@"+randomnumeric();
    	return ran;
    }
    public String captureScreen(String path) {
    	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + path + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
    	
    }
