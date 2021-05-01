package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TesteActions {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
//        testeTeclado();
//        testeMouse();
//        testeContextClick();
        testClickAndHold();
    }

    public static void testeTeclado() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        WebElement elementEmail = driver.findElement(By.id("email"));
        WebElement elementPass = driver.findElement(By.id("pass"));

        Actions actions = new Actions(driver);
        actions.sendKeys(elementEmail, "email@email.com").build().perform();
        actions.sendKeys(elementPass, "123456").build().perform();
        elementEmail.clear();
        actions.keyDown(elementEmail, Keys.SHIFT);
        actions.sendKeys(elementEmail, "email@email.com").build().perform();
        elementEmail.clear();
        actions.keyUp(elementEmail, Keys.SHIFT);
        actions.sendKeys(elementEmail, "jeferson").build().perform();


        Thread.sleep(2000);
        driver.quit();
    }

    public static void testeMouse() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/login");

        Actions actions = new Actions(driver);

        WebElement elementUsername = driver.findElement(By.id("username"));
        WebElement elementPassword = driver.findElement(By.id("password"));
        WebElement elementLogin = driver.findElement(By.className("radius"));

        actions.sendKeys(elementUsername, "tomsmith111").build().perform();
        actions.doubleClick(elementUsername).build().perform();
        actions.sendKeys(elementUsername, "tomsmith").build().perform();
        actions.sendKeys(elementPassword, "SuperSecretPassword!").build().perform();
        actions.click(elementLogin).build().perform();

        Thread.sleep(2000);

        driver.quit();
    }

    public static void testeContextClick() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        Actions actions = new Actions(driver);

//        WebElement elementRightClick = driver.findElement(By.cssSelector(".document p span"));
        WebElement elementRightClick = driver.findElement(By.cssSelector(".btn"));

        actions.contextClick(elementRightClick).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ENTER).build().perform();
        driver.switchTo().alert().accept();
        /** outro jeito **/
//        actions.contextClick(elementRightClick).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        driver.quit();
    }

    public static void testClickAndHold() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/login");

        Actions actions = new Actions(driver);

        WebElement elementUsername = driver.findElement(By.id("username"));
        WebElement elementPassword = driver.findElement(By.id("password"));
        WebElement elementLogin = driver.findElement(By.className("radius"));

        actions.sendKeys(elementUsername, "tomsmith").build().perform();
        actions.sendKeys(elementPassword, "SuperSecretPassword!").build().perform();
        actions.clickAndHold(elementLogin).build().perform();


    }
}
