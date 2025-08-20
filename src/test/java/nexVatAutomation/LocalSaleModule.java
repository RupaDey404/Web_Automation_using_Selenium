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
        
        //here
        driver.quit();
    }
}
