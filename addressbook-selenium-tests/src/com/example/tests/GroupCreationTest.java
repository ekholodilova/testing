package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();    //local variable
    group.name = "group name 2"; //filling data by manually
    group.header = "header 2"; 
    group.footer = "footer 2"; 
	app.getGroupHelper().fillGroupForm( group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    app.getGroupHelper().initGroupCreation();
	    app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupPage();
	  }
}

