package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class smoke13_Bejelentkezes {

            public static void main() {
                WebDriver driver = new ChromeDriver();
                JavascriptExecutor js = (JavascriptExecutor) driver;
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                long timer= System.currentTimeMillis();
                Actions actions = new Actions(driver);


                //Weblap megnyitása
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver.get("https://www.mediamarkt.hu");


                //Cookie-k elfogadása
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"gdpr-cookie-layer__btn gdpr-cookie-layer__btn--submit gdpr-cookie-layer__btn--submit--all\"]"))).click();


                //Belépés opció kiválasztása fent
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//*[@id=\"header\"]/header/div[1]/div/div[4]/nav/div/a"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/header/div[1]/div/div[4]/nav/div/div/ul/li[1]/a"))).click();


                //Email és jelszó megadása
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-email\"]"))).sendKeys("BCE.KazimerGergely.Szakdolgozat@gmail.com");
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-password\"]"))).sendKeys("Corvinus2024");


                // Belépés gomb megnyomása, validálás
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"my-account-action-login\"]"))).click();
                    System.out.println("Bejelentkezés - Passed");
                    Smoke.incrementHelyes();
                } catch (Exception e) {
                    System.out.println("Bejelentkezés - Failed");
                };


                //Chrome bezárása
                driver.quit();

            }
        }
