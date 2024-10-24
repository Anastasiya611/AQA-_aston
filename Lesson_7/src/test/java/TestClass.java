import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
        WebElement cookie = driver.findElement(By.id("cookie-agree"));
           if (cookie.isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testTitle() {
        WebElement blockTitle = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > h2"));
        String expectedTitle = "Онлайн пополнение\n" + "без комиссии";
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
        } else {
            System.out.println("Ссылка не работает.");
        }
    }

    @Test
    public void testPay() {
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("100");
        driver.findElement(By.id("connection-email")).sendKeys("Natuwka611@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, (10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));
        WebElement frame = driver.findElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label")));
       WebElement payTitle = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label"));
       if (payTitle.isDisplayed()) {
            System.out.println("Кнопка работает.");
            }
    }
}


