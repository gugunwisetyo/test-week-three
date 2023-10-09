package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class HandlingWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        System.out.println("Open URL");

        //handling window
        driver.findElement(By.id("tabButton")).click();
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        String newTab = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(newTab);

        driver.switchTo().window(tab.get(0));
        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);

        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }

    static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
