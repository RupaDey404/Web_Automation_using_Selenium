package nexVatAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class selectWebElement {

    public void selectElement(WebDriver driver, Actions actions, String path){
        WebElement modulePath = driver.findElement(By.xpath(path));
        actions.moveToElement(modulePath).pause(Duration.ofSeconds(2)).click();
        actions.pause(Duration.ofSeconds(2)).perform();

    }

    public WebElement writeElement(WebDriver driver, WebDriverWait wait, String path){
        WebElement pathInfo = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(path)
        ));
        pathInfo.click();
        return pathInfo;
    }

    public void clickButton(WebDriver driver, WebDriverWait wait, String path){
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(path)
        ));
        btn.click();

    }

}
