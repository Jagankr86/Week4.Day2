package AssingmentWeek4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assingnment6 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		List<WebElement> findElements = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		List <String> empName = new ArrayList<String>();
		List <String> empName1 = new ArrayList<String>();
		for (int i = 1; i < findElements.size(); i++) 
		{
			String text = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			empName.add(text);
		}
		driver.findElement(By.xpath("//table[@id='table_id']//tr/th[text()='Name']")).click();
		for (int i = 1; i < findElements.size(); i++) 
		{
			String text1 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			empName1.add(text1);
		}
		Collections.sort(empName);
		System.out.println(empName);
		System.out.println(empName1);		
		if(empName.equals(empName1))
		{
			System.out.println("Array List are equal");
		}
		else
		{
			System.out.println("Array List are not equal");
		}
	}
}