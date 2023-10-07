package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebTable {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/webtables");
        System.out.println("Open URL");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //scraping
        String title = driver.getTitle();
        System.out.println(title);
        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);

        //add data
//        driver.findElement(By.id("addNewRecordButton")).click();
//        driver.findElement(By.cssSelector("#firstName")).sendKeys("Juara Coding");
//        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Juara");
//        driver.findElement(By.id("userEmail")).sendKeys("admin@juaracoding.com");
//        driver.findElement(By.id("age")).sendKeys("25");
//        driver.findElement(By.id("salary")).sendKeys("6000");
//        driver.findElement(By.id("department")).sendKeys("QA Engineer");
//        driver.findElement(By.id("submit")).click();
//        System.out.println("add data");

        //check box
//        driver.get("https://demoqa.com/checkbox");
//        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button/svg")).click();
//        //checklist desktop dan download
//        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button/svg")).click();
//        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button/svg")).click();
//        System.out.println("checkbox");

        //klik salah satu radio button lalu lakukan scraping
        driver.get("https://demoqa.com/radio-button");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")).click();
        String response = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")).getText();
        System.out.println(response);
        //compare ketika txt = impressive maka hasilnya passed
        if (response.contains("Impressive")){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        System.out.println("radio button");


        //delay
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Quit Browser");
    }
}
