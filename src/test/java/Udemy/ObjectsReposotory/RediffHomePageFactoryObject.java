package Udemy.ObjectsReposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffHomePageFactoryObject {
    WebDriver driver;
    public RediffHomePageFactoryObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    /*By Search = By.cssSelector("#srchword");
    By Submit = By.xpath("//form[@id='queryTop']//input[@class='newsrchbtn']");*/
    @FindBy(css = "#srchword")
    WebElement Search;

    @FindBy(xpath = "//form[@id='queryTop']//input[@class='newsrchbtn']")
    WebElement Submit;

    public void Search(){
        Search.sendKeys("rediff");
    }

    public void Submit(){
        Submit.click();
    }


}
