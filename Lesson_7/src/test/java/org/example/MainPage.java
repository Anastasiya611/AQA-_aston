package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "cookie-agree")
    private WebElement cookieAgreeButton;

    @FindBy(css = "#pay-section > div > div > div.col-12.col-xl-8 > section > div > h2")
    private WebElement titleBlock;

    @FindBy(xpath = "//*[@id='pay-section']/div/div/div[2]/section/div/a")
    private WebElement infoServiceLink;

    @FindBy(id = "connection-phone")
    private WebElement phoneInputField;

    @FindBy(id = "score-instalment")
    private WebElement scoreInstalment;

    @FindBy(id = "score-arrears")
    private WebElement scoreArrears;

    @FindBy(id = "connection-sum")
    private WebElement sumInputField;

    @FindBy(id = "connection-email")
    private WebElement emailInputField;

    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
    private WebElement paymentButton;

    @FindBy(className = "select__header")
    private WebElement paySection;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")
    private WebElement communicationServices;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p")
    private WebElement homeInternet;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p")
    private WebElement installment;
    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p")
    private WebElement arrears;


    // Конструктор класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void acceptCookiesIfPresent() {
        if (cookieAgreeButton.isDisplayed()) {
            cookieAgreeButton.click();
        }
    }

    public String getTitleBlockText() {
        return titleBlock.getText();
    }

    public String getPhone() {
        String placeholderPhone = phoneInputField.getAttribute("placeholder");
        return placeholderPhone;
    }

    public String getScoreInstalment() {
        String placeholderScoreInstalment = scoreInstalment.getAttribute("placeholder");
        return placeholderScoreInstalment;
    }

    public String getScoreArrears() {
        String placeholderScoreArrears = scoreArrears.getAttribute("placeholder");
        return placeholderScoreArrears;
    }

    public String getSum() {
        String placeholderSum = sumInputField.getAttribute("placeholder");
        return placeholderSum;
    }

    public String getEmail() {
        String placeholderEmail = emailInputField.getAttribute("placeholder");
        return placeholderEmail;
    }

    public void clickOnInfoServiceLink() {
        infoServiceLink.click();
    }

    public void fillPhoneNumber(String number) {
        phoneInputField.sendKeys(number);
    }

    public void fillSum(String amount) {
        sumInputField.sendKeys(amount);
    }

    public void fillEmail(String email) {
        emailInputField.sendKeys(email);
    }

    public void submitPaymentForm() {
        paymentButton.click();
    }

    public void paySectionFormClick() {
        paySection.click();
    }

    public void communicationServicesClick() {
        communicationServices.click();
    }

    public void homeInternetClick() {
        homeInternet.click();
    }

    public void installmentClick() {
        installment.click();
    }

    public void arrearsClick() {
        arrears.click();
    }

    public void testPaymentOptions() {

        String expectedSumField = "Сумма";
        String actualSumField = getSum();
        Assertions.assertEquals(expectedSumField, actualSumField);
        System.out.println("Отображение Сумма верно");

        String expectedEmailField = "E-mail для отправки чека";
        String actualEmailField = getEmail();
        Assertions.assertEquals(expectedEmailField, actualEmailField);
        System.out.println("Отображение Email верно");

    }


}



