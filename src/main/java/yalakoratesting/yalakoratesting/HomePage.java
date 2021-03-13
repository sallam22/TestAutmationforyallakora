package yalakoratesting.yalakoratesting;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

@Test
public class HomePage {
	WebDriver driver;

	public void CheckActionOfYallaKora() throws ATUTestRecorderException  {
		
		ATUTestRecorder recorder= new ATUTestRecorder("F:\\testing\\yalakoratesting\\videos","test1",false);
		recorder.start();
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	
		
		driver.findElement(By.linkText("المباريات")).click();
		driver.findElement(By.linkText("الأخبار")).click();
		driver.findElement(By.linkText("دوريات وبطولات")).click();
		driver.findElement(By.linkText("مالتيميديا")).click();
		driver.findElement(By.linkText("كلام فى الكورة")).click();
		driver.findElement(By.linkText("نجوم الفانتازى")).click();
		driver.findElement(By.linkText("آخر الانتقالات")).click();
		//driver.findElement(By.linkText("مونديال اليد")).click();
		
		
		
		recorder.stop();

	}

	public void CheckSearchFunctionality() throws IOException {

		driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[5]")).click();
		driver.findElement(By.id("HeadertxtSearch")).sendKeys("Al Ahly");
		driver.findElement(By.xpath("//*[@id=\"HeaderbtnSearch\"]")).click();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("F:\\testing\\yalakoratesting\\snapshots\\alahaly.png"));

	}

	public void Checkmoresports() {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"navBtn\"]")).click();


		driver.findElement(By.linkText("كأس مصر")).click();
/*
		driver.findElement(By.linkText("كأس العالم للأندية")).click();
		driver.findElement(By.linkText("بطولة العالم لكرة اليد للرجال")).click();
		driver.findElement(By.linkText("الدوري الإنجليزي")).click();
		driver.findElement(By.linkText("الدوري الإسباني")).click();
		driver.findElement(By.linkText("الدوري الإيطالي")).click();
		driver.findElement(By.linkText("الدوري الفرنسي")).click();
		driver.findElement(By.linkText("دوري أبطال أوروبا")).click();
		driver.findElement(By.linkText("دوري أبطال إفريقيا")).click();
*/
	}

	@BeforeClass
	public void setup() {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.yallakora.com/");

		driver.manage().window().maximize();

	}

	@AfterClass
	public void close() {

		 driver.close();

	}

}
