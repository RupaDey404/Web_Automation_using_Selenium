import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyProject {
    public static WebDriver driver = null;
    @Test
    void nexVatAutomationSite() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://nexvat.com/login");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        email.sendKeys("*****");
        Thread.sleep(2000);
        password.sendKeys("***");
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        WebElement purchase = driver.findElement(By.xpath("//span[@title='Purchase']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(purchase).pause(Duration.ofSeconds(2)).click();
//        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        WebElement imports = driver.findElement(By.xpath("//span[normalize-space()='Imports']"));
        actions.moveToElement(imports).pause(Duration.ofSeconds(2)).click();;
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);
        WebElement newImportVoucher = driver.findElement(By.xpath("//button[normalize-space()='New Import Voucher']"));
        actions.moveToElement(newImportVoucher).pause(Duration.ofSeconds(2)).click();
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);
//        WebElement supplier = driver.findElement(By.xpath("//body/div[@id='root']/div[@class='wrapper vertical-layout theme-primary navbar-floating']/div[@class='app-content content']/div[@class='content-wrapper']/div[@class='card']/div[@class='card-body']/div[@class='table-responsive']/form[@action='#']/div[@class='row']/div[@class='col']/table[@class='reportTable']/thead/tr[1]/td[1]/div[1]/div[1]/div[1]"));
//        actions.moveToElement(supplier).pause(Duration.ofSeconds(2)).click();
//        actions.pause(Duration.ofSeconds(2)).perform();
//        Thread.sleep(2000);
//-----------------------------party/supplier select from import =>reactbase code
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[class*='control']") //which div contains "control"
        ));
        dropdown.click();


        WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, '-option')])[3]")
        ));
        supplierOption.click();
        Thread.sleep(2000);
        //-------------------------------------------
        //custom House method dropdown selection
        WebElement dropdown2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, 'control')])[2]")
        ));
        dropdown2.click();
        WebElement houseOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, '-option')])[4]")
        ));
        houseOption.click();
        //---------------------------------------
        //Country of origin
        WebElement dropdown3 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, 'control')])[3]")
        ));
        dropdown3.click();
        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, '-option')])[13]")
        ));
        country.click();

        WebElement vehicleInfo = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='vehicle_info']")
        ));
        vehicleInfo.click();
        vehicleInfo.sendKeys("Dhaka-Metro-A-1206");
        Thread.sleep(2000);

        WebElement BOE = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='challan_no']")
        ));
        BOE.sendKeys("121000098");
        Thread.sleep(2000);

        WebElement challanTime = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='challan_time']")
        ));
        challanTime.click();
        Thread.sleep(2000);

//        WebElement selectTime = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("(//div[contains(@class, 'option')])[1]")
//        ));
//        selectTime.click();
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        challanTime.clear();
        challanTime.sendKeys(currentTime);
        Thread.sleep(2000);

        WebElement lcNo = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='lc_no']")
        ));
        lcNo.sendKeys("2480000001");
        Thread.sleep(2000);

        WebElement dropdown4 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, 'control')])[4]")
        ));
        dropdown4.click();
        WebElement productImp = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, 'option')])[16]")
        ));
        productImp.click();

        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Save']")
        ));
        saveBtn.click();
        Thread.sleep(2000);

        WebElement qty = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='details.0.qty']")
        ));
        qty.sendKeys("200");
        Thread.sleep(2000);

        WebElement accessibleVal = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='details.0.av']")
        ));
        accessibleVal.sendKeys("1250000");
        saveBtn.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.urlContains("https://nexvat.com/purchases"));
        WebElement searchImportList = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//input[@placeholder='Challan No, Party, Challan Date ']")
        ));
        searchImportList.click();
        searchImportList.sendKeys("2025-08-09");
        Thread.sleep(2000);

        WebElement searchChallanDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[normalize-space()='2025-08-09']")
        ));

        if(searchChallanDate.isDisplayed())
            System.out.println("record inserted successfully");
        else System.out.println("Can not insert the record successfully");

        driver.quit();
    }
}
