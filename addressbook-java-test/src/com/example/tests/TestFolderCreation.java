package com.example.tests;


import org.testng.annotations.Test;

import com.example.fw.Folders;

//import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestFolderCreation extends TestBase {

	@Test	
	public void testFolderCreation() {
		String folder = "newfolder";
		Folders oldFolders = app.getFolderHelper().getFolder();
		app.getFolderHelper().createFolder (folder);
		Folders newFolders = app.getFolderHelper().getFolder();
		assertThat(newFolders,equalTo(oldFolders.withAdded(folder)));
		
	}
	
	@Test	
	public void testVatiousFoldersCreation() {
		String folder1 = "newfolder1";
		String folder2 = "newfolder2";
		Folders oldFolders = app.getFolderHelper().getFolder();
		assertThat(app.getFolderHelper().createFolder (folder1),is(nullValue()));
		Folders newFolders = app.getFolderHelper().getFolder();
		assertThat(newFolders,equalTo(oldFolders.withAdded(folder1)));
		assertThat(app.getFolderHelper().createFolder (folder2),is(nullValue()));
		Folders newFolders2 = app.getFolderHelper().getFolder();
		assertThat(newFolders2,equalTo(oldFolders.withAdded(folder2)));
	}
	
	@Test	
	public void testFoldersWithSameNameCreation() {
		String folder = "newfolder3";
		Folders oldFolders = app.getFolderHelper().getFolder();
		assertThat(app.getFolderHelper().createFolder (folder),is(nullValue()));
		Folders newFolders = app.getFolderHelper().getFolder();
		assertThat(newFolders,equalTo(oldFolders.withAdded(folder)));
		assertThat(app.getFolderHelper().createFolder (folder),containsString("Duplicated folder"));
		Folders newFolders2 = app.getFolderHelper().getFolder();
		assertThat(newFolders2,equalTo(newFolders));
	}
}
