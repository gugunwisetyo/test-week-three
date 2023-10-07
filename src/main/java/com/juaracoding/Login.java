package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Open URL");
        delay(2);
        driver.findElement(By.name("username")).sendKeys("Admin");
        delay(2);
        driver.findElement(By.name("password")).sendKeys("admin123");
        delay(2);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        delay(2);
        String response = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
        if (response.contains("Dashboard")){
            System.out.println("Berhasil Masuk");
        } else {
            System.out.println("Gagal Masuk");
        }
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
