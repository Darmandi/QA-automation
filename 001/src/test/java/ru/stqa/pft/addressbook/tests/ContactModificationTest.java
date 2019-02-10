package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends  TestBase {
    @Test
    public  void testContactModification() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("Name 2", "Surename 2", null), false);
        app.getContactHelper().updateContact();
        app.getContactHelper().returnToHomePage();
    }
}
