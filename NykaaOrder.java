package AssingmentWeek4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.command.InspectExecResponse.Container;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaOrder {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		WebElement brandElement = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brandElement).pause(2000).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		String title = driver.getTitle();
		if(title.contains("L'Oreal Paris"))
		{
			System.out.println("Title contains L'Oreal Paris");
		}
		else
		{
			System.out.println("Title not contains L'Oreal Paris");
		}
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		String text = driver.findElement(By.xpath("(//div[@class='css-rtde4j']//span)[1]")).getText();
		if(text.contains("Shampoo"))
		{
			System.out.println("Shampoo selected");
		}
		else
		{
			System.out.println("Shampoo not selected");
		}
		driver.findElement(By.xpath("//div[@class='css-43m2vm']/img")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handel = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handel.get(1));
		WebElement findElement = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select select = new Select(findElement);
		select.selectByIndex(2);
		Thread.sleep(2000);
		String mrpRate = driver.findElement(By.xpath("//span[@class='css-12x6n3h']")).getText();
		System.out.println("MRP Rate is:"+mrpRate);
		driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		driver.switchTo().frame(0);
		String grandTot = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println(grandTot);
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		String grandTot1 = driver.findElement(By.xpath("(//div[@class='value']/span)[2]")).getText();
		System.out.println(grandTot1);
		if(grandTot.equalsIgnoreCase(grandTot1))
		{
			System.out.println("total matching");
		}
		else
		{
			System.out.println("total not matching");
		}
		driver.close();
	}
}