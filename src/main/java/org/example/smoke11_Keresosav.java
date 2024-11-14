package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class smoke11_Keresosav {

            public static void main() {
                WebDriver driver = new ChromeDriver();
                JavascriptExecutor js = (JavascriptExecutor) driver;
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                long timer= System.currentTimeMillis();

                //Weblap megnyitása
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver.get("https://www.mediamarkt.hu");


                //Cookie-k elfogadása
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"gdpr-cookie-layer__btn gdpr-cookie-layer__btn--submit gdpr-cookie-layer__btn--submit--all\"]"))).click();


                //Keresősávban televízió megadása és keresés
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search-phrase\"]"))).sendKeys("Televízió");
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"site-search-submit\"]"))).click();


                //validálás
                if (driver.findElement(By.xpath("//h2[text()]/a")).getText().contains("tv")) {
                    System.out.println("Keresősáv - Passed");
                    Smoke.incrementHelyes();
                }
                else {
                    System.out.println("Keresősáv - Failed");
                }

                //Chrome bezárása
                driver.quit();

            }
        }
