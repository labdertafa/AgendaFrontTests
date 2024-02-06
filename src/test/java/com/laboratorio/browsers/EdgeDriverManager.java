package com.laboratorio.browsers;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
	@Override
	protected void createDriver() {
		System.setProperty("webdriver.msedge.driver", "./src/test/resources/edgedriver/msedgedriver.exe");
		driver = new EdgeDriver();	
	}
}