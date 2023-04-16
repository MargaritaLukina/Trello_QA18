package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser user;
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);

    public void init(){
        wd= new ChromeDriver();
        logger.info("Testing on Chrome Driver");
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new HelperUser(wd);

    }

    public HelperUser getUser(){
        return user;

    }

    public void stop(){

       // wd.quit();
    }

}
