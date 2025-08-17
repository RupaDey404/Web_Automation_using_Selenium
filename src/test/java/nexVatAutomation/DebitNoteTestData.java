package nexVatAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Random;

public class DebitNoteTestData {

    public static final String path1 = "//span[@title='Purchase']";
    public static  final String path2 = "//span[normalize-space()='Debit Note']";
    public static final String path3 = "//button[normalize-space()='New Debit Note']";

    public static final String challan_path = "//input[@placeholder='Press Enter or Focus Out']";
    public static final String debitNoteNo_path = "//input[@name='debit_note_no']" ;
    public static final String qty_path = "//input[@name='details.0.qty']";
    public static final String rtnQty_path = "//input[@name='details.0.return_qty']";
    public static final String reason_path = "//input[@name='details.0.remarks']";
    public static final String save_path = "//button[normalize-space()='Save']";

    static Random random = new Random();
    static int debitNoteNo = random.nextInt(9999999);
    static int qty ;
    static int  rtnQty = random.nextInt(qty%10) ;
    public static final String[] items = {"expire date","Damage material", "Label misprint",
                                        "Damaged packaging", "Customer cancellation", "Wrong batch delivered",
                                        "Seal broken", "Excess moisture detected"};

    static int reasonIndex = random.nextInt(items.length);
    public static final String reason = items[reasonIndex];


    public static int getRtnQty() {
        if( qty>=1 && qty<=10)
        {
            if(rtnQty==0) {
                rtnQty = rtnQty+1;
            }
            else if (rtnQty>1)
                rtnQty = rtnQty-1;

        }
        return rtnQty;
    }
    @Test
    void testAutomation(){
        System.out.println(reason);
        System.out.println("return qty: "+rtnQty);
        System.out.println(getRtnQty());
    }
}
