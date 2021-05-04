package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TesteIframes {
    private static WebDriver driver;

    public static void main(String[] args) {
        testeIframes();
    }

    public static void testeIframes() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/iframe");

        /**---1---------------------------------------**/
//        driver.switchTo().frame("mce_0_ifr");
        /**---2---------------------------------------**/
//        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
//        driver.switchTo().frame(iframe);
        /**---3---------------------------------------**/
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        for (int i = 0; i < frames.size(); i++) {
            System.out.println(frames.get(i).getAttribute("id"));
        }
        driver.switchTo().frame(0);

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Oi tudo bem, eu gostaria de saber se eu sou bom?");

        /**---1---------------------------------------**/
//        driver.switchTo().defaultContent();
        /**---2---------------------------------------**/
        driver.switchTo().parentFrame();


        driver.findElement(By.linkText("Elemental Selenium")).click();
    }

}
