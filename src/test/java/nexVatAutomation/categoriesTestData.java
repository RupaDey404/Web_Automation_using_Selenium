package nexVatAutomation;

import java.util.Random;

public class categoriesTestData {
    public static String path1 = "//span[@title='Settings']";
    public static String path2 = "//span[normalize-space()='Categories']";
    public static String path3 = "//button[normalize-space()='New Category']";

    public static String namePath = "//input[@name='name']";
    public static String codePath = "//input[@name='code']";
    public String typePath = "//div[@class='select__input']";
    public static String btnPath = "//button[normalize-space()='Save']";

    static Random random = new Random();
    public static String nameC = "Test_Category" + random.nextInt(100) ;
    public static String code = "RM" + random.nextInt(100);

    public static int[] list = {2,3};
    public static int dropdownInd = random.nextInt(list.length);
}
