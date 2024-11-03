package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    By payTitle = By.className("ng-star-inserted");

    By payDescriptionCost = By.cssSelector("app-payment-container span:nth-of-type(1)");
    By coloredDisabled = By.cssSelector("app-card-page button");
    By payDescriptionText = By.cssSelector("app-payment-container div:nth-child(2)");
    By numberCart = By.cssSelector("label.ng-tns-c46-1");
    By validityPeriod = By.cssSelector("label.ng-tns-c46-4");
    By cvc = By.cssSelector("label.ng-tns-c46-5");;
    By namePerson = By.cssSelector("label.ng-tns-c46-3");

    By visaPay = By.cssSelector(("img[src=\"assets/images/payment-icons/card-types/visa-system.svg\"]"));
    By mastercardPay = By.cssSelector(("img[src=\"assets/images/payment-icons/card-types/mastercard-system.svg\"]"));
    By belkartPay = By.cssSelector(("img[src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]"));

    public boolean isPaymentTitleVisible() {
        return driver.findElement(payTitle).isDisplayed();
    }

    public void switchToBepaidFrame() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(bepaidIframe));
        WebElement frame = driver.findElement(bepaidIframe);
        driver.switchTo().frame(frame);

    }
    public void waitPayTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(payTitle));
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
          //  System.out.println("Изображение Visa присутствует на странице.");
        }
    }

    public void displayedMastercard() {
        WebElement elementMastercard = driver.findElement(mastercardPay);
        if (elementMastercard.isDisplayed()) {
           // System.out.println("Изображение Mastercard присутствует на странице.");
        }
    }

    public void displayedBelkart() {
        WebElement elementBelkart = driver.findElement(belkartPay);
        if (elementBelkart.isDisplayed()) {
            //System.out.println("Изображение Belkart присутствует на странице.");
        }
    }
}