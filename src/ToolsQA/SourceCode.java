package ToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class SourceCode {
    public static void main(String[] args) throws InterruptedException {
        //Install Webdriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 6);
        //Untuk menuju ke halaman web nya
        driver.get("https://demoqa.com/");
        //Verifikasi url yang sedang dibuka
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Go to url : " + actualUrl);
        Assert.assertEquals("https://demoqa.com/", actualUrl);
        System.out.println("MENUJU HALAMAN WEB DEMOQA");
        //Membuka Page Element
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
        System.out.println("MENUJU PAGE ELEMENT");
        //Mengisi Text Box
        driver.findElement(By.xpath("//*[@id=\"item-0\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("Faldi");
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("faldioberton17@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Antasari No.17");
        driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]")).sendKeys("Bekasi No.76");
       // driver.findElement(By.id("submit")).sendKeys(Keys.ARROW_DOWN);
       // driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        System.out.println("Mengisi Text Box");
        WebElement text = driver.findElement(By.xpath("//*[@id=\"output\"]/div"));
        String overview = text.getText();
        System.out.println(overview);
        //Check Box
        driver.findElement(By.id("item-1")).click();
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]")).click();
        //Radio Button
        driver.findElement(By.xpath("//*[@id=\"item-2\"]")).click();
        driver.findElement(By.id("yesRadio")).sendKeys(Keys.ENTER);

    }

}
