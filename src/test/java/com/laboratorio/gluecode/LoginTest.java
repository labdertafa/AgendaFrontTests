package com.laboratorio.gluecode;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;

import com.laboratorio.utils.LogHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest extends TestBase {
	private static final Logger logger = LogHelper.getLogger(LoginTest.class);
	
	@Given("que el usuario se encuentra en la página de entrada de la agenda")
	public void queElUsuarioSeEncuentraEnLaPáginaDeEntradaDeLaAgenda() throws Throwable {
		logger.log(Level.INFO, "Ejecutando GIVEN de LoginTest");
	    
	    Assert.assertTrue(loginPage.isDisplayed());
	}

	@When("el usuario escribe su email {string} y su password {string}")
	public void elUsuarioEscribeSuEmailYSuPassword(String login, String password) throws Throwable {
		logger.log(Level.INFO, "Ejecutando WHEN de LoginTest con datos correctos");
		
		loginPage.typeLogin(login);
		loginPage.typePassword(password);
		loginPage.loginAgenda();
	}

	@Then("el usuario entra a la aplicacion")
	public void elUsuarioEntraALaAplicacion() throws Throwable {
		logger.log(Level.INFO, "Ejecutando THEN del caso nominal LoginTest ");
		
		Assert.assertTrue(contactosPage.isDisplayed());
	}
	
	@When("el usuario escribe su email {string} y su password {string} con al menos un dato incorrecto")
	public void elUsuarioEscribeSuEmailYSuPasswordConAlMenosUnDatoIncorrecto(String login, String password) throws Throwable {
		logger.log(Level.INFO, "Ejecutando WHEN de LoginTest con datos incorrectos");
		
		loginPage.typeLogin(login);
		loginPage.typePassword(password);
		loginPage.loginAgenda();
	}

	@Then("se muestra el mensaje de error correspondiente")
	public void seMuestraElMensajeDeErrorCorrespondiente() throws Throwable {
		logger.log(Level.INFO, "Ejecutando THEN del caso de LoginTest con datos erróneos");
		
		Assert.assertTrue(loginPage.isLoginErrorMessageDisplayed());
	}
	
	@When("el usuario entra al campo email y no escribe nada y luego entra al campo password")
	public void el_usuario_entra_al_campo_email_y_no_escribe_nada_y_luego_entra_al_campo_password() throws Throwable {
		logger.log(Level.INFO, "Ejecutando WHEN de LoginTest dejando email vacío");
		loginPage.clicLogin();
		loginPage.clickPassword();
	}

	@Then("aparece un mensaje de error en rojo debajo del campo email")
	public void aparece_un_mensaje_de_error_en_rojo_debajo_del_campo_email() throws Throwable {
		logger.log(Level.INFO, "Ejecutando THEN de LoginTest dejando email vacío");
		
		Assert.assertTrue(loginPage.isEmptyEmailErrorMessageDisplayed());
	}
	
	@When("el usuario entra al campo password y no escribe nada y luego entra al campo email")
	public void el_usuario_entra_al_campo_password_y_no_escribe_nada_y_luego_entra_al_campo_email() throws Throwable {
		logger.log(Level.INFO, "Ejecutando WHEN de LoginTest dejando password vacío");
		loginPage.clickPassword();
		loginPage.clicLogin();
	}

	@Then("aparece un mensaje de error en rojo debajo del campo password")
	public void aparece_un_mensaje_de_error_en_rojo_debajo_del_campo_password() throws Throwable {
		logger.log(Level.INFO, "Ejecutando THEN de LoginTest dejando password vacío");
		
		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());
	}
	
	@When("el usuario escribe campo email el dato {string} con formato incorrecto y luego entra al campo password")
	public void el_usuario_escribe_campo_email_el_dato_con_formato_incorrecto_y_luego_entra_al_campo_password(String dato) throws Throwable {
		logger.log(Level.INFO, "Ejecutando WHEN de LoginTest con un email con formato incorrecto");
		loginPage.typeLogin(dato);
		loginPage.clickPassword();
		
	}

	@Then("aparece el mensaje de formato incorrecto debajo del campo email")
	public void aparece_el_mensaje_de_formato_incorrecto_debajo_del_campo_email() throws Throwable {
		logger.log(Level.INFO, "Ejecutando THEN de LoginTest con un email con formato incorrecto");
		
		Assert.assertTrue(loginPage.isBadEmailFormatErrorMessageDisplayed());
	}
}