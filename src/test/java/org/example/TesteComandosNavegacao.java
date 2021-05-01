package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TesteComandosNavegacao {

    private static WebDriver driver;

    public static void main(String[] args) {
        navegacao();
    }

    public static void navegacao() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        driver.navigate().to("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Thaviny");

        Actions act = new Actions(driver);

        act.sendKeys(Keys.ENTER).build().perform();

        driver.findElement(By.linkText("Imagens")).click();

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();
    }
}
