package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper {

    ChromeDriver driver;

    public SessionHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    protected void login(String login, String password) {
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(login);
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
    }
}
