package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.Console;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hvg.hu/");
        WebElement asd = driver.findElement(By.xpath("//button[@class=\" css-8zhqum\"]"));
        String asd2 = asd.getAttribute("class");
        asd.click();
        System.out.println(asd2);
        //driver.quit();
        }
    }
