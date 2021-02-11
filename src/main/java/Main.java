import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(1500);
            WebElement element1 = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver);

            //навести курсор на элемент, нажать и удерживать, перевести курсов на второй элемент, отпустить, собрать тест
            //actions.moveToElement(element1).clickAndHold().moveToElement(element2).release().build().perform();

            //есть готовый метод, который делает то же самое
            actions.dragAndDropBy(element1, 200, 200);

            //когда нужна задержка в цепочке событий
            actions.pause(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }


        //основные методы
        /*actions
                .moveToElement()
                .keyDown()
                .keyUp()
                .clickAndHold()
                .release()//отпустить после clickAndHold
                .build()//сборка
                .perform();//применяем
        */

        //в наддном случае в выбранный инпут добавится текст и запустится поиск
        //для каждой буквы будет вызываться 3 события
        //для большого текста стрит использовать другой метод
        //лучше использовать ctrl + c, ctrl + v (предварительно добавить в буфер)
        //в случае с кликом, мы не можем кликнуть, по невидимому объекту, а текст веести можем
       // element.sendKeys("Java", Keys.ENTER);

        //sendKeys можно использовать для загрузки файла,
        //ввесто текста добавляем полный путь к файлу на компьютере



        //вернет значение свойства
        //String par = element.getCssValue("transition");

        //System.out.println(par);

      //  WebElement count = driver.findElement(By.cssSelector(".category-with-counters-count-29J0p.category-with-counters-count_item-3tm8b"));
        //System.out.println(count.getText());//строка содержит иникод, но в консоли он преобразуется
    }
}
