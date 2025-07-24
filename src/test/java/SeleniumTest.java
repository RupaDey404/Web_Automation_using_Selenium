import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    public static WebDriver driver = null;
    @Test
    void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // driver.get("https://www.youtube.com/");
       // Thread.sleep(2000);

        //load the daraz website.
        driver.navigate().to("https://www.daraz.com.bd/");
        //driver.manage().window().maximize();
        Thread.sleep(2000);

        //check the title of this site.
        String title = driver.getTitle();
        if(title.equalsIgnoreCase("daraz"))
            System.out.println("Title matches");
        else System.out.println(title);

        //click on the slider and go to the next page which is category page.
        WebElement slider = driver.findElement(By.cssSelector(".swiper-slide.swiper-slide-active a"));
        slider.click();
        Thread.sleep(2000);

        //Select the specific category with hover: E.g. category>groceries>breakfast>honey>new page open
        WebElement category = driver.findElement(By.cssSelector("div.lzd-site-nav-menu.lzd-site-nav-menu-active"));
        Actions actions = new Actions(driver);
        actions.moveToElement(category).pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);
        WebElement item = driver.findElement    (By.xpath("//span[text()='Groceries']"));
        actions.moveToElement(item);
        actions.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        WebElement breakfast = driver.findElement(By.xpath("//a[@class='lzd-site-menu-root-item-link']//span[contains(text(),'Breakfast')]"));
        actions.moveToElement(breakfast);
        actions.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        WebElement honey = driver.findElement(By.xpath("//li[@class='lzd-site-menu-grand-item']//span[contains(text(),'Honey')]"));
        actions.moveToElement(honey).pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        System.out.println("navigated successfully");

        driver.quit();
    }
}
