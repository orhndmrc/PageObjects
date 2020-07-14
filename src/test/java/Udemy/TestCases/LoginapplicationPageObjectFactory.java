package Udemy.TestCases;

import Udemy.ObjectsReposotory.RediffHomePageFactoryObject;
import Udemy.ObjectsReposotory.RediffLoginPageObjectFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginapplicationPageObjectFactory {
    WebDriver driver;
    RediffHomePageFactoryObject rediffHomePageFactoryObject;//constructor to connect to RediffLoginPage pageobject class
    RediffLoginPageObjectFactory rediffLoginPageObjectFactory;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\PageObjects\\chromedriver.exe");
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        rediffHomePageFactoryObject= new RediffHomePageFactoryObject(driver);
        rediffLoginPageObjectFactory = new RediffLoginPageObjectFactory(driver);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void Login(){
        rediffLoginPageObjectFactory.Emaild();
        rediffLoginPageObjectFactory.Password();
        rediffLoginPageObjectFactory.Submit();
        rediffLoginPageObjectFactory.Home();
    }
    @Test(dependsOnMethods ="Login")
    public void Homepage() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#srchword")));
        rediffHomePageFactoryObject.Search();
        rediffHomePageFactoryObject.Submit();
    }
}
