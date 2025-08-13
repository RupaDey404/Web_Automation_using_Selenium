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

public class MyProjct_NexVat {
    public static WebDriver driver = null;

    //private Object nexVatAutomation.ImportTestData;

    @Test
    void ImportModuleAutomation() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://nexvat.com/login");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        email.sendKeys("super@nextpagetl.com");
        Thread.sleep(2000);
        password.sendKeys("123123");
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

//-----------------------------party/supplier select from import =>reactbase code

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[class*='control']") //which div contains "control"
        ));
        dropdown.click();

        int partyNum = ImportTestData.partyIndex;
        WebElement supplierOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, '-option')])["+partyNum+"]")
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
                By.xpath("(//div[contains(@class, '-option')])["+ImportTestData.houseIdex+"]")
        ));
        houseOption.click();
        //---------------------------------------
        //Country of origin
        WebElement dropdown3 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, 'control')])[3]")
        ));
        dropdown3.click();
        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, '-option')])["+ImportTestData.countryIndex+"]")
        ));
        country.click();

        WebElement vehicleInfo = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='vehicle_info']")
        ));
        vehicleInfo.click();
        vehicleInfo.sendKeys(ImportTestData.vehicleInfo);
        Thread.sleep(2000);

        WebElement BOE = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='challan_no']")
        ));
//        BOE.sendKeys("121000098");
        String challanNo = Integer.toString(ImportTestData.ch_num);
        BOE.sendKeys(challanNo);
        Thread.sleep(2000);

//        WebElement challanTime = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//input[@name='challan_time']")
//        ));
//        challanTime.click();
//        Thread.sleep(2000);

//        WebElement selectTime = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("(//div[contains(@class, 'option')])[1]")
//        ));
//        selectTime.click();
//        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
//        challanTime.clear();
//        challanTime.sendKeys(currentTime);
//        Thread.sleep(2000);  //Time will be automatically updated

        WebElement lcNoField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='lc_no']")
        ));
        String lc_no = Integer.toString(ImportTestData.lcNo);
        lcNoField.sendKeys(lc_no); //sendKeys take string value
        Thread.sleep(2000);

        WebElement dropdown4 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, 'control')])[4]")
        ));
        dropdown4.click();
        WebElement productImp = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, 'option')])["+ImportTestData.productIndex+"]")
        ));

        productImp.click();

        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Save']")
        ));
        saveBtn.click();
        Thread.sleep(2000);

        WebElement qtyF = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='details.0.qty']")
        ));
        String qty = Integer.toString(ImportTestData.getRandomN());
        qtyF.sendKeys(qty);
        Thread.sleep(2000);

        WebElement accessibleVal = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='details.0.av']")
        ));
        String av = Integer.toString(ImportTestData.totalP);
        accessibleVal.sendKeys(av);
        saveBtn.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.urlContains("https://nexvat.com/purchases"));
        WebElement searchImportList = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//input[@placeholder='Challan No, Party, Challan Date ']")
        ));
        searchImportList.click();

        String currentDate = ImportTestData.date ;
        searchImportList.sendKeys(currentDate);
        Thread.sleep(5000);


        WebElement searchChallanDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[normalize-space()='"+currentDate+"']")
        ));

        if(searchChallanDate.isDisplayed())
            System.out.println("record inserted successfully");
        else System.out.println("Can not insert the record successfully");

        driver.quit();
    }

    @Test
    void LocalPurchaseAutomation() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://nexvat.com/login");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        email.sendKeys("super@nextpagetl.com");
        Thread.sleep(2000);
        password.sendKeys("123123");
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        WebElement purchase = driver.findElement(By.xpath("//span[@title='Purchase']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(purchase).pause(Duration.ofSeconds(2)).click();
//        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        driver.quit();
    }

    @Test
    void login() throws InterruptedException{

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        WebDriver driver = LoginPage.driver;
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
//        WebElement purchase = driver.findElement(By.xpath("//span[@title='Purchase']"));
//        actions.moveToElement(purchase).pause(Duration.ofSeconds(2)).click();
//        actions.pause(Duration.ofSeconds(2)).perform();
//        String path = "//span[@title='Purchase']";
        selectWebElement element = new selectWebElement();
        element.selectElement(driver,actions,ImportTestData.path1);
        Thread.sleep(2000);
//        WebElement imports = driver.findElement(By.xpath("//span[normalize-space()='Imports']"));
//
//        actions.moveToElement(imports).pause(Duration.ofSeconds(2)).click();
//        actions.pause(Duration.ofSeconds(2)).perform();
        element.selectElement(driver,actions,ImportTestData.path2);
        Thread.sleep(2000);
//        WebElement newImportVoucher = driver.findElement(By.xpath("//button[normalize-space()='New Import Voucher']"));
//        actions.moveToElement(newImportVoucher).pause(Duration.ofSeconds(2)).click();
//        actions.pause(Duration.ofSeconds(2)).perform();
        element.selectElement(driver,actions,ImportTestData.path3);
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        DropDown dropdown = new DropDown();

        int partyNum = ImportTestData.partyIndex;
        dropdown.selectDropDown(driver, wait,1,partyNum);
        dropdown.selectDropDown(driver,wait,2,ImportTestData.houseIdex);
        dropdown.selectDropDown(driver,wait,3,ImportTestData.countryIndex);
        dropdown.selectDropDown(driver,wait,4,ImportTestData.productIndex);
    }

}
