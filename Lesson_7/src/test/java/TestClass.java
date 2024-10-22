import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class TestClass {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.findElement(By.id("cookie-agree")).click();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testTitle() {
        // Exercise

        WebElement blockTitle = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > h2"));
        String expectedTitle = "Онлайн пополнение\n" +
                "без комиссии";
        Assertions Assert = null;
        Assert.assertEquals(expectedTitle, blockTitle.getText());
    }

    @Test
    public void testImage() {
        String[] expectedAlts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};

        WebDriverWait wait = new WebDriverWait(driver, 10);

        for (String expectedAlt : expectedAlts) {
            try {
                WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='" + expectedAlt + "']")));
                if (imageElement.isDisplayed()) {
                    System.out.println("Изображение '" + expectedAlt + "' присутствует на странице.");
                }
            } catch (TimeoutException e) {
                System.out.println("Изображение '" + expectedAlt + "' отсутствует.");
            }
        }
    }

    @Test
    public void testUrlInfoServis() {

            driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/")) {
            System.out.println("Ссылка работает.");
        }
        else {
            System.out.println("Ссылка не работает.");
        }
        }
    @Test
    public void testPhoneSumEmail() {
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("100");
        driver.findElement(By.id("connection-email")).sendKeys("Natuwka611@gmail.com");
        driver.findElement(By.id("pay-connection")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        String urlPay = driver.getCurrentUrl();
        if (urlPay.contains("https://www.mts.by/")) {
            System.out.println("Кнопка работает.");
        }
        else {
            System.out.println("Кнопка не работает.");
        }
    }
}
