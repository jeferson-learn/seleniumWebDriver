package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TesteComboBox {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
//        combobox();
//        radioButton();
        checkBox();
    }

    public static void combobox() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.seleniumeasy.com/test/");

        driver.findElement(By.linkText("Input Forms")).click();
        driver.findElement(By.linkText("Select Dropdown List")).click();
        /**---1------------------------------------------**/
//        new Select(driver.findElement(By.id("select-demo"))).selectByValue("Tuesday");
//        Thread.sleep(3000);
//        new Select(driver.findElement(By.id("select-demo"))).selectByIndex(1);
//        Thread.sleep(3000);
//        new Select(driver.findElement(By.id("select-demo"))).selectByVisibleText("Friday");
//        Thread.sleep(3000);
        /**---2------------------------------------------**/
        Select diasSemana = new Select(driver.findElement(By.id("select-demo")));
        diasSemana.selectByIndex(1);
        Thread.sleep(3000);
        diasSemana.selectByValue("Tuesday");
        Thread.sleep(3000);
        diasSemana.selectByVisibleText("Friday");
        Thread.sleep(3000);
    }

    public static void radioButton() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.seleniumeasy.com/test/");

        driver.findElement(By.linkText("Input Forms")).click();
        driver.findElement(By.linkText("Radio Buttons Demo")).click();

        driver.findElement(By.xpath("//input[@value='Male']")).click();//falha
    }

    public static void checkBox() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.seleniumeasy.com/test/");

        driver.findElement(By.linkText("Input Forms")).click();
        driver.findElement(By.linkText("Checkbox Demo")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600);");

        List<WebElement> labels = driver.findElements(By.xpath("//label"));

        for (int i = 0; i < labels.size(); i++) {
            if (labels.get(i).getAttribute("innerText").contentEquals("Option 2") || labels.get(i).getAttribute("innerText").contentEquals("Option 4")) {
                labels.get(i).click();
            }
        }

    }

}
