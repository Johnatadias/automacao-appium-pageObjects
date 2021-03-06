package br.com.rsinet.appium.core;

import static br.com.rsinet.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class BasePage {
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void selecionarCombo(By by, String texto) {
		getDriver().findElement(by).click();

		// Selecionando ação desejada
		clicarPoTexto(texto);
	}

	public void clicarPoTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));
	}

	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
}
