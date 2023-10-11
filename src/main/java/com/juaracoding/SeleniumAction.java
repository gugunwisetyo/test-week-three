package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SeleniumAction {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/menu");
        System.out.println("Open URL");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //action hover - https://demoqa.com/menu
        WebElement menuTwo = driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuTwo).perform();
        System.out.println("Mouse hover to menu item 2");

        //action drag and drop - https://demoqa.com/droppable
        driver.get("https://demoqa.com/droppable"); //ganti web di tab yg sama
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere = dragMe.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        actions.dragAndDrop(dragMe, dropHere).perform();
        System.out.println("Mouse drag and drop");

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
