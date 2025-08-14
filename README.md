# Web Automation using Selenium
Selenium is an open-source tool for automating web browsers. It simulates user actions, such as clicks, typing, and navigation, for testing or repetitive tasks. Selenium supports multiple languages, but I have designed my script using Java. Here is the documented demo site for testing automatically. I have even designed the code script for my company project. Here is some code script for Daraz website.

### Steps of Selenium SetUp: 
 1. Download JDK, Apache Maven, IntelliJ IDEA, Chromedriver 
 2. Create Java Project 
 3. Add selenium dependencies in pom.xml

```
	<dependency>
            		<groupId>org.seleniumhq.selenium</groupId>
            		<artifactId>selenium-java</artifactId>
           		 <version>4.34.0</version>
	</dependency>
```
 4. Run and reload the Maven project.

### For the Daraz website: 
1. Here is how I navigated to this software from another software. The opened window can be maximized, minimized, full-screen, etc.

```
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.get("https://www.youtube.com/");
        // Thread.sleep(2000);

        //Load the Daraz website.
        driver.navigate().to("https://www.daraz.com.bd/");
        //driver.manage().window().maximize();
        Thread.sleep(2000);
```

2. Here is how to get the title, click on the daraz home page slider and go to the next page.
  
``` 
       String title = driver.getTitle();
        if(title.equalsIgnoreCase("daraz"))
            System.out.println("Title matches");
        else System.out.println(title);

        //click on the slider and go to the next page which is category page.
        WebElement slider = driver.findElement(By.cssSelector(".swiper-slide.swiper-slide-active a"));
        slider.click();
        Thread.sleep(2000);
```
3. Here is how to select the categories from the dropdown list on the Daraz website.
  
 ``` 
      //Select the specific category with hover: E.g. category>groceries>breakfast>honey>new page open
        WebElement category = driver.findElement(By.cssSelector(".lzd-site-menu-nav-category-text"));
        Actions actions = new Actions(driver);
        actions.moveToElement(category).pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);
        WebElement item = driver.findElement    (By.xpath("//span[text()='Groceries']"));
        actions.moveToElement(item);
        actions.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        WebElement breakfast = driver.findElement(By.xpath("//a[@class='lzd-site-menu-root-item-link']//span[contains(text(),'Breakfast')]"));
        actions.moveToElement(breakfast);
       actions.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        WebElement honey = driver.findElement(By.xpath("//a[@href='//www.daraz.com.bd/catalog?q=Honey&from=hp_categories&src=all_channel']//span[contains(text(),'Honey')]"));
        actions.moveToElement(honey).click().pause(Duration.ofSeconds(2)).perform();

        Thread.sleep(2000);

```
4. Here is the search code script for the Daraz website.
   ```
	//to clear the search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='q']"));
	//      searchBox.clear(); -->it does not work successfully.
        searchBox.click();
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);
        Thread.sleep(2000);

        //Write the searching element in the search bar:
        searchBox.sendKeys("Mouse");

        driver.findElement(By.xpath("//a[normalize-space()='SEARCH']")).click();
        Thread.sleep(2000);

        System.out.println("successfully searched");
```

