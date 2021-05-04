package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TesteTabelaHTML {
    private static WebDriver driver;

    public static void main(String[] args) {
        testeTabelaHtml();
    }

    public static void testeTabelaHtml() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://scrud.whirlwind.nl/");
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='table_companies']/tbody/tr")));

        List<WebElement> todasLinhas = driver.findElements(By.xpath("//table[@id='table_companies']/tbody/tr"));
        System.out.println("Quantidade linhas: " + todasLinhas.size());

        List<WebElement> todasColunas = driver.findElements(By.xpath("//table[@id='table_companies']/tbody/tr/td"));
        System.out.println("Quantidade colunas: " + todasColunas.size());
/**
        for (int i = 0; i < todasLinhas.size(); i++) {

            for (int j = 0; j < todasColunas.size(); j++) {
                System.out.println(todasColunas.get(j).getText());
            }

        }
**/
        String nomeEmpresaEditar = "cvvfvf";

        for (int a = 0; a < todasLinhas.size(); a++) {

            for (int b = 0; b < todasColunas.size(); b++) {
                if (todasColunas.get(b).getText().contentEquals(nomeEmpresaEditar)) {
                    driver.findElement(By.xpath("//li[@class='function_edit']/a[@data-name='"+nomeEmpresaEditar+"']")).click();
                    break;
                }
            }
            break;
        }
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#form_company #company_name")));
        driver.findElement(By.cssSelector("#form_company #company_name")).clear();
        driver.findElement(By.cssSelector("#form_company #company_name")).sendKeys("fulanoEMPRESA");
        driver.findElement(By.cssSelector("#form_company button")).submit();
    }

}
