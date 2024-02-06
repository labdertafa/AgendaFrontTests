package com.laboratorio.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MediosPage extends BasePage {
	private String contenidoTituloMedios = "Listado de los medios de comunicación";
	private By tituloMediosLocator = By.xpath("/html/body/app-root/app-medios-comunicacion/div/div/div/div[1]/h3");
	
	public MediosPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDisplayed() throws Exception {
		this.waitForElement(tituloMediosLocator);
		WebElement element = this.findElement(tituloMediosLocator);
		return contenidoTituloMedios.equals(element.getText());
	}
}