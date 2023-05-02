package testCases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class CreateAccountFailure {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\lazym\\Downloads\\pc_parts_professionals-main test\\pc_parts_professionals-main\\PCPartsProfessionals\\src\\main\\webapp\\WEB-INF\\lib\\win\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testCreateAccountFailure() throws Exception {
    driver.get("http://ec2-54-236-27-225.compute-1.amazonaws.com:8080/PCPartsProfessionals/pc_parts_Login.html");
    driver.findElement(By.linkText("Create Account")).click();
    driver.get("http://ec2-54-236-27-225.compute-1.amazonaws.com:8080/PCPartsProfessionals/pc_parts_CreateAccount.html");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("TestCase");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("TestCase");
    driver.findElement(By.xpath("//form[@action='CreateAccount']")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("TestCase@gmail.com");
    driver.findElement(By.id("phonenumber")).click();
    driver.findElement(By.id("phonenumber")).clear();
    driver.findElement(By.id("phonenumber")).sendKeys("111-111-1111");
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='']/parent::*")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.get("http://ec2-54-236-27-225.compute-1.amazonaws.com:8080/PCPartsProfessionals/pc_parts_Accounts.html");
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
