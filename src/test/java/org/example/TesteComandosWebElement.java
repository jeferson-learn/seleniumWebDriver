package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteComandosWebElement {

    private static WebDriver driver;

    public static void main(String[] args) {
        webElement();
    }

    public static void webElement(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("Jeferson@hotmail.com");
        driver.findElement(By.id("email")).clear();

        boolean apareceu;
        apareceu = driver.findElement(By.id("email")).isDisplayed();
        System.out.println("displayed: "+apareceu);

        boolean habilitado;
        habilitado = driver.findElement(By.id("email")).isEnabled();
        System.out.println("Enabled: "+habilitado);

//        boolean selecionado = driver.findElement(By.name("sex")).isSelected();
//        System.out.println("selected: "+selecionado);

        String textoDoLink;
        textoDoLink = driver.findElement(By.linkText("Esqueceu a senha?")).getText();
        System.out.println("getText: " + textoDoLink);

        driver.findElement(By.name("login")).submit();

        driver.quit();



    }


}
