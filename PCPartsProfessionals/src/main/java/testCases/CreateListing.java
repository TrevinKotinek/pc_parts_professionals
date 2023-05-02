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

public class CreateListing {
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
  public void testCreateListing() throws Exception {
    driver.get("http://ec2-54-236-27-225.compute-1.amazonaws.com:8080/PCPartsProfessionals/pc_parts_Listings.html");
    driver.findElement(By.linkText("Listings")).click();
    driver.findElement(By.linkText("Create Listing")).click();
    driver.get("http://ec2-54-236-27-225.compute-1.amazonaws.com:8080/PCPartsProfessionals/pc_parts_CreateListing.html");
    driver.findElement(By.id("model")).click();
    driver.findElement(By.id("model")).clear();
    driver.findElement(By.id("model")).sendKeys("TestModel");
    driver.findElement(By.id("price")).click();
    driver.findElement(By.id("price")).clear();
    driver.findElement(By.id("price")).sendKeys("1");
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("Omaha");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create Listing'])[1]/following::div[1]")).click();
    driver.findElement(By.id("partType")).click();
    new Select(driver.findElement(By.id("partType"))).selectByVisibleText("GPU");
    driver.findElement(By.id("brand")).click();
    new Select(driver.findElement(By.id("brand"))).selectByVisibleText("Intel");
    driver.findElement(By.id("condition")).click();
    new Select(driver.findElement(By.id("condition"))).selectByVisibleText("Very Poor");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create Listing'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.get("http://ec2-54-236-27-225.compute-1.amazonaws.com:8080/PCPartsProfessionals/MyCreateListing?model=TestModel&price=1&city=Omaha&partType=GPU&brand=Intel&condition=VeryPoor");
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
