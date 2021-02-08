import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.avito.ru");

        WebElement element = driver.findElement(By.xpath("(//a[text()='Личные вещи'])[1]"));////a[@target='_self'][text()='Личные вещи'])

        String par = element.getAttribute("pathname");//вытаскиваем значение из properties

        System.out.println(par);

        WebElement count = driver.findElement(By.cssSelector(".category-with-counters-count-29J0p.category-with-counters-count_item-3tm8b"));
        System.out.println(count.getText());//строка содержит иникод, но в консоли он преобразуется
    }
}
