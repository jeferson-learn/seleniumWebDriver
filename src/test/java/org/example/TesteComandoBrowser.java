package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteComandoBrowser {

    private static WebDriver driver;

    public static void main(String[] args) {
        comandoBrowser();
    }

    public static void comandoBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        String titulo = driver.getTitle();
        System.out.println("1-" + titulo);

        String url = driver.getCurrentUrl();
        System.out.println("2-" + url);

        String codigoFonte = driver.getPageSource();
        System.out.println("3-" + codigoFonte);

        driver.quit();
    }

}
