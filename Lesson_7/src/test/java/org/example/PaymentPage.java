package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    By bepaidIframe = By.className("bepaid-iframe");
    By payTitle = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label");
    By payDescriptionCost = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/span[1]");
    By coloredDisabled = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button");
    By payDescriptionText = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]");
    By numberCart = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label");
    By validityPeriod = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label");
    By cvc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label");
    By namePerson = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label");
    By visaPay = By.cssSelector(("img[src=\"assets/images/payment-icons/card-types/visa-system.svg\"]"));
    By mastercardPay = By.cssSelector(("img[src=\"assets/images/payment-icons/card-types/mastercard-system.svg\"]"));
    By belkartPay = By.cssSelector(("img[src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]"));

    public boolean isPaymentTitleVisible() {
        return driver.findElement(payTitle).isDisplayed();
    }

    public void switchToBepaidFrame() {
        WebElement frame = driver.findElement(bepaidIframe);
        driver.switchTo().frame(frame);
    }

    public String getPayDescriptionCostText() {
        WebElement elementPayDescriptionCost = driver.findElement(payDescriptionCost);
        return elementPayDescriptionCost.getText();
    }

    public String getColoredDisabledText() {
        WebElement elementColoredDisabled = driver.findElement(coloredDisabled);
        return elementColoredDisabled.getText();
    }

    public String getPayDescriptionTextText() {
        WebElement elementPayDescriptionText = driver.findElement(payDescriptionText);
        return elementPayDescriptionText.getText();
    }

    public String getNumberCartText() {
        WebElement elementNumberCart = driver.findElement(numberCart);
        return elementNumberCart.getText();
    }

    public String getValidityPeriodText() {
        WebElement elementValidityPeriod = driver.findElement(validityPeriod);
        return elementValidityPeriod.getText();
    }

    public String getCvcText() {
        WebElement elementCvc = driver.findElement(cvc);
        return elementCvc.getText();
    }

    public String getNamePersonText() {
        WebElement elementNamePerson = driver.findElement(namePerson);
        return elementNamePerson.getText();
    }

    public void displayedVisa() {
        WebElement elementVisa = driver.findElement(visaPay);
        if (elementVisa.isDisplayed()) {
            System.out.println("Изображение Visa присутствует на странице.");
        }
    }

    public void displayedMastercard() {
        WebElement elementMastercard = driver.findElement(mastercardPay);
        if (elementMastercard.isDisplayed()) {
            System.out.println("Изображение Mastercard присутствует на странице.");
        }
    }

    public void displayedBelkart() {
        WebElement elementBelkart = driver.findElement(belkartPay);
        if (elementBelkart.isDisplayed()) {
            System.out.println("Изображение Belkart присутствует на странице.");
        }
    }
}