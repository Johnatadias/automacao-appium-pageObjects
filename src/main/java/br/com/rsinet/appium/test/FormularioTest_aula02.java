package br.com.rsinet.appium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import br.com.rsinet.appium.core.BaseTest;
import br.com.rsinet.appium.page.FormularioPage;
import br.com.rsinet.appium.page.MenuPage;

public class FormularioTest_aula02 extends BaseTest{

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();
	
	@Before
	public void inicializa() {
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoText() throws MalformedURLException {
//		 Selecionar Formulario
//		List<MobileElement> elementoEncontrados = driver.findElements(By.className("android.widget.TextView"));
//	    for(MobileElement elemento : elementoEncontrados) {
//	    	System.out.println(elemento.getText());
//	    }
//		elementoEncontrados.get(1).click();

		// Escrever nome
		page.escreverNome("Johnata");

		// Checar nome escrito
		assertEquals("Johnata", page.obterNome());
	}

	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		// Clicar no combo
		page.selecionarCombo("Nintendo Switch");

		// Verificar ação desejada
		assertEquals("Nintendo Switch", page.obterValorDoCombo());
	}

	@Test
	public void deveInteragirComSwitchCheckBox() throws MalformedURLException {

		//Verificar status dos elementos
		assertFalse(page.isCheckMarcado());
		assertTrue(page.isSwitchMarcado());

		//Clicar nos elementos 
		page.clicarCheck();
		page.clicarSwitch();
		
		//Verificar estados auterados
		assertTrue(page.isCheckMarcado());
		assertFalse(page.isSwitchMarcado());

	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		
		//Prenchendo os campos
		page.escreverNome("Johnata Dias");
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");
		page.clicarCheck();
		
		//Botão salvar
		page.salvar();
		
		//Verificando
		assertEquals("Nome: Johnata Dias", page.obterNomeCadastrado());
		assertEquals("Console: switch", page.obterConsoleCadastrado()); 
		assertTrue(page.obterSwitchCadastrado().endsWith("Off"));
		assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));

	}
}
