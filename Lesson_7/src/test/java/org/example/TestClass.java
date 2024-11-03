package org.example;

import org.PaymentPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
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

import java.time.Duration;

import static io.qameta.allure.Allure.step;

@ExtendWith(AllureListener.class)
class TestClass {
    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        step("Подготовка драйвера Chrome");
    }

    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setupTest() {
        step("Открыть главную страницу");
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
        step("Закрыть окно браузера");
        driver.quit();
    }

    @Test
    @Description("Тест проверяет корректность отображения заголовка.")
    void testTitle() {
        step("Получить текст заголовка и сверить его правильность отображения");
        String expectedTitle = "Онлайн пополнение\n" + "без комиссии";
        String actualTitle = mainPage.getTitleBlockText();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    @Description("Тест проверяет корректность отображения изображений платежных систем.")
    public void testImage() {
        step("Сверить наличие отображения изображений платежных систем");
        String[] expectedAlts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (String expectedAlt : expectedAlts) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='" + expectedAlt + "']")));
                assert (imageElement.isDisplayed());
            } catch (TimeoutException e) {
                System.out.println("Изображение '" + expectedAlt + "' отсутствует.");
            }
        }
    }

    @Test
    @Description("Тест проверяет корректность перехода на страницу информации о порядке оплаты.")

    public void testUrlInfoServis() {
        step("Проверить переход на страницу информации о порядке оплаты");
        mainPage.clickOnInfoServiceLink();
        String currentUrl = driver.getCurrentUrl();
        Allure.addAttachment("Текущий URL", currentUrl);
        Assertions.assertEquals(currentUrl, "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", "URL страницы соответствует ожидаемому");
    }

    @Test
    @Description("Тест проверяет корректность заполнения полей и отображение полей во фрейме.")
    public void testPay() {
        fillPhoneNumberField();
        fillSumField();
        fillEmailField();
        submitPaymentForm();
        switchToBepaidFrameAndWaitForPayTitle();
        checkIfPaymentTitleIsVisible();
        verifyPayDescriptionCost();
        verifyColoredDisabledButtonText();
        verifyPayDescriptionText();
        verifyNumberCardText();
        verifyValidityPeriodText();
        verifyCvcText();
        verifyNamePersonText();
        checkIfVisaLogoDisplayed();
        checkIfMastercardLogoDisplayed();
        checkIfBelkartLogoDisplayed();
    }

    public void fillPhoneNumberField() {
        step("Заполнить поле 'Номер телефона'");
        mainPage.fillPhoneNumber("297777777");
    }


    public void fillSumField() {
        step("Заполнить поле 'Сумма'");
        mainPage.fillSum("100");

    }


    public void fillEmailField() {
        step("Заполнить поле 'Электронная почта'");
        mainPage.fillEmail("Natuwka611@gmail.com");
    }


    public void submitPaymentForm() {
        step("Отправить форму платежа");
        mainPage.submitPaymentForm();
    }


    public void switchToBepaidFrameAndWaitForPayTitle() {
        step("Переключиться на iframe Bepaid и дождаться появления заголовка");
        paymentPage.switchToBepaidFrame();
        paymentPage.waitPayTitle();
    }


    public void checkIfPaymentTitleIsVisible() {
        step("Проверить видимость заголовка платежа");
        assert (paymentPage.isPaymentTitleVisible());
    }


    public void verifyPayDescriptionCost() {
        step("Проверить правильность отображения стоимости в описании платежа");
        String expectedpayDescriptionCost = "100.00 BYN";
        String actualpayDescriptionCost = paymentPage.getPayDescriptionCostText();
        Allure.addAttachment("Фактическое отображение суммы", actualpayDescriptionCost);
        Assertions.assertEquals(expectedpayDescriptionCost, actualpayDescriptionCost);
    }


    public void verifyColoredDisabledButtonText() {
        step("Проверить текст на кнопке 'Оплатить'");
        String expectedColoredDisabled = "Оплатить 100.00 BYN";
        String actualColoredDisabled = paymentPage.getColoredDisabledText();
        Allure.addAttachment("Фактическое отображение кнопки с суммой", actualColoredDisabled);
        Assertions.assertEquals(expectedColoredDisabled, actualColoredDisabled);
    }


    public void verifyPayDescriptionText() {
        step("Проверить текст описания платежа");
        String expectedPayDescriptionText = "Оплата: Услуги связи Номер:375297777777";
        String actualPayDescriptionText = paymentPage.getPayDescriptionTextText();
        Allure.addAttachment("Фактическое отображение оплаты", actualPayDescriptionText);
        Assertions.assertEquals(expectedPayDescriptionText, actualPayDescriptionText);
    }


    public void verifyNumberCardText() {
        step("Проверить текст поля 'Номер карты'");
        String expectedNumberCart = "Номер карты";
        String actualNumberCart = paymentPage.getNumberCartText();
        Allure.addAttachment("Фактическое отображение надписи номер карты", actualNumberCart);
        Assertions.assertEquals(expectedNumberCart, actualNumberCart);
    }


    public void verifyValidityPeriodText() {
        step("Проверить текст поля 'Срок действия'");
        String expectedValidityPeriod = "Срок действия";
        String actualValidityPeriod = paymentPage.getValidityPeriodText();
        Allure.addAttachment("Фактическое отображение надписи срок действия", actualValidityPeriod);
        Assertions.assertEquals(expectedValidityPeriod, actualValidityPeriod);
    }


    public void verifyCvcText() {
        step("Проверить текст поля 'CVC'");
        String expectedCvc = "CVC";
        String actualCvc = paymentPage.getCvcText();
        Allure.addAttachment("Фактическое отображение CVC", actualCvc);
        Assertions.assertEquals(expectedCvc, actualCvc);
    }


    public void verifyNamePersonText() {
        step("Проверить текст поля 'Имя держателя'");
        String expectedNamePerson = "Имя держателя (как на карте)";
        String actualNamePerson = paymentPage.getNamePersonText();
        Allure.addAttachment("Фактическое отображение имени держателя", actualNamePerson);
        Assertions.assertEquals(expectedNamePerson, actualNamePerson);
    }


    public void checkIfVisaLogoDisplayed() {
        step("Проверить наличие логотипа Visa");
        paymentPage.displayedVisa();
    }


    public void checkIfMastercardLogoDisplayed() {
        step("Проверить наличие логотипа Mastercard");
        paymentPage.displayedMastercard();
    }


    public void checkIfBelkartLogoDisplayed() {
        step("Проверить наличие логотипа Belkart");
        paymentPage.displayedBelkart();
    }

    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Услуги связи")

    public void testCommunicationServices() {
        step("Выбрать Услуги связи");
        mainPage.paySectionFormClick();
        mainPage.communicationServicesClick();
        testPaymentOptionsPhone();
        testPaymentOptionsSum();
        testPaymentOptionsEmail();
    }

    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Домашний интернет")

    public void testHomeInternet() {
        step("Выбрать Домашний интернет");
        mainPage.paySectionFormClick();
        mainPage.homeInternetClick();
        testPaymentOptionsPhone();
        testPaymentOptionsSum();
        testPaymentOptionsEmail();
    }

    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Рассрочка")
    public void testInstallment() {
        step("Выбрать Рассрочка");
        mainPage.paySectionFormClick();
        mainPage.installmentClick();
        testPaymentOptionsScoreInstalment();
        testPaymentOptionsSum();
        testPaymentOptionsEmail();
    }

    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Задолженность")

    public void testArrears() {
        step("Выбрать Задолженность");
        mainPage.paySectionFormClick();
        mainPage.arrearsClick();
        testPaymentOptionsScoreArrears();
        testPaymentOptionsSum();
        testPaymentOptionsEmail();
    }


    public void testPaymentOptionsSum() {
        step("Проверить отображение поля сумма");
        String expectedSumField = "Сумма";
        String actualSumField = mainPage.getSum();
        Allure.addAttachment("Фактическое отображение поля сумма", actualSumField);
        Assertions.assertEquals(expectedSumField, actualSumField);
    }


    public void testPaymentOptionsEmail() {
        step("Проверить отображение поля Email");
        String expectedEmailField = "E-mail для отправки чека";
        String actualEmailField = mainPage.getEmail();
        Allure.addAttachment("Фактическое отображение поля Email", actualEmailField);
        Assertions.assertEquals(expectedEmailField, actualEmailField);
    }


    public void testPaymentOptionsPhone() {
        step("Проверить отображение поля номера телефона");
        String expectedPhoneField = "Номер телефона";
        String actualPhoneField = mainPage.getPhone();
        Allure.addAttachment("Фактическое отображение номера телефона", actualPhoneField);
        Assertions.assertEquals(expectedPhoneField, actualPhoneField);
    }


    public void testPaymentOptionsScoreInstalment() {
        step("Проверить отображение поля номер счета на 44");
        String expectedScoreInstalment = "Номер счета на 44";
        String actualScoreInstalment = mainPage.getScoreInstalment();
        Allure.addAttachment("Фактическое отображение номер счета на 44", actualScoreInstalment);
        Assertions.assertEquals(expectedScoreInstalment, actualScoreInstalment);
    }

    public void testPaymentOptionsScoreArrears() {
        step("Проверить отображение поля номер счета на 2073");
        String expectedScoreArrears = "Номер счета на 2073";
        String actualScoreArrears = mainPage.getScoreArrears();
        Allure.addAttachment("Фактическое отображение номер счета на 2073", actualScoreArrears);
        Assertions.assertEquals(expectedScoreArrears, actualScoreArrears);
    }
}