package AssingmentWeek4Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("ms",Keys.TAB);
		
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("mdu",Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		driver.findElement(By.id("buttonFromTo")).click();
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(3000);
		List<WebElement> findElements = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		System.out.println(findElements.size());
		List <String> trainName = new ArrayList<String>();
		for (int i = 1; i <= findElements.size(); i++) 
		{
			String trainNames = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
			trainName.add(trainNames);
		}	
			Collections.sort(trainName);
			System.out.print("Train Name are:");
			System.out.print(trainName);
	}

}
