import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        //y.xpath("//input[@aria-label='Найти']") - локатор
        //определяет как и что искать
        //WebElement inputs = driver.findElements(By.xpath("//input[@aria-label='Найти']"));
        //WebElement input = driver.findElement(By.xpath("//input[@aria-label='Найти']"));
        //WebElement input = driver.findElement(By.cssSelector(""));
        //WebElement input = driver.findElement(By.className(""));
        //WebElement input = driver.findElement(By.id("")); //сервер генерирует id динамически
        //WebElement input = driver.findElement(By.linkText(""));//по тексту ссылку (очень долгий метод
        WebElement input = driver.findElement(By.xpath("//input[@aria-label='Найти']"));

        input.click();
    }
}
