import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor)driver;
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

            //_____________________________

            //сохраняем дискриптор текущего окна
            String window1 = driver.getWindowHandle();

            //открываем новое окно
            js.executeScript("window.open()");

            //получим набор строк и запишем в переменную
            Set<String> currentWindows = driver.getWindowHandles();

            String window2 = null;

            for (String window : currentWindows) {
                if (!window.equals(window1)) {
                    window2 = window;
                    break;
                }
            }

            //переключаемся на второе окно
            driver.switchTo().window(window2);
            driver.get("https://www.google.ru/");

            //мы закрыли вкладку, но на нее еще не перешли
            driver.close();
            driver.switchTo().window(window1);

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            Thread.sleep(10000);
            driver.quit();
        }
    }
}
