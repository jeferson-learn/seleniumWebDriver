package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TesteLocator {

    private static WebDriver driverChrome;

    public static void main(String[] args) throws InterruptedException {
//        testeFacebook();
//        testeTagClass();
//        testeClasseName();
//        testeTexto();
        testeCssSelectorId();
    }

    public static void testeFacebook() {
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.get("https://www.facebook.com");

        driverChrome.findElement(By.id("email")).sendKeys("email@email.com.br");
        driverChrome.findElement(By.id("pass")).sendKeys("123456");
        driverChrome.findElement(By.name("login")).click();

        driverChrome.quit();
    }

    public static void testeTagClass() {
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.get("https://www.facebook.com");

        List<WebElement> inputs = driverChrome.findElements(By.tagName("input"));

        System.out.println("Quantidades de inputs:" + inputs.size());

        for (WebElement element : inputs) {
            System.out.println(element.getText());
        }

        driverChrome.quit();
    }

    public static void testeClasseName() {
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.get("https://www.trivago.com.br");

//        driverChrome.findElement(By.cssSelector("button[class='siteheader__control'] .flex-wrapper")).click();
//        driverChrome.findElement(By.xpath("button[class='siteheader__control'] .flex-wrapper")).click();
        WebDriverWait wait = new WebDriverWait(driverChrome, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".has-popover")));
        driverChrome.findElement(By.cssSelector(".has-popover")).click();
        driverChrome.quit();
    }

    public static void testeTexto() {
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.get("https://www.facebook.com");

//        driverChrome.findElement(By.linkText("Esqueceu a senha?")).click();
        driverChrome.findElement(By.partialLinkText("a senha")).click();
    }

    public static void testeCssSelectorId() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.get("https://www.facebook.com");

        driverChrome.findElement(By.cssSelector("#email")).sendKeys("Teste@email.com");
        driverChrome.findElement(By.cssSelector("#pass")).sendKeys("123456");
//        driverChrome.findElement(By.name("login")).click();
        driverChrome.findElement(By.cssSelector("._6ltg button")).click();

        Thread.sleep(10000);
        driverChrome.quit();

    }
}
