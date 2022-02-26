package br.com.alura.test;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	 private static final String URL_LOGIN = "http://localhost:8080/login";
	private static final Object URL_ERROR = "http://localhost:8080/login?error";
		private ChromeDriver browser;
		

	    
	    public LoginPage() {
	    		       
	    	 System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	    	 this.browser = new ChromeDriver();
		      this.browser.navigate().to(URL_LOGIN);
	    	
	    }
	  

		 void fechar() {
			this.browser.quit();
			
		}


		public void preencheFormulario(String user, String pass) {

	        browser.findElement(By.id("username")).sendKeys(user);
	        browser.findElement(By.id("password")).sendKeys(pass);
	        
			
		}


		public void efetuaLogin() {
			browser.findElement(By.id("login-form")).submit();
			
		}


		public boolean isPaginaLogin() {
			
			return browser.getCurrentUrl().equals(URL_LOGIN);
		}


		public Object getNomeUsuarioLogado() {
		 try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} catch(NoSuchElementException e) {
			 return null;
		} }


		public void navegaParaPaginadeLances() {
			this.browser.navigate().to("http://localhost:8080/leiloes/2");
			
		}


		public boolean contemTexto(String texto) {
			// TODO Auto-generated method stub
			return browser.getPageSource().contains(texto);
		}


		public boolean isPaginaError() {
			// TODO Auto-generated method stub
			 return browser.getCurrentUrl().equals(URL_ERROR);
		}
	
		
}
