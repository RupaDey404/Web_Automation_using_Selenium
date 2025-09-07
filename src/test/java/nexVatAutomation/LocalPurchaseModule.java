package nexVatAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocalPurchaseModule {

    @Test(invocationCount = 1)
    void LocalPurchaseAutomation() throws InterruptedException {
        WebDriver driver = null;
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        driver = LoginPage.driver;
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        selectWebElement element = new selectWebElement();
        element.selectElement(driver,actions,LocalPurchaseTestData.path1);
        Thread.sleep(2000);

        //-----------Purchase-> Local Purchase-> New Local Purchase
        element.selectElement(driver,actions,LocalPurchaseTestData.path2);
        Thread.sleep(2000);

        element.selectElement(driver,actions,LocalPurchaseTestData.path3);
        Thread.sleep(2000);

        //-----party/customer and product is select---//
        DropDown dropdown = new DropDown();
        int partyIndex = dropdown.lengthDropDown(driver,wait,1);
        int productIndex = dropdown.lengthDropDown(driver,wait,2);
        dropdown.selectDropDown(driver,wait,1,LocalPurchaseTestData.partyIndex);
        dropdown.selectDropDown(driver,wait,2,LocalPurchaseTestData.productIndex);

        element.writeElement(driver,wait,LocalPurchaseTestData.challan_path).sendKeys(LocalPurchaseTestData.challanNo);
        element.writeElement(driver,wait,LocalPurchaseTestData.vehicle_path).sendKeys(LocalPurchaseTestData.vehicleInfo);
        Thread.sleep(2000);

        String qty = Integer.toString(LocalPurchaseTestData.getRandomN());
        element.writeElement(driver,wait,LocalPurchaseTestData.qty_path).sendKeys(qty);
        Thread.sleep(2000);

        String unitP = Integer.toString(LocalPurchaseTestData.unitP);
        element.writeElement(driver,wait,LocalPurchaseTestData.unitP_path).sendKeys(unitP);
        Thread.sleep(2000);
        element.writeElement(driver,wait,LocalPurchaseTestData.reason_path).sendKeys(LocalPurchaseTestData.reason);
        element.clickButton(driver,wait,LocalPurchaseTestData.save_btn_path);
        Thread.sleep(2000);

//        driver.navigate().back();
//        Thread.sleep(3000);

        String currentDate = LocalPurchaseTestData.date;
        WebElement searchChallanDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[normalize-space()='"+currentDate+"']")
        ));


        if(searchChallanDate.isDisplayed())
            System.out.println("local purchase record inserted successfully");
        else System.out.println("Can not insert the record successfully");
        driver.quit();
    }
}
