package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMail{
    WebDriver driver;
    WebDriverWait wait;

    public SendMail(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
    }

    public WebElement compose(){
        wait.until(ExpectedConditions.elementToBeClickable(By.className("T-I-KE")));
        return driver.findElement(By.className("T-I-KE"));
    }
    public WebElement to(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
        return driver.findElement(By.name("to"));
    }
    public WebElement cc(){
        driver.findElement(By.className("pE")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cc")));
        return driver.findElement(By.name("cc"));
    }
    public WebElement bcc(){
        driver.findElement(By.className("pB")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("bcc")));
        return driver.findElement(By.name("bcc"));
    }
    public WebElement subject(){
        return driver.findElement(By.name("subjectbox"));
    }
    public WebElement message(){
        return driver.findElement(By.className("editable"));
    }
    public WebElement send(){ return driver.findElement(By.className("aoO")); }


    public void sendMail(String to, String cc, String bcc, String subject, String message){
        compose().click();
        to().sendKeys(to);
        cc().sendKeys(cc);
        bcc().sendKeys(bcc);
        subject().sendKeys(subject);
        message().sendKeys(message);
        send().click();



    }
}
