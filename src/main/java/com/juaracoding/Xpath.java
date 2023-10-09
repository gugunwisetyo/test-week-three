package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Xpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Open URL");

        //----
        delay(2);
        List<WebElement> listTagInput = driver.findElements(By.xpath("//input[@class='oxd-input oxd-input--active']"));
        // //input[@class='oxd-input oxd-input--active']
        delay(2);
        System.out.println(listTagInput.size());
        delay(2);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        delay(2);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        delay(2);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        delay(2);
        String dashboard = driver.findElement(By.xpath("//h6[contains(@class, 'header-breadcrumb')]")).getText();
        System.out.println(dashboard);

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
