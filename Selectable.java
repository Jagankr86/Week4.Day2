package AssingmentWeek4Day2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notificatios");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement findElement = driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-arrowthick-2-n-s'])[2]"));
		WebElement findElement2 = driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-arrowthick-2-n-s'])[5]"));
		builder.dragAndDropBy(findElement, 9, 100).perform();
	}

}
