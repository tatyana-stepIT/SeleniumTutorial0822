package com.selenium.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AdditionalKeys {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        driver.get("https://the-internet.herokuapp.com/key_presses");

        WebElement target = driver.findElement(By.id("target"));

        target.sendKeys(Keys.LEFT);

        target.sendKeys(Keys.chord(Keys.CONTROL, "A"));

        driver.quit();
    }
}
