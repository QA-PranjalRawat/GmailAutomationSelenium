package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogOut{
    WebDriver driver;
    WebDriverWait wait;
    public LogOut(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
    }

    public WebElement accountInfo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[aria-label*='john smith']")));
        return driver.findElement(By.cssSelector("a[aria-label*='john smith']"));
    }
    public WebElement signOutBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-label='Account Information']")));
        return driver.findElement(By.cssSelector("a#gb_71"));
    }


    public void logOut(){

        accountInfo().click();
        signOutBtn().click();

        wait.until(ExpectedConditions.titleContains("Gmail"));
        Assert.assertEquals(driver.getTitle(),"Gmail");
        System.out.println("---------------------");
        System.out.println("LogOut Successfully");
    }
}
