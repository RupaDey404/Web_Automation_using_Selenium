package nexVatAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage {
    static WebDriver driver;

    @Test
    void login() throws InterruptedException{

//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.get("https://nexvat.com/login");
        driver.get("http://localhost:3000/login");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        email.sendKeys("super@nextpagetl.com");
        Thread.sleep(2000);
        password.sendKeys("123123");
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(3000);
    }
}
