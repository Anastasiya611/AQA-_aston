package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.MainPage;
import org.example.PaymentPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class TestClass {
    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        mainPage = new MainPage(driver);
        paymentPage = new PaymentPage(driver);

        mainPage.acceptCookiesIfPresent();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testTitle() {
        String expectedTitle = "Онлайн пополнение\n" + "без комиссии";
        String actualTitle = mainPage.getTitleBlockText();
        Assertions.assertEquals(expectedTitle, actualTitle);
        System.out.println("Заголовок верный");
    }

    @Test
    public void testImage() {
        String[] expectedAlts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (String expectedAlt : expectedAlts) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 10);
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
        mainPage.clickOnInfoServiceLink();
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/")) {
            System.out.println("Ссылка работает.");
        } else {
            System.out.println("Ссылка не работает.");
        }
    }

    @Test
    public void testPay() {
        mainPage.fillPhoneNumber("297777777");
        mainPage.fillSum("100");
        mainPage.fillEmail("Natuwka611@gmail.com");
        mainPage.submitPaymentForm();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPage.bepaidIframe));
        paymentPage.switchToBepaidFrame();

        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPage.payTitle));

        if (paymentPage.isPaymentTitleVisible()) {
            System.out.println("Кнопка работает.");
        }

        String expectedpayDescriptionCost = "100.00 BYN";
        String actualpayDescriptionCost = paymentPage.getPayDescriptionCostText();
        Assertions.assertEquals(expectedpayDescriptionCost, actualpayDescriptionCost);
        System.out.println("Отображение 100.00 BYN верно");

        String expectedColoredDisabled = "Оплатить 100.00 BYN";
        String actualColoredDisabled = paymentPage.getColoredDisabledText();
        Assertions.assertEquals(expectedColoredDisabled, actualColoredDisabled);
        System.out.println("Отображение Оплатить 100.00 BYN верно");

        String expectedPayDescriptionText = "Оплата: Услуги связи Номер:375297777777";
        String actualPayDescriptionText = paymentPage.getPayDescriptionTextText();
        Assertions.assertEquals(expectedPayDescriptionText, actualPayDescriptionText);
        System.out.println("Отображение Номер:375297777777 верно");

        String expectedNumberCart = "Номер карты";
        String actualNumberCart = paymentPage.getNumberCartText();
        Assertions.assertEquals(expectedNumberCart, actualNumberCart);
        System.out.println("Отображение Номер карты верно");

        String expectedValidityPeriod = "Срок действия";
        String actualValidityPeriod = paymentPage.getValidityPeriodText();
        Assertions.assertEquals(expectedValidityPeriod, actualValidityPeriod);
        System.out.println("Отображение Срок действия верно");

        String expectedCvc = "CVC";
        String actualCvc = paymentPage.getCvcText();
        Assertions.assertEquals(expectedCvc, actualCvc);
        System.out.println("Отображение CVC верно");

        String expectedNamePerson = "Имя держателя (как на карте)";
        String actualNamePerson = paymentPage.getNamePersonText();
        Assertions.assertEquals(expectedNamePerson, actualNamePerson);
        System.out.println("Отображение Имя держателя верно");

        paymentPage.displayedVisa();
        paymentPage.displayedMastercard();
        paymentPage.displayedBelkart();
    }

    @Test
    public void testCommunicationServices() {
        mainPage.paySectionFormClick();
        mainPage.communicationServicesClick();
        String expectedPhoneField = "Номер телефона";
        String actualPhoneField = mainPage.getPhone();
        Assertions.assertEquals(expectedPhoneField, actualPhoneField);
        System.out.println("Отображение Номер телефона верно");
        mainPage.testPaymentOptions();
    }

    @Test
    public void testHomeInternet() {
        mainPage.paySectionFormClick();
        mainPage.homeInternetClick();
        String expectedPhoneField = "Номер телефона";
        String actualPhoneField = mainPage.getPhone();
        Assertions.assertEquals(expectedPhoneField, actualPhoneField);
        System.out.println("Отображение Номер телефона верно");
        mainPage.testPaymentOptions();
    }

    @Test
    public void testInstallment() {
        mainPage.paySectionFormClick();
        mainPage.installmentClick();
        String expectedScoreInstalment = "Номер счета на 44";
        String actualScoreInstalment = mainPage.getScoreInstalment();
        Assertions.assertEquals(expectedScoreInstalment, actualScoreInstalment);
        System.out.println("Отображение Номер счета на 44 верно");
        mainPage.testPaymentOptions();
    }

    @Test
    public void testArrears() {
        mainPage.paySectionFormClick();
        mainPage.arrearsClick();
        String expectedScoreArrears = "Номер счета на 2073";
        String actualScoreArrears = mainPage.getScoreArrears();
        Assertions.assertEquals(expectedScoreArrears, actualScoreArrears);
        System.out.println("Отображение Номер счета на 44 верно");
        mainPage.testPaymentOptions();
    }
}