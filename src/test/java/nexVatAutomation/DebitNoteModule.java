package nexVatAutomation;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DebitNoteModule {
    @Test
    void DebitNoteModuleAutomation() throws InterruptedException{
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        WebDriver driver = LoginPage.driver;
        driver.manage().window().maximize();
        Thread.sleep(1000);

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
        System.out.println(challanCopy);

        driver.switchTo().defaultContent();
          driver.navigate().back();
//        Debit Note starting:
        element.selectElement(driver,actions,DebitNoteTestData.path1);

        element.selectElement(driver,actions,DebitNoteTestData.path2);
        element.selectElement(driver,actions,DebitNoteTestData.path3);

        element.writeElement(driver,wait,DebitNoteTestData.challan_path).sendKeys(challanCopy,Keys.TAB);
        Thread.sleep(2000);


        try {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement alert = wait1.until(ExpectedConditions.presenceOfElementLocated(
//                    By.xpath("//div[@class='toast-message']")
                    By.xpath("//div[@role='dialog']")
            ));

            String getAlertText = alert.getText().trim();
            System.out.println("Toast message: " + getAlertText);

            Assert.assertTrue(getAlertText.contains("Already exists a debit note"));
            System.out.println("This challan has already been issued for debit note");
            driver.quit();
            return;  // stop execution, since no need to create again
        }
           catch (TimeoutException e){
            //else{
            element.writeElement(driver, wait, DebitNoteTestData.debitNoteNo_path).sendKeys(DebitNoteTestData.debitNoteNo);
            Thread.sleep(2000);

            String rtnQty = Integer.toString(DebitNoteTestData.getRtnQty());
            element.writeElement(driver, wait, DebitNoteTestData.rtnQty_path).sendKeys(rtnQty);
            Thread.sleep(2000);
            System.out.println("Return qty: " + rtnQty);

            element.writeElement(driver, wait, DebitNoteTestData.reason_path).sendKeys(DebitNoteTestData.reason);
            Thread.sleep(2000);

            element.clickButton(driver, wait, DebitNoteTestData.save_path);
            Thread.sleep(2000);

            wait.until(ExpectedConditions.urlContains("https://nexvat.com/debit-notes"));
//          wait.until(ExpectedConditions.urlContains("http://localhost:3000/debit-notes"));
            Thread.sleep(2000);

            WebElement debitNoteElement = driver.findElement(
                    By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)")
            );
            String getTextDebitNo = debitNoteElement.getText();
            System.out.println("debit note no: " + getTextDebitNo);
            Assert.assertTrue(getTextDebitNo.matches("\\d+"));

            System.out.println("Debit note created successfully");
        }
        driver.quit();
    }
}
