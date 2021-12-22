package AssingmentWeek4Day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait1 {

	public static void main(String[] args) throws InterruptedException 
	{
		{
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://www.leafground.com/pages/alertappear.html");
			driver.manage().window().maximize();
			driver.findElement(By.id("alert")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(4000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
	}
}
}
