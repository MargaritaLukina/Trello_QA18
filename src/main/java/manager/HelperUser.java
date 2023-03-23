package manager;

import models.User;
import org.openqa.selenium.WebDriver;


public class HelperUser extends HelperBase {

   // public HelperUser(){}

    public HelperUser(WebDriver wd){
        super(wd);
    }
    public void fillLogin(User user){
     String login= user.getEmail();
}

    public void fillPassword(User user){
        String password=user.getPassword();
    }

}
