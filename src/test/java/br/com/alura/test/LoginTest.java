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
	
	
	    private static final String URL_LOGIN = "http://localhost:8080/login";
		private ChromeDriver browser;
       
	    @BeforeAll
	    //roda uma unica vez antes de todos os outros.
        public static void beforeAll() {
	    	
	    	//seta o path para o selenium
	        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");


        }
		@BeforeEach
		//criamos esse metodo para executar antes de todos os outros
		
	    public void beforeEach() {
	    	
			
	        //cria um objeto chromedriver
	        this.browser = new ChromeDriver();
	        //acessar o site 
	        this.browser.navigate().to(URL_LOGIN);
	    	
	    }
	   
		@AfterEach
		//criamos esse metodo para executar depois de todos os outros
		
	    public void afterEach() {
			
			this.browser.quit();
	    	
	    }
	
	
	    @Test
	    public void deveriaEfetuarLoginComDadosValidos() {
	    
	      
	       // busca  o id e digita fulano  		
	        browser.findElement(By.id("username")).sendKeys("fulano");
	        // busca o id e digita pass
	        browser.findElement(By.id("password")).sendKeys("pass");
	        // busca o id login-form e clica em submit
	        browser.findElement(By.id("login-form")).submit();

	        //usando o metodo getCurrentUrl que busca o url atual valida se é o igual o url passado
	        Assert.assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
	        
	        // valida se fulano esta logado através do id 
	        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
	        // fecha o navegador aplicação
	        
	       
	    }
	    
	    
	    
	    
	    @Test
	    public void naoDeveriaEfetuarLoginComDadosInvalidos() {
	    
	        // busca  o id e digita   		
	        browser.findElement(By.id("username")).sendKeys("invalido");
	        // busca o id e digita 
	        browser.findElement(By.id("password")).sendKeys("12345678");
	        // busca o id login-form e clica em submit
	        browser.findElement(By.id("login-form")).submit();

	        //usando o metodo getCurrentUrl que busca o url atual valida se é o igual o url passado
	        Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
	        
	        // valida se na pagina contem a frase citada
	        Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
	        // verifica se a exception é lançada, pois o usuario logado não é visivel nessa pagina.
	        Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));
	       
	        // fecha o navegador aplicação
	      
	    }
}
