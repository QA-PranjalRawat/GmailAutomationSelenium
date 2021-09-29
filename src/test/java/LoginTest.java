import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn;
import pages.LogOut;

public class LoginTest extends BaseTest{
    //https://accounts.google.com/signin/v2/identifier?service=mail



    @Test
    public void loginTest(){
        LogIn login = new LogIn(driver);

        String email = "testingjohnsmith2021";
        String password = "testingjohn@123";

        login.logIn(email,password);


    }
    @Test(dependsOnMethods = {"loginTest"})
    public void logout(){
        LogOut logout = new LogOut(driver);
        logout.logOut();

    }

}
