package nexVatAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LocalSaleModule {

    @Test
    void LocalSaleModuleAutomation() throws InterruptedException{
        LoginPage loginPage = new LoginPage();
        WebDriver driver = null;
        loginPage.login();

        driver = LoginPage.driver;
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        selectWebElement element = new selectWebElement();
        DropDown dropDown = new DropDown();

        element.selectElement(driver,actions,LocalSaleTestData.inventory_path);
        element.selectElement(driver,actions,LocalSaleTestData.rcv_path);
        Thread.sleep(2000);
        String productName = dropDown.getProductRcvInd(driver,wait,2);
        System.out.println("ProductName: "+productName);
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.navigate().back();

        element.selectElement(driver,actions,LocalSaleTestData.localSales_path1);
        Thread.sleep(2000);

        element.selectElement(driver,actions,LocalSaleTestData.localSale_path2);
        Thread.sleep(2000);

        element.selectElement(driver,actions,LocalSaleTestData.localSales_path3);
        Thread.sleep(2000);
        
        //here is started form submit code for this field: party, vehicle info, branch, qty

        int partyIndex = dropDown.lengthDropDown(driver,wait,1);
        int branchIndex = dropDown.lengthDropDown(driver,wait,2);
//        int productIndex = dropDown.getProductRcvInd(driver,wait,3);

        dropDown.selectDropDown(driver,wait,1,LocalSaleTestData.dropdownIndex(partyIndex));
        dropDown.selectDropDown(driver,wait,2,LocalSaleTestData.dropdownIndex(branchIndex));
        dropDown.selectDropDown(driver,wait,3,);
        Thread.sleep(2000);

        List<WebElement> options = driver.findElements(
                By.xpath("//ul[@class='dropdown-menu']/li")
        );


        element.writeElement(driver,wait,LocalSaleTestData.vehiclePath).sendKeys(LocalSaleTestData.vehicleInfo);
        String qty = Integer.toString(LocalSaleTestData.getRandomN());
        element.writeElement(driver,wait,LocalSaleTestData.qtyPath).sendKeys(qty);
        Thread.sleep(2000);
        driver.quit();
    }
}
