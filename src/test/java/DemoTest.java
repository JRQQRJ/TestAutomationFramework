import com.automationbytarun.*;
import com.automationbytarun.components.DataProviderArgs;
import com.automationbytarun.components.DataProviderUtils;
import org.testng.annotations.Test;

public class DemoTest {

    @DataProviderArgs("demoTest= username,password")
    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = "jsonDataProvider")
    public void demoTest(String username, String password){
        System.out.println(username + " " + password);
    }
}
