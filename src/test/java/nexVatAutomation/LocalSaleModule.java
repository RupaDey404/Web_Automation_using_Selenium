package nexVatAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

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
        element.selectElement(driver,actions,LocalSaleTestData.localSales_path1);
        Thread.sleep(2000);

        element.selectElement(driver,actions,LocalSaleTestData.localSale_path2);
        Thread.sleep(2000);

        element.selectElement(driver,actions,LocalSaleTestData.localSales_path3);
        Thread.sleep(2000);
        
        //here is started form submit code for this field: party, vehicle info, branch, qty
        DropDown dropDown = new DropDown();
        int partyIndex = dropDown.lengthDropDown(driver,wait,1);
        int branchIndex = dropDown.lengthDropDown(driver,wait,2);
        int productIndex = dropDown.lengthDropDown(driver,wait,3);

        dropDown.selectDropDown(driver,wait,1,LocalSaleTestData.dropdownIndex(partyIndex));
        dropDown.selectDropDown(driver,wait,2,LocalSaleTestData.dropdownIndex(branchIndex));
        dropDown.selectDropDown(driver,wait,3,LocalSaleTestData.dropdownIndex(productIndex));
        Thread.sleep(2000);

        element.writeElement(driver,wait,LocalSaleTestData.vehiclePath).sendKeys(LocalSaleTestData.vehicleInfo);
        String qty = Integer.toString(LocalSaleTestData.getRandomN());
        element.writeElement(driver,wait,LocalSaleTestData.qtyPath).sendKeys(qty);
        Thread.sleep(2000);
        driver.quit();
    }
}
