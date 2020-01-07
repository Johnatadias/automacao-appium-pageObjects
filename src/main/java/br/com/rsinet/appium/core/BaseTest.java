package br.com.rsinet.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	@Rule
	public TestName testName= new TestName();
	
	@AfterClass // executa apenas uma vez ao final de todos os metodos(testes) daquela class
	public static void finalizaClasse() {
		DriverFactory.killDriver();
	}
	
	@After // executa sempre no final de cada teste
	public void finaliza() {
		gerarScreenshot();
		DriverFactory.getDriver().resetApp(); // Deixar o teste mais rapido
	}
	
	public void gerarScreenshot() {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem, new File("target/screenshotReport/"+ testName.getMethodName() +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
