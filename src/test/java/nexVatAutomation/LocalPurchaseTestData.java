package nexVatAutomation;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class LocalPurchaseTestData {
    static Random random = new Random();
    static int ch_num = random.nextInt(9999999);
    public static final String challanNo = "ch-" + System.currentTimeMillis()%100000;

    static int partyIndex = random.nextInt(10);
    //public static final String partyInd = Integer.toString(partyIndex);

    static int vehicleNo = random.nextInt(2000);
    public static final String vehicleInfo = "DHAKA-Metro-A" + vehicleNo;

    public static final String address = "Uttara,Dhaka";

    static int bin_part1 = 100000000 + random.nextInt(900000000);
    static int bin_part2 = random.nextInt(10000);
    public static final String binNo = bin_part1 + "-" + bin_part2;

    static int productIndex = random.nextInt(15);

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
