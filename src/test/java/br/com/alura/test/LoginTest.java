package br.com.alura.test;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	    private LoginPage paginaDeLogin;
	    
	   
   
		@BeforeEach
	    public void beforeEach() {
	       this.paginaDeLogin = new LoginPage();
	       
	    	
	    }
	   
		@AfterEach	
	    public void afterEach() {
		 
			this.paginaDeLogin.fechar();
			
	    	
	    }
	
	
	    @Test
	    public void deveriaEfetuarLoginComDadosValidos() {
	    
	       paginaDeLogin.preencheFormulario("fulano","pass");
	       paginaDeLogin.efetuaLogin();
           Assert.assertFalse(paginaDeLogin.isPaginaLogin());
	       Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
	       
	        
	       
	    }
	    
	    
	    
	    
	    @Test
	    public void naoDeveriaEfetuarLoginComDadosInvalidos() {

		       paginaDeLogin.preencheFormulario("invalido","12345678");
		       paginaDeLogin.efetuaLogin();

		       Assert.assertTrue(paginaDeLogin.isPaginaError());
		       Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
		       Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	      
	    }
	    
	    
	    @Test
	    public void naoDeveriaAcessarAreaRestrita() {
	    	 paginaDeLogin.navegaParaPaginadeLances();
	    	 
	    	
	    	
	    	  Assert.assertTrue(paginaDeLogin.isPaginaLogin());;
	    	  Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
		        
	    	
	    }
}
