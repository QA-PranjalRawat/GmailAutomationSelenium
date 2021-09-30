import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.CountUnreadMsg;
import pages.LogIn;
import pages.LogOut;
import pages.UnreadMessage;

public class VerifyUnreadMsgTest extends BaseTest{
    int countUnread;
    int totalUnreadMessage;


    @Test
    public void loginTest() {
        LogIn test = new LogIn(driver);

        String email = "testingjohnsmith2021";
        String password = "testingjohn@123";

        test.logIn(email, password);
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void unreadMsgTest() {
        UnreadMessage unread = new UnreadMessage(driver);
        totalUnreadMessage = unread.unreadmsgPage();
    }

    @Test(dependsOnMethods = {"unreadMsgTest"})
    public void countUnreadMsgTest() {
        CountUnreadMsg countMsg = new CountUnreadMsg(driver);
        countUnread = countMsg.initCountMsg();
    }
    @Test(dependsOnMethods = {"countUnreadMsgTest"})
    public void logoutTest(){
        LogOut logout = new LogOut(driver);
        logout.logOut();
    }
    @AfterClass
    public void verify(){
        Assert.assertEquals(countUnread,totalUnreadMessage);
    }

}
