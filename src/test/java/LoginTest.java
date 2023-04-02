import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginPositiveTest(){

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

}
