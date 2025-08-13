package nexVatAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDown {

    public void selectDropDown(WebDriver driver,WebDriverWait wait, int dropdownInd, int optionInd){
        WebElement dropdown2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, '-control')])["+dropdownInd+"]")
        ));
        dropdown2.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, '-option')])["+optionInd+"]")
        ));
        option.click();
    }
}
