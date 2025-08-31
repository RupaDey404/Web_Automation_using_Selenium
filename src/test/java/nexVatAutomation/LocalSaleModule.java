package nexVatAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocalSaleModule {
    @Test
    public void LocalSaleAutomation() throws InterruptedException{
        WebDriver driver = null;

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        driver = LoginPage.driver;
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        selectWebElement element = new selectWebElement();
        DropDown dropDown = new DropDown();

        element.selectElement(driver,actions,LocalSaleTestData.inventory_path);
        element.selectElement(driver,actions,LocalSaleTestData.rcv_path);
        Thread.sleep(2000);

        dropDown.getProductRcvInd(driver,wait);
        Thread.sleep(2000);
        System.out.println("successfully click completed");
        WebElement qtyPath = driver.findElement(
                By.cssSelector(".reportTable tr:nth-child(3) td:nth-child(4)")
        );
        WebElement rcvProdPath = driver.findElement(
                By.cssSelector(".reportTable tr:nth-child(3) td:nth-child(2)")
        );

        String rcvProd = rcvProdPath.getText();

        int rcvProdQty = Integer.parseInt((qtyPath.getText()));
        Thread.sleep(2000);

        System.out.println("receive product qty: " + rcvProdQty);
        System.out.println("receive product: "+rcvProd);

        driver.switchTo().defaultContent();
        driver.navigate().back();


        //here is started the sale
        element.selectElement(driver,actions,LocalSaleTestData.localSales_path1);
        Thread.sleep(2000);

        element.selectElement(driver,actions,LocalSaleTestData.localSale_path2);
        Thread.sleep(2000);

        element.selectElement(driver,actions,LocalSaleTestData.localSales_path3);
        Thread.sleep(2000);

        int partyIndex = dropDown.lengthDropDown(driver,wait,1);
        int branchIndex = dropDown.lengthDropDown(driver,wait,2);
        dropDown.selectDropDown(driver,wait,1,LocalSaleTestData.dropdownIndex(partyIndex));
        dropDown.selectDropDown(driver,wait,2,LocalSaleTestData.dropdownIndex(branchIndex));
        dropDown.selectDropDownByName(driver,wait,3,rcvProd);

        element.writeElement(driver,wait,LocalSaleTestData.vehiclePath).sendKeys(LocalSaleTestData.vehicleInfo);
        String qty = Integer.toString(LocalSaleTestData.getRandomN(rcvProdQty));
        element.writeElement(driver,wait,LocalSaleTestData.qtyPath).sendKeys(qty);
        Thread.sleep(5000);
        element.clickButton(driver,wait,LocalSaleTestData.saveBtnPath);
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        String currentDate = LocalSaleTestData.date;

//        WebElement searchChallanDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//td[normalize-space()='"+currentDate+"']")
//        ));
//
//
//        if(searchChallanDate.isDisplayed())
//            System.out.println("local purchase record inserted successfully");
//        else System.out.println("Can not insert the record successfully");
        driver.quit();


        driver.quit();
    }
}
