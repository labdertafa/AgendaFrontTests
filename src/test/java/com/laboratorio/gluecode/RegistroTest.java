package com.laboratorio.gluecode;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;

import com.laboratorio.utils.LogHelper;
import com.laboratorio.utils.ReadExcelFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistroTest extends TestBase {
	private static final Logger logger = LogHelper.getLogger(RegistroTest.class);
	
	@Given("que el usuario se encuentra en la pagina de registro de nuevos usuarios")
	public void queElUsuarioSeEncuentraEnLaPaginaDeRegistroDeNuevosUsuarios() throws Throwable {
		logger.log(Level.INFO, "RegistroTest: ir a la página de registro");
		
		Assert.assertTrue(loginPage.isDisplayed());
		loginPage.clickRegistroLink();
		Assert.assertTrue(registroPage.isDisplayed());
	}
	
	private String[] cargarDatosUsuario() throws Exception {
		int rowCount = ReadExcelFile.getRowCount("src/test/resources/datos_pruebas.xlsx", "correctos");
		Random rand = new Random();
		int fila = rand.nextInt(rowCount-1) + 1;
		return ReadExcelFile.getRowValues("src/test/resources/datos_pruebas.xlsx", "correctos", fila);
	}

	@When("el usuario introduce informacion valida en los campos")
	public void elUsuarioIntroduceInformacionValidaEnLosCampos() throws Throwable {
	    String datosUsuario[] = cargarDatosUsuario();
	    logger.log(Level.INFO, "RegistroTest: Se han cargado los datos del nuevo usuario: " + datosUsuario);
	    
	    registroPage.typeNombre(datosUsuario[0]);
	    registroPage.typeUsuario(datosUsuario[1]);
	    registroPage.typeEmail(datosUsuario[2]);
	    registroPage.typePassword(datosUsuario[3]);
	    registroPage.typeConfirmacion(datosUsuario[3]);
	}

	@When("pulsa sobre el boton")
	public void pulsaSobreElBoton() throws Throwable {
		logger.log(Level.INFO, "RegistroTest: Pulsar el botón registrar");
		registroPage.registrarUusuario();
	}

	@Then("el sistema te envía a la página de login")
	public void elSistemaTeEnvíaALaPáginaDeLogin() throws Throwable {
		logger.log(Level.INFO, "RegistroTest: verificar el regreso a la página de login");
		Assert.assertTrue(loginPage.isDisplayed());
	}

	@Then("te muestrar el mensaje indicando que el usuario ha sido creado")
	public void teMuestrarElMensajeIndicandoQueElUsuarioHaSidoCreado() throws Throwable {
	    Assert.assertTrue(loginPage.isRegistroMessageDisplayed());
	}
	
	@When("el usuario introduce informacion inválida en los campos y pusa sobre el boón Registrar")
	public void elUsuarioIntroduceInformacionInválidaEnLosCamposYPusaSobreElBoónRegistrar() throws Throwable {
		String datosUsuario[] = cargarDatosUsuario();
	    logger.log(Level.INFO, "RegistroTest: Se han cargado los datos del nuevo usuario: " + datosUsuario);
	    
	    registroPage.typeNombre(datosUsuario[0]);
	    registroPage.typeUsuario(datosUsuario[1]);
	    registroPage.typeEmail(datosUsuario[2]);
	    registroPage.typePassword(datosUsuario[3]);
	    registroPage.typeConfirmacion(datosUsuario[3]);
	    
	    logger.log(Level.INFO, "RegistroTest: Pulsar el botón registrar");
		registroPage.registrarUusuario();
	}

	@Then("el sistema muestra un popup con un mensaje de error")
	public void elSistemaMuestraUnPopupConUnMensajeDeError() throws Throwable {
		logger.log(Level.INFO, "RegistroTest: verificar que se muestra el mensaje de error");
		Assert.assertTrue(registroPage.isErrorMessageDisplayed());
	}
}