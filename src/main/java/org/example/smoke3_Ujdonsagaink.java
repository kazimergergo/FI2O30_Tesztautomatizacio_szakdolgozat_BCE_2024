package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class smoke3_Ujdonsagaink {

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


                //Gomb megnyomása
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menu-for-four\"]/a[3]"))).click();


                //validálás
                if (driver.findElement(By.xpath("//*[@id=\"category\"]/hgroup/h1")).getText().contains("Újdonságaink")) {
                    System.out.println("Újdonságaink - Passed");
                    Smoke.incrementHelyes();
                }
                else {
                    System.out.println("Újdonságaink - Failed");
                }

                //Chrome bezárása
                driver.quit();

            }
        }
