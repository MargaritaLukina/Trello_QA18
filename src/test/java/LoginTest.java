import models.User;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void loginPositiveTest(){

        User user = User.builder().email("hatum.testing@gmail.com").password("Hatum21$").build();
    }

}
