package nexVatAutomation;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Random;

public class LocalSaleTestData {
    public static String localSales_path1 = "(//div[@class='menu-text'])[14]";
    public static String localSale_path2 = "//span[normalize-space()='Local Sales']";
    public static String localSales_path3 = "//button[normalize-space()='New Local Sales Voucher']";

    public static String vehiclePath = "//input[@name='vehicle_info']";
    public static String qtyPath = "//input[@name='details.0.qty']";

    public static Random random = new Random();
    public static int randIntVal = random.nextInt(2000);

    public static String vehicleInfo = "Dhaka-Metro-"+randIntVal;
    static int partyIndex = random.nextInt(10)+1;


    static int branchIndex = random.nextInt(3)+1 ;
    static int productIndex = random.nextInt(10)+1;
    static int bound =10;

    static int randomN = random.nextInt(500);

    static  int qty = randomN + 1;

    public static int getRandomN() {
        if(randomN%5==0 || randomN<=10) qty = randomN;
        else qty = randomN - randomN%5;

        return qty;
    }

    @Test
    void TestAutomation(){


    }
}
