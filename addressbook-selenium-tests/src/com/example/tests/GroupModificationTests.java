package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void modifySomeGroup() {
		
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group =new GroupData();
		group.name = "new name1_1";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
	    app.getGroupHelper().returnToGroupPage();
	    
	    
	    app.getGroupHelper().initGroupModification(2);
		GroupData group1 =new GroupData();
		group1.header = "header2 was modified"; 
	    group1.footer = "footer2 was modified"; 
		app.getGroupHelper().fillGroupForm(group1);
		app.getGroupHelper().submitGroupModification();
	    app.getGroupHelper().returnToGroupPage();
	    
		
	    app.getGroupHelper().initGroupModification(3);
		GroupData group2 =new GroupData();
		group2.name = "new name3_3";
		group2.header = ""; 
	    group2.footer = ""; 
		app.getGroupHelper().fillGroupForm(group2);
		app.getGroupHelper().submitGroupModification();
	    app.getGroupHelper().returnToGroupPage();
	    
    	}
	}
