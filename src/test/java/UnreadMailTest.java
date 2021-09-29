import org.testng.annotations.Test;
import pages.LogIn;
import pages.LogOut;
import pages.UnreadMessage;
public class UnreadMailTest extends BaseTest {

    @Test
    public void loginTest() {
        LogIn test = new LogIn(driver);

        String email = "testingjohnsmith2021";
        String password = "testingjohn@123";

        test.logIn(email, password);
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void unreadMsgTest () {
        UnreadMessage unread = new UnreadMessage(driver);
        int totalUnreadMessage = unread.unreadmsgPage();
    }
    @Test(dependsOnMethods = {"unreadMsgTest"})
    public void logout(){
        LogOut logout = new LogOut(driver);
        logout.logOut();

    }

}
