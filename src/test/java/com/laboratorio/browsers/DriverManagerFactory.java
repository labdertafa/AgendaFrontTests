package com.laboratorio.browsers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.laboratorio.utils.LogHelper;

public class DriverManagerFactory {
	private static final Logger logger = LogHelper.getLogger(DriverManagerFactory.class);
	
	public static DriverManager getDriverManager(DriverType type) {
		DriverManager driverManager = null;
		
		switch (type) {
			case CHROME:
				driverManager = new ChromeDriverManager();
				logger.log(Level.INFO, "Se ha creado el ChromeDriver existosamente");
				break;
			case FIREFOX:
				driverManager = new FirefoxDriverManager();
				logger.log(Level.INFO, "Se ha creado el FirefoxDriver existosamente");
				break;
			case EDGE:
				driverManager = new EdgeDriverManager();
				logger.log(Level.INFO, "Se ha creado el EdgeDriver existosamente");
				break;
			default:
				logger.log(Level.SEVERE, "Invalid browser selected!");
				break;
		}
		
		return driverManager;
	}
}