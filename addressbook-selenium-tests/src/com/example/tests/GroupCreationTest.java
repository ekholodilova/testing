package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();    //local variable
    group.name = "group name 1"; //filling data by manually
    group.header = "header 1"; //filling data by manually
    group.footer = "footer 1"; //filling data by manually
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
		openMainPage();
	    gotoGroupsPage();
	    initGroupCreation();
	    fillGroupForm(new GroupData("", "", ""));
	    submitGroupCreation();
	    returnToGroupPage();
	  }
}