### For Practice Test Automation Site:
Here is the site URL (https://practicetestautomation.com/practice-test-login/) to perform the test automation. 

 ```
       void LoginPageDemoSite() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement lgnBtn = driver.findElement(By.xpath("//button[@id='submit']"));
        username.sendKeys("student");
        password.sendKeys("Password123");
        lgnBtn.click();
        Thread.sleep(3000);
        driver.quit();
        //Click the practice from menubar and click on the testException
        WebElement practice = driver.findElement(By.xpath("//a[normalize-space()='Practice']"));
        practice.click();
        Thread.sleep(2000);
        WebElement testException = driver.findElement(By.xpath("//a[normalize-space()='Test Exceptions']"));
        testException.click();
        Thread.sleep(2000);

        //After clicking the testException, here is clicked the edit button to edit row1 or add row
        WebElement editBtn = driver.findElement(By.xpath("//button[@id='edit_btn']"));
        editBtn.click();
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.xpath("//input[@value='Pizza']"));
        //After writing the value you should clear the input field.
        searchBox.click();
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);
        Thread.sleep(2000);
        searchBox.sendKeys("Chocolate");
        Thread.sleep(2000);
        //Here is click the save button to save the row1.
        WebElement saveBtn = driver.findElement(By.xpath("//button[@id='save_btn']"));
        saveBtn.click();
        Thread.sleep(2000);

        //Here is added row2 and save the button.
        WebElement addBtn = driver.findElement(By.xpath("//button[@id='add_btn']"));
        addBtn.click();
        Thread.sleep(2000);
        WebElement inputR2 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='row2']//input[@class='input-field']"))
        );
        inputR2.sendKeys("Burger and Pasta");
        WebElement saveBtn2 = driver.findElement(By.xpath("//div[@id='row2']//button[@id='save_btn']"));
        saveBtn2.click();
        Thread.sleep(2000);
        driver.quit();
    }
```
# Web Automation using Selenium
Selenium is an open-source tool for automating web browsers. It simulates user actions, such as clicks, typing, and navigation, for testing or repetitive tasks. Selenium supports multiple languages, but I have designed my script using Java. Here is the documented demo site for testing automatically. I have even designed the code script for my company project. Here is some code script for Daraz website.

### Steps of Selenium SetUp: 
 1. Download JDK, Apache Maven, IntelliJ IDEA, Chromedriver 
 2. Create Java Project 
 3. Add selenium dependencies in pom.xml

```
	<dependency>
            		<groupId>org.seleniumhq.selenium</groupId>
            		<artifactId>selenium-java</artifactId>
           		 <version>4.34.0</version>
	</dependency>
```
 4. Run and reload the Maven project.

### For the Daraz website: 
1. Here is how I navigated to this software from another software. The opened window can be maximized, minimized, full-screen, etc.

```
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.get("https://www.youtube.com/");
        // Thread.sleep(2000);

        //Load the Daraz website.
        driver.navigate().to("https://www.daraz.com.bd/");
        //driver.manage().window().maximize();
        Thread.sleep(2000);
```

2. Here is how to get the title, click on the daraz home page slider and go to the next page.
  
``` 
       String title = driver.getTitle();
        if(title.equalsIgnoreCase("daraz"))
            System.out.println("Title matches");
        else System.out.println(title);

        //click on the slider and go to the next page which is category page.
        WebElement slider = driver.findElement(By.cssSelector(".swiper-slide.swiper-slide-active a"));
        slider.click();
        Thread.sleep(2000);
```
3. Here is how to select the categories from the dropdown list on the Daraz website.
  
 ``` 
      //Select the specific category with hover: E.g. category>groceries>breakfast>honey>new page open
        WebElement category = driver.findElement(By.cssSelector(".lzd-site-menu-nav-category-text"));
        Actions actions = new Actions(driver);
        actions.moveToElement(category).pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);
        WebElement item = driver.findElement    (By.xpath("//span[text()='Groceries']"));
        actions.moveToElement(item);
        actions.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        WebElement breakfast = driver.findElement(By.xpath("//a[@class='lzd-site-menu-root-item-link']//span[contains(text(),'Breakfast')]"));
        actions.moveToElement(breakfast);
       actions.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        Thread.sleep(2000);

        WebElement honey = driver.findElement(By.xpath("//a[@href='//www.daraz.com.bd/catalog?q=Honey&from=hp_categories&src=all_channel']//span[contains(text(),'Honey')]"));
        actions.moveToElement(honey).click().pause(Duration.ofSeconds(2)).perform();

        Thread.sleep(2000);

```
4. Here is the search code script for the Daraz website.
   ```
	//to clear the search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='q']"));
	//      searchBox.clear(); -->it does not work successfully.
        searchBox.click();
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);
        Thread.sleep(2000);

        //Write the searching element in the search bar:
        searchBox.sendKeys("Mouse");

        driver.findElement(By.xpath("//a[normalize-space()='SEARCH']")).click();
        Thread.sleep(2000);

        System.out.println("successfully searched");
```

### For Practice Test Automation Site:
Here is the site URL (https://practicetestautomation.com/practice-test-login/) to perform the test automation. 

 ```
       void LoginPageDemoSite() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement lgnBtn = driver.findElement(By.xpath("//button[@id='submit']"));
        username.sendKeys("student");
        password.sendKeys("Password123");
        lgnBtn.click();
        Thread.sleep(3000);
        driver.quit();
        //Click the practice from menubar and click on the testException
        WebElement practice = driver.findElement(By.xpath("//a[normalize-space()='Practice']"));
        practice.click();
        Thread.sleep(2000);
        WebElement testException = driver.findElement(By.xpath("//a[normalize-space()='Test Exceptions']"));
        testException.click();
        Thread.sleep(2000);

        //After clicking the testException, here is clicked the edit button to edit row1 or add row
        WebElement editBtn = driver.findElement(By.xpath("//button[@id='edit_btn']"));
        editBtn.click();
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.xpath("//input[@value='Pizza']"));
        //After writing the value you should clear the input field.
        searchBox.click();
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);
        Thread.sleep(2000);
        searchBox.sendKeys("Chocolate");
        Thread.sleep(2000);
        //Here is click the save button to save the row1.
        WebElement saveBtn = driver.findElement(By.xpath("//button[@id='save_btn']"));
        saveBtn.click();
        Thread.sleep(2000);

        //Here is added row2 and save the button.
        WebElement addBtn = driver.findElement(By.xpath("//button[@id='add_btn']"));
        addBtn.click();
        Thread.sleep(2000);
        WebElement inputR2 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='row2']//input[@class='input-field']"))
        );
        inputR2.sendKeys("Burger and Pasta");
        WebElement saveBtn2 = driver.findElement(By.xpath("//div[@id='row2']//button[@id='save_btn']"));
        saveBtn2.click();
        Thread.sleep(2000);
        driver.quit();
    }
```

[<img width="1366" height="768" alt="Image" src="https://github.com/user-attachments/assets/591a2f91-3aa4-427a-9ff2-0f8107674878" />](https://www.loom.com/share/2288e180562d4fdc9e98387e755d82cf?sid=c82509c5-0f73-4f7d-8102-74637d001eda)


