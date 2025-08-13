package nexVatAutomation;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ImportTestData {

    public static final String path1 = "//span[@title='Purchase']";
    public static  final String path2 = "//span[normalize-space()='Imports']";
    public static final String path3 = "//button[normalize-space()='New Import Voucher']";


    static Random random = new Random();
    static int ch_num = random.nextInt(9999999);
//    public static final String challanNo = "ch-" + ch_num; //System.currentTimeMillis()%100000;

    static int partyIndex = random.nextInt(10);
    //public static final String partyInd = Integer.toString(partyIndex);

    static int vehicleNo = random.nextInt(2000);
    public static final String vehicleInfo = "DHAKA-Metro-A" + vehicleNo;

    static int countryIndex = random.nextInt(50);

    static int houseIdex = random.nextInt(10);

    static int productIndex = random.nextInt(15);

    static int lcNo = random.nextInt(1000000);

    static int randomN = random.nextInt(500)+ 1;

    static  int qty;

    public static int getRandomN() {
        if(randomN%5==0 || randomN<=10) qty = randomN;
        else qty = randomN - randomN%5;

        return qty;
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

        int qty = getRandomN();
        int totalPrice = qty*totalP;
        System.out.println(qty);
        System.out.println(totalPrice);

    }
}
