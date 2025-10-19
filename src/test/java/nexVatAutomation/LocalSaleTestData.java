package nexVatAutomation;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class LocalSaleTestData {
    public static String inventory_path = "//span[@title='Inventories']";
    public static String rcv_path = "//span[normalize-space()='Products Receive']";
    public static String localSales_path1 = "(//div[@class='menu-text'])[15]";
    public static String localSale_path2 = "//span[normalize-space()='Local Sales']";
    public static String localSales_path3 = "//button[normalize-space()='New Local Sales Voucher']";
    public static String product_path = "//div[contains(@class, '-container')]";
    public static String vehiclePath = "//input[@name='vehicle_info']";
    public static String qtyPath = "//input[@name='details.0.qty']";
    public static String saveBtnPath = "//button[normalize-space()='Save']";
    public static String actionPath = "//div[@class='content-wrapper']";
    public static String reasonPath = "//input[@name='details.0.remarks']";

    public static Random random = new Random();
    public static int randIntVal = random.nextInt(2000);

    public static String vehicleInfo = "Dhaka-Metro-"+randIntVal;
    static int partyIndex = random.nextInt(10)+1;

    public static String reason = "Local Sale";
    static int index;
    static int productIndex = random.nextInt(10)+1;

    public static int getRandomN(int bound) {
        int randomN = 0;
        if(bound>=2){
            randomN = random.nextInt(bound-1)+1;}
        else if (bound==1) randomN = 1;
        else randomN = 0;

        return randomN%10;
    }

    public static int dropdownIndex(int size){
        index = random.nextInt(size)+1;
        return index;
    }

    static LocalDate today = LocalDate.now();

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static String date = today.format(formatter);

    @Test
    void TestAutomation(){


    }
}
