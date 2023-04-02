package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperUser extends HelperBase {

   // public HelperUser(){}

    public void initLogin() {
        if (isHomePage()) {
            click(By.cssSelector("a[href='/login']"));
        }
    }



    public HelperUser(WebDriver wd){
        super(wd);
    }
    public void fillLogin(User user){
     String login= user.getEmail();
     type(By.id("user"), login);
}
public void submitLogin(){
        click(By.id("login"));
}


    public void fillPassword(User user){
        String password=user.getPassword();
        type(By.id("password"),password);
    }
public void submitPassword(){
        click(By.id("login-submit"));
}
public boolean isLogged(){
        pause(2000);
        return isElementPresent(By.className("OUdAuicP657Tka"));
}
public String getTextFromErrorEmailMessage(){
        return wd.findElement(By.cssSelector("p.error-message")).getText();
}

public String getTextFromErrorPasswordMessage(){
        return wd.findElement(By.cssSelector("span[class='css-xal9c7'] span")).getText();
}
public void logout(){
    //click
    if (isLogged())
    {
   // click(By.cssSelector("button[data-testid='header-member-menu-button']"));
        click(By.cssSelector("span[class='DweEFaF5owOe02 pMvTtmeStXaSEs rQ86P0iNikD4I9 Cg0RMJhBknTRbM']"));
        click(By.xpath("//button[@data-testid='account-menu-logout']"));
    //click --> _OHV1cSBxHNA1V
   // click(By.cssSelector("span[class='_OHV1cSBxHNA1V']"));
    //click
    click(By.id("logout-submit"));
    }
}
}
