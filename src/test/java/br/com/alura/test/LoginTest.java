package br.com.alur.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	    @Test
	    public void deveriaEfetuarLoginComDadosValidos() {
	    	//seta o path para o selenium
	        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	        //cria um objeto chromedriver
	        WebDriver browser = new ChromeDriver();
	        //acessar o site 
	        browser.navigate().to("http://localhost:8080/login");
	       // busca  o id e digita fulano  		
	        browser.findElement(By.id("username")).sendKeys("fulano");
	        // busca o id e digita pass
	        browser.findElement(By.id("password")).sendKeys("pass");
	        // busca o id login-form e clica em submit
	        browser.findElement(By.id("login-form")).submit();

	        //usando o metodo getCurrentUrl que busca o url atual valida se é o igual o url passado
	        Assert.assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login"));
	        
	        // valida se fulano esta logado através do id 
	        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
	        browser.quit();
	    }
}
