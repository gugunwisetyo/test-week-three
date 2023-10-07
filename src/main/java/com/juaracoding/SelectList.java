package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectList {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        System.out.println("Open URL");
        //scroll
        js.executeScript("window.scrollBy(0,300)");// scroll vertikal 300px

        //select
        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);
        Select pilihWarna = new Select(driver.findElement(By.id("oldSelectMenu")));
        pilihWarna.selectByValue("4");
        delay(2);
        pilihWarna.selectByVisibleText("blue");
        delay(2);
        pilihWarna.deselectByIndex(8);
        System.out.println("Pilih Warna Indigo");
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
