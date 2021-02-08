import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

        driver.get("https://udemy.com");

        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));

        //в наддном случае в выбранный инпут добавится текст и запустится поиск
        //для каждой буквы будет вызываться 3 события
        //для большого текста стрит использовать другой метод
        //лучше использовать ctrl + c, ctrl + v (предварительно добавить в буфер)
        //в случае с кликом, мы не можем кликнуть, по невидимому объекту, а текст веести можем
        element.sendKeys("Java", Keys.ENTER);

        //sendKeys можно использовать для загрузки файла,
        //ввесто текста добавляем полный путь к файлу на компьютере



        //вернет значение свойства
        //String par = element.getCssValue("transition");

        //System.out.println(par);

      //  WebElement count = driver.findElement(By.cssSelector(".category-with-counters-count-29J0p.category-with-counters-count_item-3tm8b"));
        //System.out.println(count.getText());//строка содержит иникод, но в консоли он преобразуется
    }
}
