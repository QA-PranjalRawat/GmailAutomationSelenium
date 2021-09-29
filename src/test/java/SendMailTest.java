import org.testng.annotations.Test;
import pages.CheckMailSent;
import pages.LogOut;
import pages.SendMail;

import java.util.Random;


public class SendMailTest extends BaseTest{

    Random random = new Random();

    String to="testingjohnsmith2021@gmail.com";
    String cc="cc@gmail.com";
    String bcc="bcc@gmail.com";
    int rand = random.nextInt(100);
    String subject=rand+"automatic new mail logout test";
    String message="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et" +
            " dolore magna aliqua. Non odio euismod lacinia at quis risus sed. Vulputate eu scelerisque felis imperdiet proin" +
            " fermentum. Vehicula ipsum a arcu cursus vitae congue. Ut aliquam purus sit amet. Sodales ut eu sem integer vitae" +
            " justo eget magna. Purus gravida quis blandit turpis cursus in hac habitasse platea. Quam nulla porttitor massa id " +
            "neque aliquam. Enim diam vulputate ut pharetra sit amet. Amet mauris commodo quis imperdiet massa tincidunt. Duis ut " +
            "diam quam nulla porttitor massa id neque aliquam. Accumsan lacus vel facilisis volutpat est velit egestas. At lectus" +
            " urna duis convallis convallis tellus id. Scelerisque fermentum dui faucibus in ornare. In arcu cursus euismod quis" +
            " viverra nibh cras pulvinar. Ut faucibus pulvinar elementum integer.";




    @Test
    public void login(){
        LoginTest login = new LoginTest();
        login.loginTest();
    }

    @Test(dependsOnMethods = {"login"})
    public void sendMailTest(){
        SendMail mail = new SendMail(driver);
        mail.sendMail(to,cc,bcc,subject,message);

    }

    @Test(dependsOnMethods = {"sendMailTest"})
    public void checkSentMail(){
        CheckMailSent checkMail = new CheckMailSent(driver);
        checkMail.checkMailSent(subject);
    }

    @Test(dependsOnMethods = {"checkSentMail"})
    public void logoutTest(){
        LogOut logout = new LogOut(driver);
        logout.logOut();
    }

}
