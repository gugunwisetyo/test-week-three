package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskWeek3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        driver.get("https://juice-shop.herokuapp.com/#/login");
        System.out.println("Open URL");
        delay(1);
        //login
//        String warning = driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/h1/span")).getText();
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]")).click();
        delay(1);
        driver.findElement(By.id("email")).sendKeys("gugunwisetyo@gmail.com");
        driver.findElement(By.id("password")).sendKeys("@Gugun123");
        driver.findElement(By.id("loginButton")).click();
        delay(2);
        //validasi login
        String response = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[1]/div[1]")).getText();
        if (response.equalsIgnoreCase("all products")){
            System.out.println("Berhasil masuk");
        } else {
            System.out.println("Gagal masuk");
        }
        //add product apple juice
        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button")).click();
        delay(1);
        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]")).click();
        //validasi add product
        delay(3);
        String validasi = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-basket/mat-card/app-purchase-basket/mat-table/mat-row/mat-cell[2]")).getText();
        if (validasi.equalsIgnoreCase("Apple Juice (1000ml)")){
            System.out.println("Apple juice added");
        } else {
            System.out.println("Product not added");
        }
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
