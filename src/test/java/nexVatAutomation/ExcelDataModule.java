package nexVatAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataModule {

    @DataProvider(name = "csvData")
    public Object[][] dataRead() throws Exception {
        String csvData = "C://Users//Rupa//Learning_Automation//SeleniumProject//inputData.csv";
        CSVReader reader = new CSVReader(new FileReader(csvData));
        List<String[]> records = reader.readAll();
        reader.close();

        // skip header row
        records.removeFirst();

        // convert to Object[][]
        Object[][] data = new Object[records.size()][records.get(0).length];
        for (int i = 0; i < records.size(); i++) {
            data[i] = records.get(i);
        }
        return data;
    }

    @Test(dataProvider = "csvData")
    public void testForm(String supplier, String lc , String billNo, String product, String qty, String value, String vehicle, String reason) {
        System.out.println("Supplier: " + supplier);
        System.out.println("Bill No: " + billNo);
        System.out.println("LC No: "+lc);
        System.out.println("Vehicle: "+vehicle);
        System.out.println("Product: " + product);
        System.out.println("Qty: " + qty);
        System.out.println("Value: " + value);
        System.out.println("reason: "+reason);

    }

    @Test (dataProvider = "csvData")
    public void csvDataImport(String supplier, String lc , String billNo, String product, String qty, String value, String vehicle, String reason) throws InterruptedException{
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        element.writeElement(driver,wait,ImportTestData.lc_path).sendKeys(lc);
        element.writeElement(driver,wait,ImportTestData.vehicle_path).sendKeys(vehicle);
//        element.writeElement(driver,wait,ImportTestData.house_path).sendKeys(ImportTestData.houseIdex);
        element.writeElement(driver,wait,ImportTestData.qty_path).sendKeys(qty);
        element.writeElement(driver,wait,ImportTestData.av_path).sendKeys(value);
        element.writeElement(driver,wait,ImportTestData.reason_path).sendKeys(reason);
        Thread.sleep(2000);

    }
}
