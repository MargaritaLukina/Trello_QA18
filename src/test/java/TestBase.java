import manager.ApplicationManager;
import manager.NGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


@Listeners(NGListener.class)
public class TestBase {

    public static ApplicationManager app=new ApplicationManager();

    Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void setDown(){
        app.stop();
    }
}
