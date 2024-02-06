package com.laboratorio.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CiudadesPage extends BasePage {
	private String tituloPaginaCiudades = "Listado de todas las ciudades";
	private By tituloCiudadesLocator = By.xpath("/html/body/app-root/app-ciudades/div/div/div/div[1]/h3");

	public CiudadesPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDisplayed() throws Exception {
		this.waitForElement(tituloCiudadesLocator);
		WebElement element = this.findElement(tituloCiudadesLocator);
		return tituloPaginaCiudades.equals(element.getText());
	}
}