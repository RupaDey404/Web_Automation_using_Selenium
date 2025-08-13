package nexVatAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocalPurchaseModule {

    @Test
    void LocalPurchaseAutomation() throws InterruptedException {
        WebDriver driver = null;
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        driver = LoginPage.driver;
        driver.manage().window().maximize();
        WebElement purchase = driver.findElement(By.xpath("//span[@title='Purchase']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(purchase).pause(Duration.ofSeconds(2)).click();
//        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        //-----------Purchase-> Local Purchase-> New Local Purchase
        WebElement localPurchase = driver.findElement(By.xpath("//span[normalize-space()='Local Purchases']"));
        actions.moveToElement(localPurchase).pause(Duration.ofSeconds(2)).click();
        ;
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);
        WebElement newLocalPurchase = driver.findElement(By.xpath("//button[normalize-space()='New Local Purchase']"));
        actions.moveToElement(newLocalPurchase).pause(Duration.ofSeconds(2)).click();
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        //-----party/customer select


        driver.quit();
    }
}
