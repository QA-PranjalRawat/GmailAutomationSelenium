package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CountUnreadMsg {
    private final WebDriverWait wait;
    private int count=0;
    private int total=0;

    public CountUnreadMsg(WebDriver driver){
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "div[class='UI'] table tr.zE")
    public List<WebElement> countUnread;

    @FindBy(css = "div.aeH>div:last-child div[aria-label='Older']")
    public WebElement NextList;

    @FindBy(css = "div[aria-label='Show more messages'] .Dj>.ts")
    public WebElement TotalMsg;





    public void countMsg(){
        count += countUnread.size();
    }



    public int initCountMsg() throws InterruptedException {
        countMsg();
        total = Integer.parseInt(TotalMsg.getText());
        int i = total;
        i = i/50;
        while(i>0){
            NextList.click();
            Thread.sleep(2000);
            countMsg();
            i--;
        }
        System.out.println("Total Count of Unread Messages : " + count);
        return count;
    }
}
