package com.laboratorio.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactosPage extends BasePage {
	private String contenidoTituloContactos = "Listado de todos los contactos";
	private By tituloContactosLocator = By.xpath("/html/body/app-root/app-contactos/div/div/div/div[1]/h3");
	private By menuMediosLocator = By.xpath("/html/body/app-root/app-contactos/app-menu/div/ul/li[2]/a");
	private By menuCiudadesLocator = By.xpath("/html/body/app-root/app-contactos/app-menu/div/ul/li[3]/a");
	private By menuDireccionesLocator = By.xpath("/html/body/app-root/app-contactos/app-menu/div/ul/li[4]/a");
	private By menuSalirLocator = By.xpath("/html/body/app-root/app-contactos/app-menu/div/ul/li[5]/a");
	
	public ContactosPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDisplayed() throws Exception {
		this.waitForElement(tituloContactosLocator);
		WebElement tituloContactos = this.findElement(tituloContactosLocator);
		return contenidoTituloContactos.equals(this.getText(tituloContactos));
	}
	
	public void clickMenuMedios() throws Exception {
		WebElement element = this.findElement(menuMediosLocator);
		this.click(element);
	}
	
	public void clickMenuCiudades() throws Exception {
		WebElement element = this.findElement(menuCiudadesLocator);
		this.click(element);
	}
	
	public void clickMenuDirecciones() throws Exception {
		WebElement  element = this.findElement(menuDireccionesLocator);
		this.click(element);
	}
	
	public void clickMenuSalir() throws Exception {
		WebElement  element = this.findElement(menuSalirLocator);
		this.click(element);
	}
}