package nexVatAutomation;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ImportTestData {

    public static final String path1 = "//span[@title='Purchase']";
    public static  final String path2 = "//span[normalize-space()='Imports']";
    public static final String path3 = "//button[normalize-space()='New Import Voucher']";

    public static final String vehicle_path = "//input[@name='vehicle_info']";
    public static final String lc_path = "//input[@name='lc_no']" ;
    public static final String challan_path = "//input[@name='challan_no']";
    public static final String save_btn_path = "//button[normalize-space()='Save']";
    public static final String qty_path = "//input[@name='details.0.qty']";
    public static final String av_path ="//input[@name='details.0.av']";
    public static final String search_path = "//input[@placeholder='Challan No, Party, Challan Date ']";
    public static final String reason_path = "//input[@name='details.0.remarks']";
    public static final String house_path = "//input[@name='custom_house_code']";

    static Random random = new Random();
    static int ch_num = random.nextInt(9999999);
    public static final String boe = "100000" + System.currentTimeMillis()%10000;

    public static final String reason = "Imported";
    static int partyIndex = random.nextInt(10)+1;
    //public static final String partyInd = Integer.toString(partyIndex);

    static int vehicleNo = random.nextInt(2000);
    public static final String vehicleInfo = "DHAKA-Metro-A" + vehicleNo;

    static int countryIndex = random.nextInt(50)+1;

    static int houseIdex = random.nextInt(10)+1;

    static int productIndex = random.nextInt(12)+1;
    static int index;

    static int lcNo = random.nextInt(1000000);

    static int randomN = random.nextInt(500)+ 1;

    static  int qty;

    public static int getRandomN() {
        if(randomN%5==0 || randomN<=10) qty = randomN;
        else qty = randomN - randomN%5;

        return qty;
    }

    public static int dropdownIndex(int size){
        index = random.nextInt(size)+1;
        return index;
    }

    static int totalP = getRandomN()*randomN;

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
        System.out.println(countryIndex);
        int qty = getRandomN();
        int totalPrice = qty*totalP;
        System.out.println(qty);
        System.out.println(totalPrice);

    }
}
