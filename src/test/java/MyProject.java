import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyProject {
    public static WebDriver driver = null;
    @Test
    void LoginPageforTestAutomationSite() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://nexvat.com/login");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        email.sendKeys("*******");
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
                By.xpath("(//div[contains(@class, 'control')])[3]")
        ));
        dropdown2.click();
        WebElement houseOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, '-option')])[4]")
        ));
        houseOption.click();


        //-----------------------getText
//        actions.pause(Duration.ofSeconds(2)).perform();
//        WebElement selectedValue = driver.findElement(By.xpath("//div[contains(@class,'css-1uccc91-singleValue')]"));
//        System.out.println("Selected: " + selectedValue.getText());
        Thread.sleep(2000);
        driver.quit();
    }
}
