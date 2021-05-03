package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TesteWaits {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
//        testeWaitImplicito();
        testeWaitExplicito();
    }

    public static void testeWaitImplicito() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading");

        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        driver.findElement(By.cssSelector(".example #start button")).click();
        String text = driver.findElement(By.cssSelector(".example #finish h4")).getText();
        System.out.println("Aparece: " + text);
    }

    public static void testeWaitExplicito() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading");

        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        driver.findElement(By.cssSelector(".example #start button")).click();
//        Thread.sleep(5000);
        WebElement textoHelloWorld = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".example #finish h4")));
//        textoHelloWorld.click();
        String text = driver.findElement(By.cssSelector(".example #finish h4")).getText();
        System.out.println("Aparece: " + text);
    }
}
