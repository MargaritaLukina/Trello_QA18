import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void aloginPositiveTest(){

       // logger.info("Login Positive Test Started");

        User user = User.builder().email("hatum.testing@gmail.com").password("Hatum21$").build();
        // initLoginform
        app.getUser().initLogin();
        //fillloginform
        app.getUser().fillLogin(user);
        //submitloginform
        app.getUser().submitLogin();
        //assert
        app.getUser().pause(2000);
        app.getUser().fillPassword(user);
        app.getUser().submitPassword();
        //app.getUser().submitLogin();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isElementPresent(By.className("OUdAuicP657Tka")));
       // app.getUser().returnToHome();
        app.getUser().logout();
        app.getUser().pause(2000);
       // logger.info("Login Positive Test Completed");
    }
    @Test
    public void loginNegativeWrongEmailTest(){
        User user=User.builder().email("hatumtestinggmail.com").password("Hatum21$").build();
        app.getUser().initLogin();
        app.getUser().fillLogin(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        app.getUser().fillPassword(user);
        //app.getUser().submitPassword();
        app.getUser().submitLogin();
        Assert.assertFalse(app.getUser().isLogged());
        Assert.assertTrue(app.getUser().getTextFromErrorEmailMessage().contains("There isn't an account for this username") );
        //<p class="error-message">There isn't an account for this username</p>
        app.getUser().returnToHome();

    }

    @Test
    public void loginNegativeWrongPasswordTest(){
        User user = User.builder().email("hatum.testing@gmail.com").password("Hatum").build();
        app.getUser().initLogin();
        app.getUser().fillLogin(user);
        app.getUser().submitLogin();
        // --> atlassian
        app.getUser().pause(2000);
        app.getUser().fillPassword(user);
        app.getUser().submitPassword();
        app.getUser().pause(2000);

        Assert.assertFalse(app.getUser().isLogged());
        Assert.assertTrue(app.getUser().getTextFromErrorPasswordMessage().contains("Incorrect email address and / or password.") );
        app.getUser().returnToHome();
    }

}
