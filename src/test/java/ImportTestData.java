import org.testng.annotations.Test;

import java.util.Random;

public class ImportTestData {
    static Random random = new Random();
    static int ch_num = random.nextInt(999);
    public static final String challanNo = "ch-" + ch_num; //System.currentTimeMillis()%100000;

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
