package AssingmentWeek4Day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraDuke {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath("//a[@data-group='men']"));
		builder.moveToElement(findElement).pause(3000).perform();
		driver.findElement(By.linkText("Jackets")).click();
		Thread.sleep(4000);
		String totCount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String correctCount = totCount.replaceAll("[^0-9]", "");
		int parseInt1 = Integer.parseInt(correctCount);
		System.out.println(parseInt1);
		String count1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String count2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		int correctCount1 = Integer.parseInt(count1.replaceAll("[^0-9]", ""));
		int correctCount2 = Integer.parseInt(count2.replaceAll("[^0-9]", ""));
		System.out.println(correctCount1);
		System.out.println(correctCount2);
		if(parseInt1 == (correctCount1+correctCount2))
		{
			System.out.println("Count matching");
		}
		else
		{
			System.out.println("Count not matching");
		}
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='brand-more'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='FilterDirectory-searchInput'])[1]")).sendKeys("Duke");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul[@class='FilterDirectory-list']//label")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove'])[1]")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		List<String> brandList = new ArrayList<String>();
		System.out.println("element size"+findElements.size());
		for (int i = 1; i <= findElements.size(); i++) 
		{
			brandList.add(driver.findElement(By.xpath("(//h3[@class='product-brand'])["+i+"]")).getText());
		}
		System.out.println(brandList);
		driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText());
		driver.findElement(By.xpath("(//div[@class='product-imageSliderContainer'])[1]")).click();
		Thread.sleep(5000);
		Set<String> windowHandles = driver.getWindowHandles();
		List <String> handel = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handel.get(1));
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./myntra.png");
		FileUtils.copyFile(screenshotAs, dest);	
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.close();
	}

}
