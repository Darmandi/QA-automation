package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {


    public WebDriver driver;
    private String browser;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            driver = new InternetExplorerDriver();
        }
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
