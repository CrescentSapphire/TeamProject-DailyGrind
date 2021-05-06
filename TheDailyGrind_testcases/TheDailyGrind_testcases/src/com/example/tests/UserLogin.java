package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UserLogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
	 System.setProperty("webdriver.chrome.driver",//
			 "lib\\win\\chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUserLogin() throws Exception {
    driver.get("http://moonbeancoffee.cafe/inventory/");
    driver.findElement(By.linkText("Here")).click();
    driver.findElement(By.id("id_username")).click();
    driver.findElement(By.id("id_username")).clear();
    Thread.sleep(3000);
    driver.findElement(By.id("id_username")).sendKeys("trying");
    driver.findElement(By.id("id_password")).click();
    driver.findElement(By.id("id_password")).clear();
    driver.findElement(By.id("id_password")).sendKeys("Apples1234");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    
    //Confirm that log out option is there
    String expected = "Log Out";
    String result = driver.findElement(By.xpath("//a[contains(text(), \"Log Out\")]")).getAttribute("innerHTML");
    Assert.assertEquals(expected, result);
  }
  
 @Test
  public void testSignUp() throws Exception {
    driver.get("http://moonbeancoffee.cafe/login/");
    driver.findElement(By.linkText("here")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("id_username")).click();
    driver.findElement(By.id("id_username")).clear();
    driver.findElement(By.id("id_username")).sendKeys("trying");
    driver.findElement(By.id("id_email")).clear();
    driver.findElement(By.id("id_email")).sendKeys("test@gmail.com");
    driver.findElement(By.id("id_password1")).clear();
    driver.findElement(By.id("id_password1")).sendKeys("Apples1234");
    driver.findElement(By.id("id_password2")).clear();
    driver.findElement(By.id("id_password2")).sendKeys("Apples1234");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    
    //user trying to sign up with link on log in page working. 
    String expected = "A user with that username already exists.";
    String result = driver.findElement(By.xpath("//strong[contains(text(), \"A user with that username already exists.\")]")).getAttribute("innerHTML");
    
    Assert.assertEquals(expected, result);
   
  }
  

  
  @Test
  public void testUserLogout() throws Exception{
	    driver.get("http://moonbeancoffee.cafe/inventory/");
	    driver.findElement(By.linkText("Here")).click();
	    driver.findElement(By.id("id_username")).click();
	    driver.findElement(By.id("id_username")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.id("id_username")).sendKeys("trying");
	    driver.findElement(By.id("id_password")).click();
	    driver.findElement(By.id("id_password")).clear();
	    driver.findElement(By.id("id_password")).sendKeys("Apples1234");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(1000);
	  driver.findElement(By.linkText("Log Out")).click();
	  
	  //make sure that option to log back in screen showed up. This means user successfully logged out.
	  String expected = "Login";
	  String result = driver.findElement(By.xpath("//*[contains(text(), \"Login\")]")).getAttribute("innerHTML");
	  Assert.assertEquals(expected, result.substring(0,5));
  }
  
  @Test
  public void testSearchAndUpdate() throws Exception {
	    driver.get("http://moonbeancoffee.cafe/inventory/");
	    driver.findElement(By.linkText("Here")).click();
	    driver.findElement(By.id("id_username")).click();
	    driver.findElement(By.id("id_username")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.id("id_username")).sendKeys("trying");
	    driver.findElement(By.id("id_password")).click();
	    driver.findElement(By.id("id_password")).clear();
	    driver.findElement(By.id("id_password")).sendKeys("Apples1234");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("id_sc_name")).click();
	    driver.findElement(By.id("id_sc_name")).clear();
	    driver.findElement(By.id("id_sc_name")).sendKeys("Milk");
	    driver.findElement(By.id("submit-id-submit")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("Edit")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("id_sc_daily_demand")).clear();
	    driver.findElement(By.id("id_sc_daily_demand")).sendKeys("31");
	    driver.findElement(By.id("id_sc_daily_demand")).click();
	    driver.findElement(By.id("id_sc_daily_demand")).clear();
	    driver.findElement(By.id("id_sc_daily_demand")).sendKeys("32");
	    driver.findElement(By.id("id_sc_daily_demand")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=id_sc_daily_demand | ]]
	    driver.findElement(By.id("id_sc_daily_demand")).clear();
	    driver.findElement(By.id("id_sc_daily_demand")).sendKeys("33");
	    driver.findElement(By.id("id_sc_daily_demand")).click();
	    driver.findElement(By.id("id_sc_daily_demand")).clear();
	    driver.findElement(By.id("id_sc_daily_demand")).sendKeys("34");
	    driver.findElement(By.id("id_sc_daily_demand")).click();
	    driver.findElement(By.id("id_sc_popularity")).click();
	    driver.findElement(By.xpath("//body")).click();
	    driver.findElement(By.id("id_sc_popularity")).clear();
	    driver.findElement(By.id("id_sc_popularity")).sendKeys("Low");
	    driver.findElement(By.id("id_sc_days_before_out")).clear();
	    driver.findElement(By.id("id_sc_days_before_out")).sendKeys("6");
	    driver.findElement(By.id("id_sc_days_before_out")).click();
	    driver.findElement(By.id("id_sc_days_before_out")).clear();
	    driver.findElement(By.id("id_sc_days_before_out")).sendKeys("7");
	    driver.findElement(By.id("id_sc_days_before_out")).click();
	    driver.findElement(By.id("id_sc_days_before_out")).clear();
	    driver.findElement(By.id("id_sc_days_before_out")).sendKeys("8");
	    driver.findElement(By.id("id_sc_days_before_out")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=id_sc_days_before_out | ]]
	    driver.findElement(By.id("submit-id-submit")).click();
	    
	    //Assert that changes where made by using one example entry through search link
	    char expected = '8';
	    String result = driver.findElement(By.xpath("//*[@class='row' and contains(text(), '8')]")).getAttribute("innerHTML");
	    int index = 0;
	    for(int i = 0; i < result.length(); i++) {
	 	   System.out.println(result.charAt(i));
	 	   if(result.charAt(i) == '8') {
	 		   index = i;
	 	   }
	    }
	    Assert.assertEquals(expected, result.charAt(index));
    
  }
  
  @Test
  public void testUpdateMainPage() throws Exception {
    driver.get("http://moonbeancoffee.cafe/inventory/");
    driver.findElement(By.linkText("Here")).click();
    driver.findElement(By.id("id_username")).click();
    driver.findElement(By.id("id_username")).clear();
    Thread.sleep(1000);
    driver.findElement(By.id("id_username")).sendKeys("trying");
    driver.findElement(By.id("id_password")).clear();
    driver.findElement(By.id("id_password")).sendKeys("Apples1234");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[16]")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("id_sc_daily_demand")).clear();
    driver.findElement(By.id("id_sc_daily_demand")).sendKeys("2");
    driver.findElement(By.id("id_sc_daily_demand")).click();
    driver.findElement(By.id("id_sc_daily_demand")).clear();
    driver.findElement(By.id("id_sc_daily_demand")).sendKeys("3");
    driver.findElement(By.id("id_sc_daily_demand")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=id_sc_daily_demand | ]]
    driver.findElement(By.id("id_sc_popularity")).click();
    driver.findElement(By.id("id_sc_popularity")).clear();
    driver.findElement(By.id("id_sc_popularity")).sendKeys("medium");
    driver.findElement(By.id("id_sc_days_before_out")).clear();
    driver.findElement(By.id("id_sc_days_before_out")).sendKeys("3");
    driver.findElement(By.id("id_sc_days_before_out")).click();
    driver.findElement(By.id("submit-id-submit")).click();
    
    //Assert that changes could be made through edit link on main inventory page
    char expected = '3';
    String result = driver.findElement(By.xpath("//*[@class='row' and contains(text(), '3')]")).getAttribute("innerHTML");
    int index = 0;
    for(int i = 0; i < result.length(); i++) {
 	   System.out.println(result.charAt(i));
 	   if(result.charAt(i) == '3') {
 		   index = i;
 	   }
    }
    Assert.assertEquals(expected, result.charAt(index));
    
  }

 @Test
  public void testBasicSearch() throws Exception {
    driver.get("http://moonbeancoffee.cafe/inventory/");
    driver.get("http://moonbeancoffee.cafe/inventory/");
    driver.findElement(By.linkText("Here")).click();
    driver.findElement(By.id("id_username")).click();
    driver.findElement(By.id("id_username")).clear();
    Thread.sleep(1000);
    driver.findElement(By.id("id_username")).sendKeys("trying");
    driver.findElement(By.id("id_password")).click();
    driver.findElement(By.id("id_password")).clear();
    driver.findElement(By.id("id_password")).sendKeys("Apples1234");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("id_sc_name")).click();
    driver.findElement(By.id("id_sc_name")).clear();
    driver.findElement(By.id("id_sc_name")).sendKeys("Milk");
    driver.findElement(By.id("submit-id-submit")).click();
    
    //show search result worked
    String expected = "Mark Fat Free Milk";
    String result = driver.findElement(By.xpath("//*[contains(text(), \"Mark Fat Free Milk\")]")).getAttribute("innerHTML");
    Assert.assertEquals(expected, result);
  }
 
 @Test
 public void testDelete() throws Exception {
   driver.get("http://moonbeancoffee.cafe/inventory/");
   driver.findElement(By.linkText("Here")).click();
   driver.findElement(By.id("id_username")).click();
   driver.findElement(By.id("id_username")).clear();
   Thread.sleep(1000);
   driver.findElement(By.id("id_username")).sendKeys("trying");
   driver.findElement(By.id("id_password")).clear();
   driver.findElement(By.id("id_password")).sendKeys("Apples1234");
   driver.findElement(By.id("id_password")).sendKeys(Keys.ENTER);
   driver.findElement(By.xpath("(//a[contains(text(),'Delete')])[7]")).click();
 }
 
 @Test
 public void testAddItem() throws Exception {
   driver.get("http://moonbeancoffee.cafe/inventory/");
   driver.findElement(By.linkText("Here")).click();
   driver.findElement(By.id("id_username")).click();
   driver.findElement(By.id("id_username")).clear();
   Thread.sleep(1000);
   driver.findElement(By.id("id_username")).sendKeys("trying");
   driver.findElement(By.id("id_password")).clear();
   driver.findElement(By.id("id_password")).sendKeys("Apples1234");
   driver.findElement(By.xpath("//button[@type='submit']")).click();
   Thread.sleep(1000);
   driver.findElement(By.linkText("Add Item")).click();
   driver.findElement(By.id("id_sc_name")).click();
   driver.findElement(By.id("id_sc_name")).clear();
   driver.findElement(By.id("id_sc_name")).sendKeys("Chocolate Cake");
   driver.findElement(By.id("id_sc_daily_demand")).click();
   driver.findElement(By.id("id_sc_daily_demand")).clear();
   driver.findElement(By.id("id_sc_daily_demand")).sendKeys("4");
   driver.findElement(By.id("id_sc_popularity")).click();
   driver.findElement(By.id("id_sc_popularity")).clear();
   driver.findElement(By.id("id_sc_popularity")).sendKeys("Low");
   driver.findElement(By.id("id_sc_days_before_out")).click();
   driver.findElement(By.id("id_sc_days_before_out")).clear();
   driver.findElement(By.id("id_sc_days_before_out")).sendKeys("7");
   driver.findElement(By.id("submit-id-submit")).click();
 }
 
 @Test
 public void testUpdate() throws Exception {
   driver.get("http://moonbeancoffee.cafe/inventory/");
   driver.findElement(By.linkText("Here")).click();
   driver.findElement(By.id("id_username")).clear();
   Thread.sleep(1000);
   driver.findElement(By.id("id_username")).sendKeys("trying");
   driver.findElement(By.id("id_password")).clear();
   driver.findElement(By.id("id_password")).sendKeys("Apples1234");
   driver.findElement(By.xpath("//button[@type='submit']")).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[12]")).click();
   Thread.sleep(1000);
   driver.findElement(By.id("id_sc_daily_demand")).clear();
   driver.findElement(By.id("id_sc_daily_demand")).sendKeys("1");
   driver.findElement(By.id("id_sc_daily_demand")).click();
   driver.findElement(By.id("id_sc_daily_demand")).clear();
   driver.findElement(By.id("id_sc_daily_demand")).sendKeys("2");
   driver.findElement(By.id("id_sc_daily_demand")).click();
   // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=id_sc_daily_demand | ]]
   driver.findElement(By.id("id_sc_daily_demand")).clear();
   driver.findElement(By.id("id_sc_daily_demand")).sendKeys("3");
   driver.findElement(By.id("id_sc_daily_demand")).click();
   driver.findElement(By.id("id_sc_popularity")).click();
   driver.findElement(By.id("id_sc_popularity")).clear();
   driver.findElement(By.id("id_sc_popularity")).sendKeys("Low");
   driver.findElement(By.id("id_sc_days_before_out")).clear();
   driver.findElement(By.id("id_sc_days_before_out")).sendKeys("3");
   driver.findElement(By.id("id_sc_days_before_out")).click();
   driver.findElement(By.id("id_sc_days_before_out")).clear();
   driver.findElement(By.id("id_sc_days_before_out")).sendKeys("4");
   driver.findElement(By.id("id_sc_days_before_out")).click();
   // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=id_sc_days_before_out | ]]
   driver.findElement(By.id("id_sc_days_before_out")).clear();
   driver.findElement(By.id("id_sc_days_before_out")).sendKeys("5");
   driver.findElement(By.id("id_sc_days_before_out")).click();
   driver.findElement(By.id("submit-id-submit")).click();
   
   //show attribute was successfully changed
   char expected = '5';
   String result = driver.findElement(By.xpath("//*[@class='row' and contains(text(), '5')]")).getAttribute("innerHTML");
   int index = 0;
   for(int i = 0; i < result.length(); i++) {
	   System.out.println(result.charAt(i));
	   if(result.charAt(i) == '5') {
		   index = i;
	   }
   }
   Assert.assertEquals(expected, result.charAt(index));
 }
 
 @Test
 public void testDetails() throws Exception {
   driver.get("http://moonbeancoffee.cafe/inventory/");
   driver.findElement(By.linkText("Here")).click();
   driver.findElement(By.id("id_username")).clear();
   Thread.sleep(1000);
   driver.findElement(By.id("id_username")).sendKeys("trying");
   driver.findElement(By.id("id_password")).click();
   driver.findElement(By.id("id_password")).clear();
   driver.findElement(By.id("id_password")).sendKeys("Apples1234");
   driver.findElement(By.xpath("//button[@type='submit']")).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath("(//a[contains(text(),'Detail')])[2]")).click();
   
   //Assert we are looking at the root beer details page from inventory main page link
   String expected = "Blueberry";
   String result = driver.findElement(By.xpath("//*[@class='row' and contains(text(), 'Blueberry Bagels')]")).getAttribute("innerHTML");
   result = result.substring(13,22);
   System.out.print(result);
   Assert.assertEquals(expected, result);
   
 }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
