package com.laboratorio.gluecode;

import org.openqa.selenium.WebDriver;

import com.laboratorio.pom.CiudadesPage;
import com.laboratorio.pom.ContactosPage;
import com.laboratorio.pom.DireccionesPage;
import com.laboratorio.pom.LoginPage;
import com.laboratorio.pom.MediosPage;
import com.laboratorio.pom.RegistroPage;

public class TestBase {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected ContactosPage contactosPage;
	protected MediosPage mediosPage;
	protected CiudadesPage ciudadesPage;
	protected DireccionesPage direccionesPage;
	protected RegistroPage registroPage;
	
	protected String administradorUser;
	protected String administradorPass;

	public TestBase() {
		this.driver = Hooks.getDriver();
		this.loginPage = new LoginPage(driver);
		this.contactosPage = new ContactosPage(driver);
		this.mediosPage = new MediosPage(driver);
		this.ciudadesPage = new CiudadesPage(driver);
		this.direccionesPage = new DireccionesPage(driver);
		this.registroPage = new RegistroPage(driver);
		
		this.administradorUser = Hooks.getAdministradorUser();
		this.administradorPass = Hooks.getAdministradorPass();
	}
}