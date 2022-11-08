package com.capgemini.automacao.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Drivers {
	
	private static WebDriver driver = null;
	
	
	public enum Browser {
		CHROME, FIREFOX, EDGE;
	}
	
	public static void setDriver(Browser browser){

		String diretorioDrivers = System.getProperty("user.dir") + "//src//main//resources//drivers";
		String caminhoEdgeDriver = diretorioDrivers + "//msedgedriver.exe";
		String caminhoFirefoxDriver = diretorioDrivers + "//geckodriver.exe";
		String caminhoChromeDriver = diretorioDrivers + "//chromedriver.exe";
		
		switch(browser) {
			case EDGE:
				System.setProperty("webdriver.edge.driver", caminhoEdgeDriver);
				driver = new EdgeDriver();
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver", caminhoChromeDriver);
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				System.setProperty("webdriver.gecko.driver", caminhoFirefoxDriver);
				driver = new FirefoxDriver();
				break;
		}
		

	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	public static void fecharDriver(){
		driver.quit();
	}
	
}
