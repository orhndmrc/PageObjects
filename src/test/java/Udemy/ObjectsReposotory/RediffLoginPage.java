package Udemy.ObjectsReposotory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
    WebDriver driver;
    public RediffLoginPage(WebDriver driver){
        this.driver = driver;
    }
     By Username = By.xpath("//input[@id='login1']");
     By Password = By.name("passwd");
     By SignIn = By.xpath("//input[@name='proceed']");
     By Home = By.linkText("rediff.com");


     public WebElement Emaild(){
         return driver.findElement(Username);
     }
     public WebElement Password(){
         return driver.findElement(Password);
     }

    public WebElement Submit(){
        return driver.findElement(SignIn);
    }
    public WebElement Home(){
        return driver.findElement(Home);
    }
}
