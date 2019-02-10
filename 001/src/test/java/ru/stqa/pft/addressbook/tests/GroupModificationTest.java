package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends  TestBase {

    @Test
    public void testGroupModification() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("Group 1", "Header 1", "Footer 1"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().editSelectedGroups();
        app.getGroupHelper().fillGroupForm(new GroupData("Group 2", "Header 2", "Footer 2"));
        app.getGroupHelper().updateSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }
}
