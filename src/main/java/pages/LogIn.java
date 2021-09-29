package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LogIn {
    WebDriver driver;
    WebDriverWait wait;
    public LogIn(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);

    }

    public WebElement email(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        return driver.findElement(By.id("identifierId"));
    }
    public WebElement emailNext(){
        return driver.findElement(By.id("identifierNext"));
    }
    public WebElement password(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        return driver.findElement(By.name("password"));
    }
    public WebElement submit(){
        return driver.findElement(By.id("passwordNext"));
    }
    public WebElement verifyPhone(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headingText")));
        return driver.findElement(By.id("headingText"));
    }

    public void logIn(String email, String password){
        email().sendKeys(email);
        emailNext().click();
        password().sendKeys(password);
        submit().click();


        String heading = verifyPhone().getText();




        if("Verify that it’s you".equals(heading)) {
            Assert.assertTrue(verifyPhone().getText().contentEquals("Verify that it’s you"));
            System.out.println("Sorry you need to verify you Mobile Number Manually.");
        }
        else {
            wait.until(ExpectedConditions.titleContains("Gmail"));
            Assert.assertTrue(driver.getTitle().contains("Gmail"));
            System.out.println("Login Sucessfull");
        }

    }

}
