package com.laboratorio.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DireccionesPage extends BasePage {
	private String tituloPaginaDirecciones  = "Listado de todos las direcciones";
	private By tituloDireccionesLocator = By.xpath("/html/body/app-root/app-direcciones/div/div/div/div[1]/h3");

	public DireccionesPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDisplayed() throws Exception {
		this.waitForElement(tituloDireccionesLocator);
		WebElement element = this.findElement(tituloDireccionesLocator);
		return tituloPaginaDirecciones.equals(element.getText());
	}
}