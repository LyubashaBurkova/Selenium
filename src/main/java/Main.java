import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://127.0.0.1:5500/index.html");
            Thread.sleep(2000);

            WebElement element1 = driver.findElement(By.id("a"));
            WebElement element2 = driver.findElement(By.id("b"));
            WebElement element3 = driver.findElement(By.id("c"));

            element1.click();

            //Переключение на alert, но тот не известно, когда он появился
            //Alert alert = driver.switchTo().alert();

            //ждем пока alert появится
            Alert alert = wait.until(alertIsPresent());
            //нажатие на ок
            alert.accept();

            element2.click();
            Alert prompt = wait.until(alertIsPresent());
            prompt.sendKeys("Supper!");
            prompt.accept();

            Alert alertAfterPrompt = wait.until(alertIsPresent());
            Thread.sleep(4000);
            alertAfterPrompt.accept();

            element3.click();
            Alert confirm = wait.until(alertIsPresent());
            //нажатие на отмена
            confirm.dismiss();

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            Thread.sleep(10000);
            driver.quit();
        }
    }
}
