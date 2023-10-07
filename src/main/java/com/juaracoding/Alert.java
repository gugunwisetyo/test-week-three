package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        System.out.println("Open URL");

        //scraping
        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);

        //alert
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.id("timerAlertButton")).click();
        delay(5);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("Juara Coding");
        driver.switchTo().alert().accept();
        System.out.println("Alert send keys");

        //delay
        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
