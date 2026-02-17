package utilities;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class Utility {
    public static WebDriver driver;
    public static Wait<WebDriver> wait;

    public static void setUtilityDriver() {
        Utility.driver = BasePage.driver;
        Utility.wait = BasePage.wait;
    }
}
