package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.*;

public  class SeleniumTest {


    WebDriver driver=new ChromeDriver();
@Test
@DisplayName("Register")
  public  void Register()  {

    int numb = 1 ;

    driver.manage().window().maximize();

    driver.get("https://www.demoblaze.com/");


    driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
  driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys("Ahmad@gmail"+numb+".com");
   driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys("12345678");
   driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();

    System.out.println("Done");
    try {
        sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    Alert alert = driver.switchTo().alert();

    // Capturing alert message.
    String alertMessage= driver.switchTo().alert().getText();

    // Displaying alert message
    System.out.println(alertMessage);


    // Accepting alert
    alert.dismiss();



    try{

if ( alertMessage .equals("This user already exist.")){

    System.out.println("User already registered");

}
 else  Assert.assertNotNull(alertMessage);




    }catch (Exception e){
        System.out.println(e);
    }
    }

@Test
@DisplayName("Login")
    public void Login(){

        int numb = 1 ;

        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/");


        driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("Ahmad@gmail"+numb+".com");
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();




        try{

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Alert alert = driver.switchTo().alert();

            // Capturing alert message.
            String alertMessage= driver.switchTo().alert().getText();

            // Displaying alert message
            System.out.println(alertMessage);

        }catch (Exception e){
            System.out.println("Logged in Successfully");
            System.out.println(e);
        }
    }

    @Test
    @DisplayName( "Check the listed Categories has Items")
    public void checkLists() throws InterruptedException {
        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/");

        List<WebElement> products= driver.findElements(By.xpath("//*[@id=\"contcont\"]/div/div[1]/div"));

        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getText()+ "\n");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            products.get(i).click();
        }


    }



    @Test
    @DisplayName("Add random item to the cart")
    public void addToCart() throws InterruptedException {
        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/");
   List <WebElement> choose=  driver.findElements(By.xpath("//*[@id=\"tbodyid\"]"));

        sleep(1000);

        for (int i = 0; i < choose.size(); i++) {

        //   System.out.println(choose.get(i).getText()+ "\n");
            System.out.println(choose.get(i).getText()+ "\n");


//           Random random = new Random();
//           int randomProduct = random.nextInt(choose.size());



        }
    }


    @Test
    @DisplayName("Delete from cart")
    public void deleteFromCart() throws InterruptedException {

        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        sleep(1000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")).click();

        }

@Test
    @DisplayName("Checkout")
public void checkout() throws InterruptedException {
    driver.manage().window().maximize();

    driver.get("https://www.demoblaze.com/");
    driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    sleep(1000);

    driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    sleep(1000);
    driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Ahmad Qadoura");
    driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("Jordan");
    driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Amman");
    driver.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys("5112248451235448");
    driver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys("03");
    driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys("2025");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    driver.findElement(By.xpath(" //*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
    sleep(1000);
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[10]/div[7]/div/button")));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();


}







}










