package com.laboratorio.pom;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.laboratorio.utils.LogHelper;

public class BasePage {
	private static final Logger logger = LogHelper.getLogger(BasePage.class);
	private WebDriver driver;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Encontrar un elemento por su localizador
	protected WebElement findElement(By locator) throws Exception {
		try {
			return driver.findElement(locator);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo encontrar el elemento con el localizador: " + locator);
		}
	}
	
	// Hacer click en un elemento
	protected void click(WebElement element) throws Exception {
		try {
			element.click();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo hacer click sobre el elemento: " + element);
		}
	}
	
	// Verificar si un elemento está desplegado
	protected boolean isDisplayed(WebElement element) throws Exception {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo encontrar el elemento: " + element);
		}
	}
	
	// Recuperar el texto de un elemento
	protected String getText(WebElement element) throws Exception {
		try {
			return element.getText();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo obtener el texto del elemento: " + element);
		}
	}
	
	// Agregar texto a un elemento
	protected void typeText(WebElement element, String text) throws Exception {
		try {
			element.sendKeys(text);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo escribir el texto en el elemento: " + element);
		}
	}
	
	protected void waitForElement(By locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	// Obtener el título de la ventana del navegador
	protected String getTitle() throws Exception {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error: " + e.getMessage());
			throw new Exception("No se pudo obtener el título de la página del navegador");
		}
	}
}