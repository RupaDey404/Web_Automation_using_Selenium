package nexVatAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class StockReportModule {
    @Test
    public void StockReport() throws InterruptedException{
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        WebDriver driver = null;
        driver = LoginPage.driver;
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
    }
}
