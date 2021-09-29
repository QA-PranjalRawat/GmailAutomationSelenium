package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class UnreadMessage {

    private final WebDriverWait wait;

    public UnreadMessage(WebDriver driver){
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div[data-tooltip='Inbox'] span+div")
    public WebElement totalUnreadMsg;

    public int unreadmsgPage(){
        String totalUnreadstr;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-tooltip='Inbox'] span")));
        try{
            totalUnreadstr = totalUnreadMsg.getText();
        }
        catch (Exception e){
            totalUnreadstr = "0";
        }
        int totalUnread = Integer.parseInt(totalUnreadstr);
        System.out.println("Total Unread Mails : "+totalUnread);
        return totalUnread;
    }
}



