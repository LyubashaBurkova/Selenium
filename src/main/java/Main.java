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

        //неявное ожидание - задано по умолчанию
        //manage - настройка
        //timeouts().implicitlyWait - задаем ожидание
        //10, TimeUnit.SECONDS - сколько и чего
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); устаревший метод
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //явное ожидание - для определенного элемента мы задаем параметры
        //создаем экземпляр WebDriverWait - класс, который отвечает за ожидание
        //передаем ему драйвер и время
        //вызываем метод until() для установки явного ожидания
        //в until передаем то, что мы ожидаем
        //у ExpectedConditions мы вызываем различные методв, кождый метод отвечает за определенное событие
        //presenceOfElementLocated ожидаем появление элемента
        //By.id("123435") - этот элемента мы найдем и будем ожидать его появление 10 с
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("123435"))));
        //в element запишется элемент с id 12345

        driver.get("https://google.com");

        //неявные ожидания работают быстрее
        WebElement input = driver.findElement(By.xpath("//input[@aria-label='Найти']"));

        input.click();
    }
}
