package WaitsEg;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsExamples {
	WebDriver driver;

	@Test
	public void imlicitelyWait() {
		System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // for
																		// handling
																		// TimeOut
																		// Exception
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); // NoSuchElement
																			// timeout
		driver.get("http://demo.guru99.com/test/guru99home/");
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		driver.manage().window().maximize();
		Assert.assertEquals(actTitle, "Demo Guru99 Page");
	}

	@Test
	public void explicitWait() {
		System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));
		driver.findElement(By.id("email")).sendKeys("neha");
	}

	@Test
	public void explicitwaitEg2() {
		System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
		Wait w = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.pollingEvery(3, TimeUnit.SECONDS);
	w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password"))));
	driver.findElement(By.id("password")).sendKeys("123456");
	}
}
