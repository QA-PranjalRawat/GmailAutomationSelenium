package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class SignUp{
    WebDriver driver;

    public SignUp(WebDriver driver){
        this.driver=driver;
    }

    public WebElement firstname(){
        return driver.findElement(By.id("firstName"));
    }
    public WebElement lastname(){
        return driver.findElement(By.id("lastName"));
    }
    public WebElement username(){
        return driver.findElement(By.id("username"));
    }
    public WebElement password(){
        return driver.findElement(By.name("Passwd"));
    }
    public WebElement confirmPassword(){
        return driver.findElement(By.name("ConfirmPasswd"));
    }
    public WebElement submit(){
        return driver.findElement(By.id("accountDetailsNext"));
    }
    public WebElement verifyPhone(){
            return driver.findElement(By.id("headingText"));
    }

    public void signUpTest(String firstname, String lastname,String username, String password){
        firstname().sendKeys(firstname);
        lastname().sendKeys(lastname);
        username().sendKeys(username);
        password().sendKeys(password);
        confirmPassword().sendKeys(password);
        submit().click();

        try{
            Thread.sleep(3000);
            String heading = verifyPhone().getText();
            System.out.println("Sorry you need to enter your Mobile Number and continue Manually.");
            System.out.println(heading);
            Assert.assertEquals("Verifying your phone number",heading);
        }
        catch (Exception e){

        }

    }
}
