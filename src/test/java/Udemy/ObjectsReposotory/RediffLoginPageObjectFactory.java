package Udemy.ObjectsReposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPageObjectFactory {
    WebDriver driver;
    public RediffLoginPageObjectFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
     /*By Username = By.xpath("//input[@id='login1']");
     By Password = By.name("passwd");
     By SignIn = By.xpath("//input[@name='proceed']");
     By Home = By.linkText("rediff.com");*/
     @FindBy(xpath="//input[@id='login1']")
     WebElement Username;

     @FindBy( how= How.NAME, using ="passwd")
     WebElement Password;

     @FindBy(xpath="//input[@name='proceed']")
     WebElement SignIn;

     @FindBy(linkText = "rediff.com")
     WebElement Home;

     public void Emaild(){
        Username.sendKeys("hello");
     }
     public void Password(){
       Password.sendKeys("1234");
     }

    public void Submit(){
        SignIn.click();
    }
    public void Home(){
        Home.click();
    }
}
