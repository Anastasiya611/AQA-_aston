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
    @Step("Открыть окно")
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
    @Step("Закрыть окно")
    void teardown() {
        driver.quit();
    }

    @Test
    @Epic("Проверка заголовка")
    @Description("Тест проверяет корректность отображения заголовка.")
    @Step("Получить текст заголовка и сверить его правильность отображения")
    void testTitle() {
        String expectedTitle = "Онлайн пополнение\n" + "без комиссии";
        String actualTitle = mainPage.getTitleBlockText();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    @Epic ("Отображение изображений платежных систем" +
            "")
    @Description("Тест проверяет корректность отображения изображений платежных систем.")
    @Step("Сверить наличие отображения изображений платежных систем")
    public void testImage() {
        String[] expectedAlts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (String expectedAlt : expectedAlts) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='" + expectedAlt + "']")));
                assert (imageElement.isDisplayed());
            } catch (TimeoutException e) {
                System.out.println("Изображение '" + expectedAlt + "' отсутствует.");
            }
        }
    }

    @Test
    @Epic("Проверка ссылок на информационные сервисы")
    @Description("Тест проверяет корректность перехода на страницу информации о порядке оплаты.")
    @Step("Проверить переход на страницу информации о порядке оплаты")
    public void testUrlInfoServis() {
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

    @Step("Заполнить поле 'Номер телефона'")
    public void fillPhoneNumberField() {
        mainPage.fillPhoneNumber("297777777");
    }

    @Step("Заполнить поле 'Сумма'")
    public void fillSumField() {
        mainPage.fillSum("100");
    }

    @Step("Заполнить поле 'Электронная почта'")
    public void fillEmailField() {
        mainPage.fillEmail("Natuwka611@gmail.com");
    }

    @Step("Отправить форму платежа")
    public void submitPaymentForm() {
        mainPage.submitPaymentForm();
    }

    @Step("Переключиться на iframe Bepaid и дождаться появления заголовка")
    public void switchToBepaidFrameAndWaitForPayTitle() {
        paymentPage.switchToBepaidFrame();
        paymentPage.waitPayTitle();
    }

    @Step("Проверить видимость заголовка платежа")
    public void checkIfPaymentTitleIsVisible() {
        assert (paymentPage.isPaymentTitleVisible());
    }

    @Step("Проверить правильность отображения стоимости в описании платежа")
    public void verifyPayDescriptionCost() {
        String expectedpayDescriptionCost = "100.00 BYN";
        String actualpayDescriptionCost = paymentPage.getPayDescriptionCostText();
        Allure.addAttachment("Фактическое отображение суммы", actualpayDescriptionCost);
        Assertions.assertEquals(expectedpayDescriptionCost, actualpayDescriptionCost);
    }

    @Step("Проверить текст на кнопке 'Оплатить'")
    public void verifyColoredDisabledButtonText() {
        String expectedColoredDisabled = "Оплатить 100.00 BYN";
        String actualColoredDisabled = paymentPage.getColoredDisabledText();
        Allure.addAttachment("Фактическое отображение кнопки с суммой", actualColoredDisabled);
        Assertions.assertEquals(expectedColoredDisabled, actualColoredDisabled);
    }

    @Step("Проверить текст описания платежа")
    public void verifyPayDescriptionText() {
        String expectedPayDescriptionText = "Оплата: Услуги связи Номер:375297777777";
        String actualPayDescriptionText = paymentPage.getPayDescriptionTextText();
        Allure.addAttachment("Фактическое отображение оплаты", actualPayDescriptionText);
        Assertions.assertEquals(expectedPayDescriptionText, actualPayDescriptionText);
    }

    @Step("Проверить текст поля 'Номер карты'")
    public void verifyNumberCardText() {
        String expectedNumberCart = "Номер карты";
        String actualNumberCart = paymentPage.getNumberCartText();
        Allure.addAttachment("Фактическое отображение надписи номер карты", actualNumberCart);
        Assertions.assertEquals(expectedNumberCart, actualNumberCart);
    }

    @Step("Проверить текст поля 'Срок действия'")
    public void verifyValidityPeriodText() {
        String expectedValidityPeriod = "Срок действия";
        String actualValidityPeriod = paymentPage.getValidityPeriodText();
        Allure.addAttachment("Фактическое отображение надписи срок действия", actualValidityPeriod);
        Assertions.assertEquals(expectedValidityPeriod, actualValidityPeriod);
    }

    @Step("Проверить текст поля 'CVC'")
    public void verifyCvcText() {
        String expectedCvc = "CVC";
        String actualCvc = paymentPage.getCvcText();
        Allure.addAttachment("Фактическое отображение CVC", actualCvc);
        Assertions.assertEquals(expectedCvc, actualCvc);
    }

    @Step("Проверить текст поля 'Имя держателя'")
    public void verifyNamePersonText() {
        String expectedNamePerson = "Имя держателя (как на карте)";
        String actualNamePerson = paymentPage.getNamePersonText();
        Allure.addAttachment("Фактическое отображение имени держателя", actualNamePerson);
        Assertions.assertEquals(expectedNamePerson, actualNamePerson);
    }

    @Step("Проверить наличие логотипа Visa")
    public void checkIfVisaLogoDisplayed() {
        paymentPage.displayedVisa();
    }

    @Step("Проверить наличие логотипа Mastercard")
    public void checkIfMastercardLogoDisplayed() {
        paymentPage.displayedMastercard();
    }

    @Step("Проверить наличие логотипа Belkart")
    public void checkIfBelkartLogoDisplayed() {
        paymentPage.displayedBelkart();
    }


    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Услуги связи")
    @Step("Выбрать Услуги связи")
    public void testCommunicationServices() {
        mainPage.paySectionFormClick();
        mainPage.communicationServicesClick();
        testPaymentOptionsPhone();
        testPaymentOptionsSum();
        testPaymentOptionsEmail();
    }

    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Домашний интернет")
    @Step("Выбрать Домашний интернет")
    public void testHomeInternet() {
        mainPage.paySectionFormClick();
        mainPage.homeInternetClick();
        testPaymentOptionsPhone();
        testPaymentOptionsSum();
        testPaymentOptionsEmail();
    }

    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Рассрочка")
    @Step("Выбрать Услуги связи")
    public void testInstallment() {
        mainPage.paySectionFormClick();
        mainPage.installmentClick();
        testPaymentOptionsScoreInstalment();
        testPaymentOptionsSum();
        testPaymentOptionsEmail();
    }

    @Test
    @Description("Тест проверяет корректность отображения полей при выборе Задолженность")
    @Step("Выбрать Услуги связи")
    public void testArrears() {
        mainPage.paySectionFormClick();
        mainPage.arrearsClick();
        testPaymentOptionsScoreArrears();
        testPaymentOptionsSum();
        testPaymentOptionsEmail();
    }

    @Step("Проверить отображение поля сумма ")
    public void testPaymentOptionsSum() {

        String expectedSumField = "Сумма";
        String actualSumField = mainPage.getSum();
        Allure.addAttachment("Фактическое отображение поля сумма", actualSumField);
        Assertions.assertEquals(expectedSumField, actualSumField);
    }
    @Step("Проверить отображение поля Email ")
    public void testPaymentOptionsEmail() {
        String expectedEmailField = "E-mail для отправки чека";
        String actualEmailField = mainPage.getEmail();
        Allure.addAttachment("Фактическое отображение поля Email", actualEmailField);
        Assertions.assertEquals(expectedEmailField, actualEmailField);
    }
    @Step("Проверить отображение поля номера телефона ")
    public void testPaymentOptionsPhone() {
        String expectedPhoneField = "Номер телефона";
        String actualPhoneField = mainPage.getPhone();
        Allure.addAttachment("Фактическое отображение номера телефона", actualPhoneField);
        Assertions.assertEquals(expectedPhoneField, actualPhoneField);
    }
    @Step("Проверить отображение поля номер счета на 44 ")
    public void testPaymentOptionsScoreInstalment() {
        String expectedScoreInstalment = "Номер счета на 44";
        String actualScoreInstalment = mainPage.getScoreInstalment();
        Allure.addAttachment("Фактическое отображение номер счета на 44", actualScoreInstalment);
        Assertions.assertEquals(expectedScoreInstalment, actualScoreInstalment);
    }
    @Step("Проверить отображение поля номер счета на 2073 ")
    public void testPaymentOptionsScoreArrears() {
        String expectedScoreArrears = "Номер счета на 2073";
        String actualScoreArrears = mainPage.getScoreArrears();
        Allure.addAttachment("Фактическое отображение номер счета на 2073", actualScoreArrears);
        Assertions.assertEquals(expectedScoreArrears, actualScoreArrears);
    }
}