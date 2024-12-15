package Test_Executions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Customer_Process_Test_Case {
    public static void main(String[] args)
    {

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        long timer= System.currentTimeMillis();
        System.out.println("Test Started\n ------------------------------------\n");

        //Weblap megnyitása
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver.get("https://www.mediamarkt.hu");
        System.out.println("Weblap megnyitása - Passed");


        //Cookie-k elfogadása
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//button[@class=\"gdpr-cookie-layer__btn gdpr-cookie-layer__btn--submit gdpr-cookie-layer__btn--submit--all\"]"))).click();
        System.out.println("Cookie-k elfogadása - Passed");

        //Belépés opció kiválasztása fent
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//*[@id=\"header\"]/header/div[1]/div/div[4]/nav/div/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/header/div[1]/div/div[4]/nav/div/div/ul/li[1]/a"))).click();
        System.out.println("Belépés opció kiválasztása fent - Passed");

        //Email és jelszó megadása
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-email\"]"))).sendKeys(User_info.email_address);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-password\"]"))).sendKeys(User_info.password);
        System.out.println("Email és jelszó megadása - Passed");

        // Belépés gomb megnyomása
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"my-account-action-login\"]"))).click();
        System.out.println("Belépés gomb megnyomása - Passed");

        //Keresősávban laptop megadása és keresés
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search-phrase\"]"))).sendKeys("laptop");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"site-search-submit\"]"))).click();
        System.out.println("Keresősávban laptop megadása és keresés - Passed");

        //Első filter beállítás - raktáron
        WebElement filter1 =driver.findElement(By.xpath("//*[@id=\"filters\"]/form/fieldset[5]/div[2]/ul/li[1]/label/input"));
        while (!filter1.isDisplayed()) {
            js.executeScript("window.scrollBy(0, 400)");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        js.executeScript("window.scrollBy(0, 200)");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Raktáron \"]/../input"))).click();
        System.out.println("Első filter beállítás - raktáron - Passed");

        //Második filter beállítás - ASUS
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"ASUS \"]/../input"))).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Második filter beállítás - ASUS - Passed");

        //Kosárba rakás, majd kosár megtekintése
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()=\"Kosárba\"]/..)[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"basket-flyout-cart\"]"))).click();
        System.out.println("Kosárba rakás, majd kosár megtekintése - Passed");

        //Eltávolítás a kosárból
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"js-cart-app\"]/div[4]/table/tbody[2]/tr[1]/td[3]/div/button"))).click();
        System.out.println("Eltávolítás a kosárból - Passed");

        //Vissza a főoldalra
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"logo\"]/a"))).click();
        System.out.println("Vissza a főoldalra - Passed");

        //Kijelentkezés
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//*[@id=\"header\"]/header/div[1]/div/div[4]/nav/div/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//*[@id=\"header\"]/header/div[1]/div/div[4]/nav/div/div/ul/li[1]/a"))).click();
        System.out.println("Kijelentkezés - Passed");

        //Futási idő számítása
        System.out.println("\n------------------------------------\nExecution time: " + ((System.currentTimeMillis() - timer) / 1000) + " seconds");

        //Chrome bezárása
        driver.quit();
        }
    }
