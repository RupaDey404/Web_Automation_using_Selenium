package nexVatAutomation;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class LocalPurchaseTestData {

    public static final String path1 = "//span[@title='Purchase']";
    public static  final String path2 = "//span[normalize-space()='Local Purchases']";
    public static final String path3 = "//button[normalize-space()='New Local Purchase']";

    public static final String vehicle_path = "//input[@name='vehicle_info']";
//    public static final String contact_path = "//input[@name='contact_no']";
//    public static final String address_path = "//input[@name='address']";
//    public static final String bin_path = "//input[@name='bin_or_nid']" ;
    public static final String challan_path = "//input[@name='challan_no']";
    public static final String save_btn_path = "//button[normalize-space()='Save']";
    public static final String qty_path = "//input[@name='details.0.qty']";
    public static final String unitP_path ="//input[@name='details.0.unit_price']";
    public static final String search_path = "//input[@placeholder='Party, Challan No, Date']";
    public static final String reason_path = "//input[@name='details.0.remarks']";

    static Random random = new Random();
    static int ch_num = random.nextInt(9999999);
    public static String challanNo = "ch-" + System.currentTimeMillis()%100000;
//    public static final String contact = "01" + System.currentTimeMillis()%1000000000;
    static int partyIndex = random.nextInt(10)+1;

    static int vehicleNo = random.nextInt(2000);
    public static final String vehicleInfo = "DHAKA-Metro-A" + vehicleNo;

    public static final String reason = "Local Purchase";
//    public static final String address = "Uttara,Dhaka";
    static int index;
    static int bin_part1 = 100000000 + random.nextInt(900000000);
    static int bin_part2 = random.nextInt(10000);
//    public static final String binNo = bin_part1 + "-" + bin_part2;

    //product length niye kaj korte hobe bound ta and same for any bound
    static int productIndex = random.nextInt(10)+1;

    static int randomN = random.nextInt(500);

    static  int qty = randomN + 1;

    public static int getRandomN() {
        if(randomN%5==0 || randomN<=10) qty = randomN;
        else qty = randomN - randomN%5;

        return qty;
    }

    public static int dropdownIndex(int size){
        index = random.nextInt(size)+1;
        return index;
    }

    static int unitP = randomN;

    //get current date
    static LocalDate today = LocalDate.now();

    //time formatter =>
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static String date = today.format(formatter);

    @Test
    void testAutomation(){
        //it shows unique time stamp after every Milli seconds. it contains 13 digits more
        System.out.println(System.currentTimeMillis());
        System.out.println(partyIndex);
        System.out.println(productIndex);
//        System.out.println(contact);
        int qty = getRandomN();
        int totalPrice = qty*unitP;
        System.out.println(qty);
        System.out.println(totalPrice);

    }
}
