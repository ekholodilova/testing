package com.example.tests;

import org.testng.annotations.Test;

public class CopyOfGroupCreationTest extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();    //local variable
    group.name = "group name 2"; //filling data by manually
    group.header = "header 2"; //filling data by manually
    group.footer = "footer 2"; //filling data by manually
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

