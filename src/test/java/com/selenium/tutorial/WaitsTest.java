package com.selenium.tutorial;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitsTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        // Initialize webdriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown(){
        // Close all tabs
        driver.quit();
    }

    @Test
    public void testImplicitWait(){
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        WebElement element = driver.findElement(By.name("q"));
    }

    @Test
    public void testExplicitWait(){
        driver.get("https://www.google.com");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("q"))));
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("q")));
    }

    @Test
    public void testFluentWait() {
        driver.get("https://www.google.com");
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(600))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.name("q"));
            }
        });
    }
}
