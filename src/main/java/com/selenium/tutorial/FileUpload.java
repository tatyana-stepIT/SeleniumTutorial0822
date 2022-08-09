package com.selenium.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement fileUpload = driver.findElement(By.id("file-upload"));

        try {
        fileUpload.sendKeys("C:\\Users\\new\\IdeaProjects\\SeleniumTutorial\\src\\main\\resources\\uploaded");
        driver.findElement(By.id("file-submit")).click();
        } finally {
            driver.quit();
        }
    }
}
