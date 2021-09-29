import org.testng.annotations.Test;
import pages.CountUnreadMsg;
import pages.LogIn;
import pages.LogOut;

public class CountUnreadTest extends BaseTest {

    @Test
    public void loginTest() {
        LogIn test = new LogIn(driver);

        String email = "testingjohnsmith2021";
        String password = "testingjohn@123";

        test.logIn(email, password);
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void CountUnreadMsg() throws InterruptedException {
        CountUnreadMsg countMsg = new CountUnreadMsg(driver);
        int count = countMsg.initCountMsg();
    }
    @Test(dependsOnMethods = {"CountUnreadMsg"})
    public void logout(){
        LogOut logout = new LogOut(driver);
        logout.logOut();

    }
}
