package com.hillel.util;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils
{
    private WaitUtils() {}
    public static void waitUntilElementIsClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitUntilTextToBePresentInElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'ithillel.ua/')]")));
    }
    public static void waitUntilPresenceOfElementLocated(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span/strong[text() = 'QA Automation']")));

    }
    public static void waitUntilTextToBePresentInElementAndClickable(WebDriver driver, WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.withMessage("Page didn't load");

    }
}
