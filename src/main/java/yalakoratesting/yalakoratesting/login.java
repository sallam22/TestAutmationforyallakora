package yalakoratesting.yalakoratesting;

import static org.testng.Assert.assertEquals;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class login {

	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	
	
	@Test(priority = 1, dataProvider = "mydata")

	public void testloginpage(String username, String pass) throws IOException {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();

		try {
			// Handle the alert pop-up using seithTO alert statement
			Alert alert = driver.switchTo().alert();

			// Print alert is present
			System.out.println("Alert is present");

			// get the message which is present on pop-up
			String message = alert.getText();

			// print the pop-up message
			System.out.println(message);

			alert.accept();
		} catch (NoAlertPresentException e) {
			// if alert is not present print message
			System.out.println("alert is not present");
		}
		
		/*
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("F:\\testing\\yalakoratesting\\snapshots\\test.png"));
		*/
		

		
	}

	@DataProvider
	public Object[][] mydata() {

		Object[][] data = new Object[2][2];
		// Enter invalid Email and invalid password
		data[0][0] = "mngr30600";
		data[0][1] = "qUrEdu";
		// Enter invalid Email and valid password
		data[1][0] = "mngr30600";
		data[1][1] = "qUrEduz";

		
		
		return data;

	}

	@BeforeClass
	public void setup() {
		
		
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/index.php");

		driver.manage().window().maximize();

	}

	@AfterClass
	public void close() {
		
		report.endTest(test);
		test.log(LogStatus.PASS,"Test Passed");
		report.flush();

		driver.close();
		

	}
	
	

}
