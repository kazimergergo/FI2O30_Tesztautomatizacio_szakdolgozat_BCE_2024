package Smoke_Test_Cases;

import Test_Executions.Smoke_Test_Cycle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class smoke9_Cegeknek {

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


                // Gomb megnyomása
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/header/div[3]/div[3]/nav/a[5]"))).click();


                //validálás
                if (driver.findElement(By.xpath("//*[@id=\"header-btn\"]/a[1]")).getText().contains("Ajánlatkérés")) {
                    System.out.println("Cégeknek - Passed");
                    Smoke_Test_Cycle.incrementHelyes();
                }
                else {
                    System.out.println("Cégeknek - Failed");
                }

                //Chrome bezárása
                driver.quit();

            }
        }
