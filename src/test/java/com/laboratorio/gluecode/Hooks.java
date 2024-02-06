package com.laboratorio.gluecode;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.laboratorio.browsers.DriverManager;
import com.laboratorio.browsers.DriverManagerFactory;
import com.laboratorio.browsers.DriverType;
import com.laboratorio.utils.LogHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private static final Logger logger = LogHelper.getLogger(Hooks.class);
	private static int numEscenario = 0;
	private String url;
	private static String administradorUser;
	private static String administradorPass;
	private static WebDriver driver;
	private DriverManager driverManager;
	
	@Before
	public void setUpScenario() throws IOException {
		numEscenario++;
		logger.log(Level.INFO, "Antes de ejecutar el escenario: " + numEscenario);
		
		this.url = "";
		administradorUser = "";
		administradorPass = "";
		try {
			Properties properties = new Properties();
			properties.load(new FileReader("src/test/resources/config.properties"));
			this.url = properties.getProperty("pagina_principal");
			administradorUser = properties.getProperty("usuario_administrador");
			administradorPass = properties.getProperty("password_administrador");
			logger.log(Level.INFO, "Configuración cargada!");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error al leer los datos de la configuración");
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
		}
		
		// Iniciar browser
		driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
		driver = driverManager.getDriver();
		driver.get(this.url);
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDownScenario(Scenario scenario) {
		logger.log(Level.INFO, "Despues de ejecutar el escenario: " + numEscenario);
		
		// Toma de captura de pantalla
		TakesScreenshot ts = (TakesScreenshot)driver;
		final byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
		
		// Cerrar browser
		driverManager.quitDriver();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static String getAdministradorUser() {
		return administradorUser;
	}

	public static String getAdministradorPass() {
		return administradorPass;
	}
}