package com.laboratorio.gluecode;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import com.laboratorio.utils.LogHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavegacionTest extends TestBase {
	private static final Logger logger = LogHelper.getLogger(NavegacionTest.class);
	
	@Given("que el usuario se encuentra en la pagina de mantenimiento de contactos")
	public void queElUsuarioSeEncuentraEnLaPaginaDeMantenimientoDeContactos() throws Throwable {
		logger.log(Level.INFO, "Ejecutando el BACKGROUND de NavegacionTest");
		
		Assert.assertTrue(loginPage.isDisplayed());
		
		loginPage.typeLogin(this.administradorUser);
		loginPage.typePassword(this.administradorPass);
		loginPage.loginAgenda();
		
		Assert.assertTrue(contactosPage.isDisplayed());
	}

	@When("el usuario hace click en la opcion medios de comunicacion")
	public void elUsuarioHaceClickEnLaOpcionMediosDeComunicacion() throws Throwable {
		logger.log(Level.INFO, "Ejecutando el WHEN NavegacionTest a página Medios de comunicación");
		
		contactosPage.clickMenuMedios();
	}

	@Then("se muestra la pagina de mantenimiento de medios de comunicacion")
	public void seMuestraLaPaginaDeMantenimientoDeMediosDeComunicacion() throws Throwable {
		logger.log(Level.INFO, "Ejecutando el THEN NavegacionTest a página Medios de comunicación");
		
		Assert.assertTrue(mediosPage.isDisplayed());
	}
	
	@When("el usuario hace click en la opcion Ciudades")
	public void elUsuarioHaceClickEnLaOpcionCiudades() throws Throwable {
		logger.log(Level.INFO, "Ejecutando el WHEN NavegacionTest a página Ciudades");
		
		contactosPage.clickMenuCiudades();
	}

	@Then("se muestra la pagina de mantenimiento de ciudades")
	public void seMuestraLaPaginaDeMantenimientoDeCiudades() throws Throwable {
		logger.log(Level.INFO, "Ejecutando el THEN NavegacionTest a página Ciudades");
		
		Assert.assertTrue(ciudadesPage.isDisplayed());
	}
	
	@When("el usuario hace click en la opcion Direcciones")
	public void elUsuarioHaceClickEnLaOpcionDirecciones() throws Throwable {
		logger.log(Level.INFO, "Ejecutando el WHEN NavegacionTest a página Direcciones");
		
		contactosPage.clickMenuDirecciones();
	}

	@Then("se muestra la pagina de mantenimiento de direcciones")
	public void seMuestraLaPaginaDeMantenimientoDeDirecciones() throws Throwable {
		logger.log(Level.INFO, "Ejecutando el THEN NavegacionTest a página Direcciones");
		
		Assert.assertTrue(direccionesPage.isDisplayed());
	}

	@When("el usuario hace click en la opcion Salir")
	public void elUsuarioHaceClickEnLaOpcionSalir() throws Throwable {
		logger.log(Level.INFO, "Ejecutando el WHEN NavegacionTest a página de Login");
		
		contactosPage.clickMenuSalir();
	}

	@Then("se muestra la pagina de login")
	public void seMuestraLaPaginaDeLogin() throws Throwable {
		logger.log(Level.INFO, "Ejecutando el THEN NavegacionTest a página de Login");
		
		Assert.assertTrue(loginPage.isDisplayed());
	}
}