package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendMail{
    WebDriver driver;

    public SendMail(WebDriver driver){
        this.driver=driver;
    }

    public WebElement compose(){
        return driver.findElement(By.className("T-I-KE"));
    }
    public WebElement to(){
        return driver.findElement(By.name("to"));
    }
    public WebElement cc(){
        driver.findElement(By.className("pE")).click();
        return driver.findElement(By.name("cc"));
    }
    public WebElement bcc(){
        driver.findElement(By.className("pB")).click();
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
