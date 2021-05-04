package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class TesteModalPopup {
    private static WebDriver driver;

    public static void main(String[] args) {
//        modal();
        janelas();
    }

    public static void modal() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.uitestpractice.com/Students/Switchto");

        driver.findElement(By.cssSelector("button[data-target='#myModal']")).click();
        WebElement botaoOK = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#myModal .btn-primary")));
        botaoOK.click();

    }

    public static void janelas() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.uitestpractice.com/Students/Switchto");

        String janelaPrincipal = driver.getWindowHandle();

        System.out.println(driver.switchTo().window(janelaPrincipal).getCurrentUrl());

        driver.findElement(By.linkText("Opens in a new window")).click();

        Set<String> todasJanelas = driver.getWindowHandles();

        for (String janela : todasJanelas) {
            if(!janela.contentEquals(janelaPrincipal)){
                System.out.println(driver.switchTo().window(janela).getCurrentUrl());
            }
        }

        driver.switchTo().window(janelaPrincipal);
    }
}
