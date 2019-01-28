package ru.fantlab;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Asimov {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("https://fantlab.ru");
    clickOn("А");
    clickOn("Азимов, Айзек");
  }

  @Test
  public void testGoToDetailsAsimovABoysBestFriend() throws Exception {
    clickOn("Лучший друг");
    gotoDetails();
    }

    private void clickOn(String s) {
        driver.findElement(By.linkText(s)).click();
    }

    private void gotoDetails() {
      driver.findElement(By.id("editions-tabs")).click();
      clickOn("подробнее");
    }

    @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
