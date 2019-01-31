package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(ChromeDriver driver) {
        super(driver);
    }

    protected void login(String login, String password) {
        type(By.name("user"),login);
        type(By.name("pass"),password);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]"));
    }
}
