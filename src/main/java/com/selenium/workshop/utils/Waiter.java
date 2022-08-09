package com.selenium.workshop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private static WebDriverWait wait;

    public static void waitUntilPresent(WebDriver driver, By locator) {
        wait = getWait(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, 10);
    }
}
