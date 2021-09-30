package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class CheckMailSent{
    WebDriver driver;
    WebDriverWait wait;

    public CheckMailSent(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,10);
    }

    public WebElement clickSent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.aHS-bnu")));
        return driver.findElement(By.cssSelector("div.aHS-bnu"));
    }
    public WebElement lastMail(){
        wait.until(ExpectedConditions.titleContains("Sent Mail"));
        return driver.findElement(By.cssSelector(".AO .BltHke.nH.oy8Mbf:last-child table tr:nth-of-type(1)"));
    }



    public void checkMailSent(String subject){
        clickSent().click();

        lastMail().click();

        wait.until(ExpectedConditions.titleContains(subject));
        Assert.assertTrue(driver.getTitle().contains(subject));
        System.out.println("------------------");
        System.out.println("Message has been successfully sent.");
    }
}
