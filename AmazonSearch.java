package AssingmentWeek4Day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearch {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		//driver.switchTo().frame("nav-search-bar-form");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		//driver.switchTo().defaultContent();
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		String rating = driver.findElement(By.xpath("(//span[@class='a-size-base'])[1]")).getText();
		System.out.println(rating);
		//WebElement starRating = driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative']/i)[1]"));
		//String text1 = driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative']//span)[1]")).getText();
		//System.out.println(text1);
		WebElement starRating1 = driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative'])[1]"));
		builder.click(starRating1).pause(2000).perform();
		Thread.sleep(3000);
		String percentageRating = driver.findElement(By.xpath("//table[@id='histogramTable']//tr[1]/td[3]//a")).getText();
		System.out.println(percentageRating);
		String imgLink = driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).getAttribute("src");
		System.out.println(imgLink);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> handel1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(handel1.get(1));
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//img[@alt='OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)'])[1]")).click();
		//driver.switchTo().window(handel.get(1));
		Thread.sleep(3000);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./mobile.png");
		FileUtils.copyFile(screenshotAs, dest);	
		driver.findElement(By.xpath("//button[@class=' a-button-close a-declarative a-button-top-right']/i")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		String grandTot = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		System.out.println(grandTot+"&&&&"+price);
		if (price==grandTot) 
		{
			System.out.println("Match Price");
		}
		else
		{
			System.out.println("No Matching");
		}
	}
}
