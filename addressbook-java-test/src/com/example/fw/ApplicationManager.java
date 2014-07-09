package com.example.fw;

import java.util.Properties;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;

public class ApplicationManager {

	private static final com.example.fw.MenuHelper menuHelper = null;
	private static ApplicationManager singleton;
    private Properties props;
    
	//public String baseUrl;

	private FolderHelper FolderHelper;
	private JFrameOperator mainFrame;
	private Object MenuHelper;

	public static ApplicationManager getInstance() {
		if (singleton == null) {
			singleton = new ApplicationManager();
		}
		return singleton;
	}

	public void stop() {
		getApplication().requestClose();
    }
	
	public void  setProperties (Properties props) {
		this.props = props;
	}
	
	public String getProperties (String key) {
		return props.getProperty(key);
	}
	
	public String getProperties (String key, String defaultValue) {
		return props.getProperty(key,defaultValue);
	}

	public FolderHelper getFolderHelper() {
		if (FolderHelper ==null) {
			FolderHelper = new FolderHelper(this);
		}
		return FolderHelper;
	}

	public JFrameOperator getApplication() {
		if(mainFrame == null) {
		try {
			new ClassReference("addressbook.AddressBookFrame").startApplication();
			mainFrame= new JFrameOperator("jAddressBook");
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
		return mainFrame;
	}

	public MenuHelper getMenuHelper() {
		if (MenuHelper ==null) {
			MenuHelper = new MenuHelper(this);
		}
		return menuHelper;
	}
}
