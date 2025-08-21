package nexVatAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImportModule {

    @Test
    void ImportModuleAutomation() throws InterruptedException{
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        WebDriver driver = LoginPage.driver;
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        selectWebElement element = new selectWebElement();
        element.selectElement(driver,actions,ImportTestData.path1);
        Thread.sleep(2000);

        element.selectElement(driver,actions,ImportTestData.path2);
        Thread.sleep(2000);

        element.selectElement(driver,actions,ImportTestData.path3);
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        DropDown dropdown = new DropDown();

        int partyIndex = dropdown.lengthDropDown(driver, wait, 1);
        int houseIndex = dropdown.lengthDropDown(driver, wait, 2);
        int countryIndex = dropdown.lengthDropDown(driver, wait, 3);
        int productIndex = dropdown.lengthDropDown(driver, wait, 4);

        dropdown.selectDropDown(driver, wait,1,ImportTestData.dropdownIndex(partyIndex));
        dropdown.selectDropDown(driver,wait,2,ImportTestData.dropdownIndex(houseIndex));
        dropdown.selectDropDown(driver,wait,3,ImportTestData.dropdownIndex(countryIndex));
        dropdown.selectDropDown(driver,wait,4,ImportTestData.dropdownIndex(productIndex));

        element.writeElement(driver,wait,ImportTestData.vehicle_path).sendKeys(ImportTestData.vehicleInfo);

        Thread.sleep(2000);

        String challanNo = Integer.toString(ImportTestData.ch_num);
        element.writeElement(driver,wait,ImportTestData.challan_path).sendKeys(challanNo);

        Thread.sleep(2000);

        String lc_no = Integer.toString(ImportTestData.lcNo);
        element.writeElement(driver,wait,ImportTestData.lc_path).sendKeys(lc_no);
        Thread.sleep(2000);

        element.clickButton(driver,wait,ImportTestData.save_btn_path);
        Thread.sleep(2000);

        String qty = Integer.toString(ImportTestData.getRandomN());
        element.writeElement(driver,wait,ImportTestData.qty_path).sendKeys(qty);
        Thread.sleep(2000);

        String av = Integer.toString(ImportTestData.totalP);
        element.writeElement(driver,wait,ImportTestData.av_path).sendKeys(av);

        element.clickButton(driver,wait,ImportTestData.save_btn_path);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.urlContains("https://nexvat.com/purchases"));

        String currentDate = ImportTestData.date ;
        element.writeElement(driver,wait,ImportTestData.search_path).sendKeys(currentDate);
        Thread.sleep(5000);


        WebElement searchChallanDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[normalize-space()='"+currentDate+"']")
        ));

        if(searchChallanDate.isDisplayed())
            System.out.println("record inserted successfully");
        else System.out.println("Can not insert the record successfully");

        driver.quit();
    }



}
