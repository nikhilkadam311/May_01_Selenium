package org.applicationHooks;

import java.util.Properties;

import org.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AppHooks {
	public static Properties prop;
	private WebDriver driver;
@Before(order=0)
public void getProperty() {
	ConfigReader cr =new ConfigReader();
	prop = cr.getProp();
}
@Before(order=1)
public void initBrowser() {
	String bName = prop.getProperty("browserName");
	DriverFactory df = new DriverFactory();
	driver = df.init_driver(bName);
}
@After(order=1)
public void takeScreenShot() {
	
}
@After(order=0)
public void tearDown() {
	driver.quit();
}
//@BeforeStep //AfterStep
// public void test2{}
}