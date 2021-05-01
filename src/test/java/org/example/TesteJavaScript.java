package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteJavaScript {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
//        submarino();
        javaScriptTest2();
    }

    public static void submarino() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.submarino.com.br");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('h_search-input').value='livros';");
        js.executeScript("document.getElementById('h_search-btn').click();");
        WebElement elementRecaptcha = driver.findElement(By.cssSelector(".rc-anchor-center-container #recaptcha-anchor"));
        elementRecaptcha.click();
        js.executeScript("window.scrollBy(0,1000)");
//        Livro - A rainha vermelha
        WebElement livro = driver.findElement(By.cssSelector("img[alt='Livro - A rainha vermelha']"));
        js.executeScript("argument[0].click();", livro);

    }

    public static void javaScriptTest2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement linkCheck = driver.findElement(By.linkText("Checkboxes"));
        js.executeScript("arguments[0].click();", linkCheck);

        String titulo = js.executeScript("return document.title").toString();
        System.out.println(titulo);

        WebElement checkBox = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)"));
        js.executeScript("arguments[0].checked=true", checkBox);
        js.executeScript("alert('O elemento foi checkado!');");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        js.executeScript("arguments[0].checked=false", checkBox);

        js.executeScript("history.go(0);");

        Thread.sleep(2000);
    }
}
