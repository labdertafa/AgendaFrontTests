package com.laboratorio.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	private String contenidoTituloLogin = "Entrada a la agenda del Laboratorio de Rafa";
	private By tituloLoginLocator = By.xpath("/html/body/app-root/app-login/section/div/div/div[2]/div/h3");
	private By campoEmailLocator = By.id("email");
	private By campoPasswordLocator = By.id("password");
	private By botonEntrarLocator = By.xpath("/html/body/app-root/app-login/section/div/div/div[2]/div/form/div[3]/div[1]/button");
	private By loginMessageLocator = By.xpath("/html/body/app-root/app-login/section/div/div/div[2]/div/h4");
	private String contenidoLoginErrorMessage = "El email o la contraseña no son correctos";
	private String contenidoRegistroMessage = "Se han registrado sus datos de usuario correctamente";
	private By emailErrorMessageLocator = By.xpath("/html/body/app-root/app-login/section/div/div/div[2]/div/form/div[1]/span");
	private String contenidoMensajeErrorEmail = "La dirección de correo es obligatoria";
	private By passwordErrorMessageLocator = By.xpath("/html/body/app-root/app-login/section/div/div/div[2]/div/form/div[2]/span");
	private String contenidoMensajeErrorPassword = "La contraseña es obligatoria";
	private By emailWrongFormatMessageLocator = By.xpath("/html/body/app-root/app-login/section/div/div/div[2]/div/form/div[1]/span");
	private String contenidoMensajeEmailIncorrecto = "Formato de dirección de correo inválido";
	private By signUpLinkLocator = By.xpath("/html/body/app-root/app-login/section/div/div/div[2]/div/form/div[3]/div[2]/a");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDisplayed() throws Exception {
		WebElement tituloLogin = this.findElement(tituloLoginLocator);
		return this.getText(tituloLogin).equals(contenidoTituloLogin);
	}
	
	public void clicLogin() throws Exception {
		WebElement campoEmail = this.findElement(campoEmailLocator);
		this.click(campoEmail);
	}
	
	public void typeLogin(String email) throws Exception {
		WebElement campoEmail = this.findElement(campoEmailLocator);
		this.typeText(campoEmail, email);
	}
	
	public void clickPassword() throws Exception {
		WebElement campoPassword = this.findElement(campoPasswordLocator);
		this.click(campoPassword);
	}
	
	public void typePassword(String password) throws Exception {
		WebElement campoPassword = this.findElement(campoPasswordLocator);
		this.typeText(campoPassword, password);
	}
	
	public void loginAgenda() throws Exception {
		WebElement botonEntrar = this.findElement(botonEntrarLocator);
		this.click(botonEntrar);
	}
	
	public boolean isLoginErrorMessageDisplayed() throws Exception {
		this.waitForElement(loginMessageLocator);
		WebElement loginErrorMessage = this.findElement(loginMessageLocator);
		return this.contenidoLoginErrorMessage.equals(loginErrorMessage.getText());
	}
	
	public boolean isRegistroMessageDisplayed() throws Exception {
		this.waitForElement(loginMessageLocator);
		WebElement element = this.findElement(loginMessageLocator);
		return this.contenidoRegistroMessage.equals(element.getText());
	}
	
	public boolean isEmptyEmailErrorMessageDisplayed() throws Exception {
		this.waitForElement(emailErrorMessageLocator);
		WebElement emailErrorMessage = this.findElement(emailErrorMessageLocator);
		return this.contenidoMensajeErrorEmail.endsWith(emailErrorMessage.getText());
	}
	
	public boolean isEmptyPasswordErrorMessageDisplayed() throws Exception {
		this.waitForElement(passwordErrorMessageLocator);
		WebElement passwordErrorMessage = this.findElement(passwordErrorMessageLocator);
		return this.contenidoMensajeErrorPassword.equals(passwordErrorMessage.getText());
	}
	
	public boolean isBadEmailFormatErrorMessageDisplayed() throws Exception {
		this.waitForElement(emailWrongFormatMessageLocator);
		WebElement element = this.findElement(emailWrongFormatMessageLocator);
		return this.contenidoMensajeEmailIncorrecto.equals(element.getText());
	}
	
	public void clickRegistroLink() throws Exception {
		WebElement element = this.findElement(signUpLinkLocator);
		this.click(element);
	}
}