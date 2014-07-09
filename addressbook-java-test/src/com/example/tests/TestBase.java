package com.example.tests;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected Logger log = Logger.getLogger("TEST");
	protected  ApplicationManager app = null; // link to
													// ApplicationManager
	@BeforeClass
	@Parameters ({"configFile"})
	public  void setUp(@Optional String configFile) throws Exception {
	  if (configFile == null) {
		  configFile = System.getProperty("configFile") ;
	  }
	  if  (configFile == null) {
		  configFile = System.getenv("configFile") ;
	  }
	  if  (configFile == null) {
		  configFile = "application.properties";
	  }
	  Properties props = new Properties();
	  props.load(new FileReader(configFile));
	  log.info ("setUp start");
	  app = ApplicationManager.getInstance();
	  app.setProperties(props);
	  log.info("setUp end");
	}  
	
	@AfterTest
	public void tearDown() throws Exception {
		  log.info("tearDown start");
		  ApplicationManager.getInstance().stop();
		  log.info("tearDown end");		  
	}
	
}	
		
		
		
	/*@BeforeMethod
	public  void setUp() throws Exception {
		String configFile = System.getProperty("configFile","application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);

	}

	@AfterMethod
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}

	public static  List<Object[]> wrapGroupForDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (GroupData group : groups) {
        	list.add(new Object[]{group});
        }
		return list;
	}
	
	public static  List<Object[]> wrapContactForDataProvider(List<ContactData> contacts) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (ContactData contact : contacts) {
        	list.add(new Object[]{contact});
        }
		return list;
	}
}
*/