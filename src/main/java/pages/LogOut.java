package pages;

import org.openqa.selenium.*;
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-label*='Account Information']")));
        return driver.findElement(By.cssSelector("a#gb_71"));
    }


    public void logOut(){

        accountInfo().click();
        signOutBtn().click();


        try {
            // Check the presence of alert
            Alert alert = driver.switchTo().alert();

            alert.accept();
            System.out.println("Leave Site Error Encountered");

        } catch (Exception ex) {}

        wait.until(ExpectedConditions.titleContains("Gmail"));
        Assert.assertEquals(driver.getTitle(),"Gmail");
        System.out.println("---------------------");
        System.out.println("LogOut Successfully");
    }
}
