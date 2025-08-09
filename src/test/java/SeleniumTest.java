import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    public static WebDriver driver = null;
    @Test
    void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.get("https://www.youtube.com/");
        // Thread.sleep(2000);

        //load the daraz website.
        driver.navigate().to("https://www.daraz.com.bd/");
        //driver.manage().window().maximize();
        Thread.sleep(2000);

        //check the title of this site.
        String title = driver.getTitle();
        if(title.equalsIgnoreCase("daraz"))
            System.out.println("Title matches");
        else System.out.println(title);

        //click on the slider and go to the next page which is category page.
        WebElement slider = driver.findElement(By.cssSelector(".swiper-slide.swiper-slide-active a"));
        slider.click();
        Thread.sleep(2000);

        //Select the specific category with hover: E.g. category>groceries>breakfast>honey>new page open
        WebElement category = driver.findElement(By.cssSelector(".lzd-site-menu-nav-category-text"));
        Actions actions = new Actions(driver);
        actions.moveToElement(category).pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);
        WebElement item = driver.findElement    (By.xpath("//span[text()='Groceries']"));
        actions.moveToElement(item);
        actions.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        WebElement breakfast = driver.findElement(By.xpath("//a[@class='lzd-site-menu-root-item-link']//span[contains(text(),'Breakfast')]"));
        actions.moveToElement(breakfast);
//        actions.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        WebElement honey = driver.findElement(By.xpath("//a[@href='//www.daraz.com.bd/catalog?q=Honey&from=hp_categories&src=all_channel']//span[contains(text(),'Honey')]"));
        actions.moveToElement(honey).click().pause(Duration.ofSeconds(2)).perform();

        Thread.sleep(2000);

        System.out.println("navigated successfully");

        //to clear the search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='q']"));
//        searchBox.clear(); -->it does not work successfully.
        searchBox.click();
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);
        Thread.sleep(2000);

        //write the searching element in the search bar:
        searchBox.sendKeys("Mouse");

        driver.findElement(By.xpath("//a[normalize-space()='SEARCH']")).click();
        Thread.sleep(2000);

        System.out.println("successfully searched");

        driver.quit();
    }
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

    @Test
    void LoginPageDemoSite() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //login the page
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement lgnBtn = driver.findElement(By.xpath("//button[@id='submit']"));
        username.sendKeys("student");
        password.sendKeys("Password123");
        lgnBtn.click();
        Thread.sleep(3000);

        //Click the practice from menubar and click on the testException
        WebElement practice = driver.findElement(By.xpath("//a[normalize-space()='Practice']"));
        practice.click();
        Thread.sleep(2000);
        WebElement testException = driver.findElement(By.xpath("//a[normalize-space()='Test Exceptions']"));
        testException.click();
        Thread.sleep(2000);

        //After clicking the testException, here is clicked the edit button to edit row1 or add row
        WebElement editBtn = driver.findElement(By.xpath("//button[@id='edit_btn']"));
        editBtn.click();
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.xpath("//input[@value='Pizza']"));
        //After writing the value you should clear the input field.
        searchBox.click();
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);
        Thread.sleep(2000);
        searchBox.sendKeys("Chocolate");
        Thread.sleep(2000);
        WebElement saveBtn = driver.findElement(By.xpath("//button[@id='save_btn']"));
        saveBtn.click();
        Thread.sleep(2000);

        WebElement addBtn = driver.findElement(By.xpath("//button[@id='add_btn']"));
        addBtn.click();
        Thread.sleep(2000);
        WebElement inputR2 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='row2']//input[@class='input-field']"))
        );
        inputR2.sendKeys("Burger and Pasta");
        WebElement saveBtn2 = driver.findElement(By.xpath("//div[@id='row2']//button[@id='save_btn']"));
        saveBtn2.click();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void loginPageforRadditWebsite() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
      driver.get("https://www.reddit.com/?feed=home");
//        https://practicetestautomation.com/practice-test-login/
        //driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(2000);

//        //For Raddit website -> automated code can not login it.
//        // to check the iframe list
//        List<WebElement> iframe = Collections.singletonList(driver.findElement(By.tagName("iframe")));
//        System.out.println(iframe.size());
//        for (WebElement frame:iframe)
//            System.out.println("iframe src : " + frame.getAttribute("src"));
//-----------------------------------------------------------------
        WebElement iframe = driver.findElement(By.cssSelector("iframe[src*='login']"));
        driver.switchTo().frame(iframe);
        WebElement clickLogin = driver.findElement(By.xpath("//a[@id='login-button']//span[@class='flex items-center gap-xs'][normalize-space()='Log In']"));
        clickLogin.click();
        Thread.sleep(1000);
        //WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        //sometimes xpath can not be accessible for specific webelement.
        WebElement email = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//faceplate-tracker[@data-faceplate-tracking-context='{\"popup\":{\"button_text\":\"login\"}}']//button[@type='button']"));
        email.sendKeys("****");
        Thread.sleep(2000);
        password.sendKeys("****");
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(3000);
// --------------------------------------------
        driver.quit();

    }
}