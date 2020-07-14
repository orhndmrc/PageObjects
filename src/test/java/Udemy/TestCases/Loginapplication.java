package Udemy.TestCases;

import Udemy.ObjectsReposotory.RediffHomePage;
import Udemy.ObjectsReposotory.RediffLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Loginapplication {
    WebDriver driver;
    RediffLoginPage rediffLoginPage;//constructor to connect to RediffLoginPage pageobject class
    RediffHomePage rediffHomePage;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\PageObjects\\chromedriver.exe");
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
          rediffLoginPage= new RediffLoginPage(driver);
          rediffHomePage = new RediffHomePage(driver);

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void Login(){
    rediffLoginPage.Emaild().sendKeys("hello");
    rediffLoginPage.Password().sendKeys("1234");
    rediffLoginPage.Submit().click();
    rediffLoginPage.Home().click();
    }
    @Test(dependsOnMethods ="Login")
    public void Homepage() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#srchword")));
        rediffHomePage.Search().sendKeys("rediff");
        rediffHomePage.Submit().click();
    }
}
