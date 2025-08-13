package nexVatAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class selectWebElement {

    public void selectElement(WebDriver driver, Actions actions, String path){
        org.openqa.selenium.WebElement newImportVoucher = driver.findElement(By.xpath(path));
        actions.moveToElement(newImportVoucher).pause(Duration.ofSeconds(2)).click();
        actions.pause(Duration.ofSeconds(2)).perform();

    }
}
