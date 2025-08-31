package nexVatAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    public void getProductRcvInd(WebDriver driver, WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//table[@class='table']/tbody/tr")));
        List<WebElement> rows = driver.findElements((By.xpath("//table[@class='table']/tbody/tr")));
        Random random = new Random();

        List<WebElement> names = driver.findElements(
                By.xpath("//table[@class='table']/tbody/tr/td[6]"));
        int index = random.nextInt(rows.size());
        WebElement randomRow = rows.get(index);
        WebElement viewBtn = randomRow.findElement(
                By.xpath(".//td[last()]/div[@class='data-list-action']/a")
        );

        viewBtn.click();
        WebElement viewForm =wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='card']")
        ));
        viewForm.click();


//        if(names.isEmpty()){ throw new RuntimeException("No product is available");}
//
//
//        return names.get(index).getText();
//        return names.size();
    }

    public void selectDropDownByName(WebDriver driver, WebDriverWait wait, int dropdownIndex, String name) {
        // Open dropdown
        WebElement dropdown = driver.findElement(
                By.xpath("(//div[contains(@class, '-control')])[" + dropdownIndex + "]"));
        dropdown.click();

        // Adjust locator (ignore index if menu is detached)
        By optionsLocator = By.xpath("//div[contains(@class, '-menu')]//div[contains(@class,'-option')]");

        // Longer wait to allow dynamic loading
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        longWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(optionsLocator));
        longWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionsLocator));

        // Fetch options
        List<WebElement> options = driver.findElements(optionsLocator);
        boolean found = false;
        for (WebElement option : options) {
            String text = option.getText().trim();
            System.out.println("Option: " + text);
            String rcvName = name.replaceFirst("^\\d+-","");
            if (text.toLowerCase().contains(rcvName.toLowerCase())) {
                option.click();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("No option contains: " + name);
        }
    }


}
