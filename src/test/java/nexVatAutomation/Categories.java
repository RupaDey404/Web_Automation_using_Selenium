package nexVatAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static nexVatAutomation.categoriesTestData.dropdownInd;

public class Categories {
    @Test
    public void createCategories() throws InterruptedException{
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        WebDriver driver = null;
        driver = LoginPage.driver;
        Thread.sleep(2000);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions actions = new Actions(driver);

        selectWebElement element = new selectWebElement();
        element.selectElement(driver,actions,categoriesTestData.path1);
        element.selectElement(driver,actions,categoriesTestData.path2);
        element.selectElement(driver,actions,categoriesTestData.path3);
        Thread.sleep(1000);

        element.writeElement(driver,wait,categoriesTestData.namePath).sendKeys(categoriesTestData.nameC);
        element.writeElement(driver,wait,categoriesTestData.codePath).sendKeys(categoriesTestData.code);

        DropDown dropDown = new DropDown();
        dropDown.selectDropDown(driver,wait,1,categoriesTestData.list[dropdownInd]);
        Thread.sleep(2000);

        element.clickButton(driver,wait,categoriesTestData.btnPath);
        Thread.sleep(2000);

        System.out.println("categories inserted successfully");
        driver.quit();
    }
}
