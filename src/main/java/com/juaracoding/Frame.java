package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");
        System.out.println("Open URL");

        //frame
        WebElement frameOne = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameOne);
        String txtFrame = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtFrame);
        //kembali ke default content
        driver.switchTo().defaultContent();
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
