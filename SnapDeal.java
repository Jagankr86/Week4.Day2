package AssingmentWeek4Day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.soap.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath("(//a[@class='menuLinks leftCategoriesProduct ']/span)[2]"));
		builder.click(findElement).pause(4000).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("(//div[@class='sorting-sec animBounce']/ul/li)[2]")).click();
		Thread.sleep(3000);
		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='lfloat marR10']//span[@class='lfloat product-price']"));
		List <String> priceList1 = new ArrayList<String>();
		List <String> priceList2 = new ArrayList<String>();
		for (int i = 1; i <=priceList.size(); i++) 
		{
			String text = driver.findElement(By.xpath("(//div[@class='lfloat marR10']//span[@class='lfloat product-price'])["+i+"]")).getText();
			priceList1.add(text);
			priceList2.add(text);
		}
			System.out.println(priceList1);
			System.out.println(priceList2);
			if(priceList1==priceList2)
			{
				System.out.println("Price Sorted");
			}
			else
			{
				System.out.println("Not Sorted");
			}
			WebElement findElement2 = driver.findElement(By.xpath("//a[@class='price-slider-scroll left-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
			WebElement findElement3 = driver.findElement(By.xpath("//a[@class='price-slider-scroll right-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
			int x = driver.findElement(By.xpath("//a[@class='price-slider-scroll left-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']")).getLocation().getX();
			int x1 = driver.findElement(By.xpath("//a[@class='price-slider-scroll left-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']")).getLocation().getY();
			int y = driver.findElement(By.xpath("//a[@class='price-slider-scroll right-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']")).getLocation().getX();
			int y1 = driver.findElement(By.xpath("//a[@class='price-slider-scroll right-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']")).getLocation().getY();
			System.out.println(x);
			System.out.println(x1);
			System.out.println(y);
			System.out.println(y1);
			builder.dragAndDropBy(findElement2, 37, 0).perform();
			Thread.sleep(2000);
			builder.dragAndDropBy(findElement3, -67, 0).perform();
			//builder.moveToElement(findElement3, 30, 50).click().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//label[@for='Color_s-Blue']/span")).click();
			//driver.findElement(By.linkText("Blue")).click();
			//String filter = driver.findElement(By.xpath("//div[@class='filters']/div")).getAttribute("class");
			List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='filters']//div"));
			System.out.println("element size"+findElements.size());
			List <String> filter = new ArrayList<String> ();
			for (int i = 1; i <=findElements.size(); i++) 
			{
				filter.add(driver.findElement(By.xpath("(//div[@class='filters']//div)["+i+"]")).getText());
			}
			System.out.println(filter);
			WebElement findElement4 = driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-like-outline heart-icon animated-font-pre'])[1]"));
			builder.moveToElement(findElement4).perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
			Thread.sleep(3000);    
			String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
			String percentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
			System.out.println("Price is"+price);
			System.out.println("% is"+percentage);
			WebElement findElement5 = driver.findElement(By.xpath("(//img[@class='cloudzoom'])[1]"));
			File screenshotAs = findElement5.getScreenshotAs(OutputType.FILE);
			File dest = new File("./shoe.png");
			FileUtils.copyFile(screenshotAs, dest);	
			driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
			//driver.quit();
	}
}