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
        Thread.sleep(2000);

        driver.navigate().to("https://www.daraz.com.bd/");
        //driver.manage().window().maximize();
        Thread.sleep(2000);

        String title = driver.getTitle();
        if(title.equalsIgnoreCase("daraz"))
            System.out.println("Title matches");
        else System.out.println(title);

        WebElement slider = driver.findElement(By.cssSelector(".swiper-slide.swiper-slide-active a"));
        slider.click();
        Thread.sleep(2000);

        WebElement category = driver.findElement(By.cssSelector("div.lzd-site-nav-menu.lzd-site-nav-menu-active"));
        Actions actions = new Actions(driver);
        actions.moveToElement(category).perform();
        Thread.sleep(2000);
        WebElement item = driver.findElement(By.xpath("//span[text()='Groceries']"));
        actions.moveToElement(item);
        actions.click();
        actions.perform();
        Thread.sleep(2000);

        WebElement breakfast = driver.findElement(By.xpath("//span[text() ='Breakfast')]"));
        actions.moveToElement(breakfast);
        actions.click();
        actions.perform();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Honey")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
