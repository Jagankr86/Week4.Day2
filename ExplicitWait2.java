package AssingmentWeek4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait2 {

	public static void main(String[] args) 
	{
		{
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://www.leafground.com/pages/disapper.html");
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("strong"))));
			System.out.println(driver.findElement(By.tagName("strong")).getText());
	}
}
}
