package nexVatAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

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
    public int lengthDropDown(WebDriver  driver, WebDriverWait wait, int dropdownInd){
        List<WebElement> dropdownSize = driver.findElements(
                By.xpath("(//div[contains(@class, '-control')])["+dropdownInd+"]"));


        return dropdownSize.size();
    }
    public String getProductRcvInd(WebDriver driver, WebDriverWait wait, String name){
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
        Random random = new Random();
        int index = random.nextInt(rows.size())+1;
        List<WebElement> names = driver.findElements(
                By.xpath("//table[@class='table']/tbody/tr/td[2]"));

        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class, '-control')]"));

        return names.get(index).getText();
    }
}
