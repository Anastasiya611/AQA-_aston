package org.example;

import org.PaymentPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.MainPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;


class TestClass {
    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        mainPage = new MainPage(driver);
        paymentPage = new PaymentPage(driver);

        mainPage.acceptCookiesIfPresent();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    @Epic("Проверка заголовка")
    @Description("Тест проверяет корректность отображения заголовка.")
    void testTitle() {
        String expectedTitle = "Онлайн пополнение\n" + "без комиссии";
        String actualTitle = mainPage.getTitleBlockText();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    @Description("Тест проверяет корректность отображения изображений платежных систем.")
    public void testImage() {
        String[] expectedAlts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (String expectedAlt : expectedAlts) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='" + expectedAlt + "']")));
                assert (imageElement.isDisplayed());
                  //  System.out.println("Изображение '" + expectedAlt + "' присутствует на странице.");
            } catch (TimeoutException e) {
                System.out.println("Изображение '" + expectedAlt + "' отсутствует.");
            }
        }
    }

    @Test
    @Epic("Проверка ссылок на информационные сервисы")
    @Description("Тест проверяет корректность перехода на страницу информации о порядке оплаты.")
    public void testUrlInfoServis() {
    mainPage.clickOnInfoServiceLink();

    String currentUrl = driver.getCurrentUrl();

            Allure.addAttachment("Текущий URL", currentUrl);

            Assertions.assertEquals(currentUrl, "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", "URL страницы соответствует ожидаемому");
        }

    @Test
    @Description("Тест проверяет корректность заполнения полей и отображение полей во фрейме.")
    public void testPay() {
        mainPage.fillPhoneNumber("297777777");
        mainPage.fillSum("100");
        mainPage.fillEmail("Natuwka611@gmail.com");
        mainPage.submitPaymentForm();


        paymentPage.switchToBepaidFrame();
        paymentPage.waitPayTitle();


        assert (paymentPage.isPaymentTitleVisible()); {
        }

        String expectedpayDescriptionCost = "100.00 BYN";
        String actualpayDescriptionCost = paymentPage.getPayDescriptionCostText();
        Allure.addAttachment("Фактическое отображение суммы", actualpayDescriptionCost);
        Assertions.assertEquals(expectedpayDescriptionCost, actualpayDescriptionCost);


        String expectedColoredDisabled = "Оплатить 100.00 BYN";
        String actualColoredDisabled = paymentPage.getColoredDisabledText();
        Allure.addAttachment("Фактическое отображение кнопки с суммой", actualColoredDisabled);
        Assertions.assertEquals(expectedColoredDisabled, actualColoredDisabled);


        String expectedPayDescriptionText = "Оплата: Услуги связи Номер:375297777777";
        String actualPayDescriptionText = paymentPage.getPayDescriptionTextText();
        Allure.addAttachment("Фактическое отображение оплаты", actualColoredDisabled);
        Assertions.assertEquals(expectedPayDescriptionText, actualPayDescriptionText);


        String expectedNumberCart = "Номер карты";
        String actualNumberCart = paymentPage.getNumberCartText();
        Allure.addAttachment("Фактическое отображение надписи номер карты", actualNumberCart);
        Assertions.assertEquals(expectedNumberCart, actualNumberCart);


        String expectedValidityPeriod = "Срок действия";
        String actualValidityPeriod = paymentPage.getValidityPeriodText();
        Allure.addAttachment("Фактическое отображение надписи срок действия", actualValidityPeriod);
        Assertions.assertEquals(expectedValidityPeriod, actualValidityPeriod);


        String expectedCvc = "CVC";
        String actualCvc = paymentPage.getCvcText();
        Allure.addAttachment("Фактическое отображение cvc", actualCvc);
        Assertions.assertEquals(expectedCvc, actualCvc);


        String expectedNamePerson = "Имя держателя (как на карте)";
        String actualNamePerson = paymentPage.getNamePersonText();
        Allure.addAttachment("Фактическое отображение имени держателя", actualNamePerson);
        Assertions.assertEquals(expectedNamePerson, actualNamePerson);

        paymentPage.displayedVisa();
        paymentPage.displayedMastercard();
        paymentPage.displayedBelkart();
    }

    public void testPaymentOptions() {

        String expectedSumField = "Сумма";
        String actualSumField = mainPage.getSum();
        Allure.addAttachment("Фактическое отображение поля сумма", actualSumField);
        Assertions.assertEquals(expectedSumField, actualSumField);

        String expectedEmailField = "E-mail для отправки чека";
        String actualEmailField = mainPage.getEmail();
        Allure.addAttachment("Фактическое отображение поля Email", actualEmailField);
        Assertions.assertEquals(expectedEmailField, actualEmailField);

    }

    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Услуги связи")

    public void testCommunicationServices() {
        mainPage.paySectionFormClick();
        mainPage.communicationServicesClick();
        String expectedPhoneField = "Номер телефона";
        String actualPhoneField = mainPage.getPhone();
        Allure.addAttachment("Фактическое отображение номера телефона", actualPhoneField);
        Assertions.assertEquals(expectedPhoneField, actualPhoneField);
       testPaymentOptions();
    }

    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Домашний интернет")
    public void testHomeInternet() {
        mainPage.paySectionFormClick();
        mainPage.homeInternetClick();
        String expectedPhoneField = "Номер телефона";
        String actualPhoneField = mainPage.getPhone();
        Allure.addAttachment("Фактическое отображение кнопки с суммой", actualPhoneField);
        Assertions.assertEquals(expectedPhoneField, actualPhoneField);
        testPaymentOptions();
    }

    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Рассрочка")
    public void testInstallment() {
        mainPage.paySectionFormClick();
        mainPage.installmentClick();
        String expectedScoreInstalment = "Номер счета на 44";
        String actualScoreInstalment = mainPage.getScoreInstalment();
        Allure.addAttachment("Фактическое отображение номер счета на 44", actualScoreInstalment);
        Assertions.assertEquals(expectedScoreInstalment, actualScoreInstalment);
        testPaymentOptions();
    }

    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Задолженность")
    public void testArrears() {
        mainPage.paySectionFormClick();
        mainPage.arrearsClick();
        String expectedScoreArrears = "Номер счета на 2073";
        String actualScoreArrears = mainPage.getScoreArrears();
        Allure.addAttachment("Фактическое отображение номер счета на 2073", actualScoreArrears);
        Assertions.assertEquals(expectedScoreArrears, actualScoreArrears);
        testPaymentOptions();
    }
}