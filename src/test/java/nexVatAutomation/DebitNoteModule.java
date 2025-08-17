package nexVatAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DebitNoteModule {
    @Test
    void DebitNoteModuleAutomation() throws InterruptedException{
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        WebDriver driver = LoginPage.driver;
        driver.manage().window().maximize();
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        selectWebElement element = new selectWebElement();
        element.selectElement(driver,actions,LocalPurchaseTestData.path1);
        Thread.sleep(2000);
        element.selectElement(driver,actions,LocalPurchaseTestData.path2);
        Thread.sleep(2000);

        WebElement challanElement = driver.findElement(
                By.cssSelector("table tr:first-child td:nth-child(3)")
        );
        String challanCopy = challanElement.getText();
//        System.out.println(challanCopy);

//        driver.switchTo().defaultContent();
          driver.navigate().back();
//        Debit Note starting:
        element.selectElement(driver,actions,DebitNoteTestData.path1);

        element.selectElement(driver,actions,DebitNoteTestData.path2);
        element.selectElement(driver,actions,DebitNoteTestData.path3);

        element.writeElement(driver,wait,DebitNoteTestData.challan_path).sendKeys(challanCopy).;
        Thread.sleep(2000);

        String debitNo = Integer.toString(DebitNoteTestData.debitNoteNo);

        element.writeElement(driver,wait,DebitNoteTestData.debitNoteNo_path).sendKeys(debitNo);
        Thread.sleep(2000);
        element.writeElement(driver,wait,DebitNoteTestData.reason_path).sendKeys(DebitNoteTestData.reason);
        Thread.sleep(2000);
        element.clickButton(driver,wait,DebitNoteTestData.save_path);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.urlContains("https://nexvat.com/debit-notes"));
        Thread.sleep(2000);

        driver.quit();
    }
}
