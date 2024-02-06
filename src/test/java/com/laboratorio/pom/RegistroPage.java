package com.laboratorio.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistroPage extends BasePage {
	private String tituloPaginaRegistro = "Registro de la agenda del Laboratorio de Rafa";
	private By tituloRegistroLocator = By.xpath("/html/body/app-root/app-registro/section/div/div/div[2]/div/h3");
	private By campoNombreLocator = By.id("nombre");
	private By campoUsuarioLocator = By.id("usuario");
	private By campoEmailLocator = By.id("email");
	private By campoPasswordLocator = By.id("password");
	private By campoConfirmacionLocator = By.id("confirmacion");
	private By botonRegistrarLocator = By.xpath("/html/body/app-root/app-registro/section/div/div/div[2]/div/form/div[6]/div[1]/button");
	private String contenidoMensajeError = "El email o el usuario ya existen. Por favor escoja unos distintos";
	private By mensajeErrorLocator = By.id("swal2-html-container");
	
	public RegistroPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDisplayed() throws Exception {
		this.waitForElement(tituloRegistroLocator);
		WebElement element = this.findElement(tituloRegistroLocator);
		return tituloPaginaRegistro.equals(element.getText());
	}
	
	public void typeNombre(String nombre) throws Exception {
		WebElement element = this.findElement(campoNombreLocator);
		this.typeText(element, nombre);
	}
	
	public void typeUsuario(String usuario) throws Exception {
		WebElement element = this.findElement(campoUsuarioLocator);
		this.typeText(element, usuario);
	}
	
	public void typeEmail(String email) throws Exception {
		WebElement element = this.findElement(campoEmailLocator);
		this.typeText(element, email);
	}
	
	public void typePassword(String password) throws Exception {
		WebElement element = this.findElement(campoPasswordLocator);
		this.typeText(element, password);
	}
	
	public void typeConfirmacion(String confirmacion) throws Exception {
		WebElement element = this.findElement(campoConfirmacionLocator);
		this.typeText(element, confirmacion);
	}
	
	public void registrarUusuario() throws Exception {
		WebElement element = this.findElement(botonRegistrarLocator);
		this.click(element);
	}
	
	public boolean isErrorMessageDisplayed() throws Exception {
		this.waitForElement(mensajeErrorLocator);
		WebElement element = this.findElement(mensajeErrorLocator);
		return contenidoMensajeError.equals(element.getText());
	}
}